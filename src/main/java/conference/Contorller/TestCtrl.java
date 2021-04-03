package conference.Contorller;

import com.fasterxml.jackson.core.JsonProcessingException;
import conference.service.KafkaSendService;
import conference.service.MessagePushService;
import conference.service.SSEEmitterService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListenerAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Properties;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 16:06
 *
 * @version 1.0
 */
@RestController
public class TestCtrl {
    final
    MessagePushService messagePushService;
    final
    KafkaSendService kafkaSendService;

    SseEmitter sseEmitter = new SseEmitter(1000L);
    public TestCtrl(MessagePushService messagePushService, KafkaSendService kafkaSendService) {
        this.messagePushService = messagePushService;
        this.kafkaSendService = kafkaSendService;
    }

    @GetMapping("/testPushMessage")
    public String testPushMessage(){
        messagePushService.pushMessageToWechat("ssss");
        System.out.println("thread id :"+Thread.currentThread().getId());
        return "OK";
    }

    @GetMapping(value = "/kafka")
    public String testKafka(String mes) throws JsonProcessingException {
        kafkaSendService.sendMessage(mes);
        return "OK";
    }

    @GetMapping("/kkk")
    public SseEmitter connect(){
        return  SSEEmitterService.connect("1");
    }

//    @RequestMapping(value = "/event", produces = "text/event-stream;charset=UTF-8")
    @GetMapping("/event")
    public void  pushEvent() throws InterruptedException, IOException {//没成功

        Properties props = new Properties();
        // 定义kakfa 服务的地址，不需要将所有broker指定上
        props.put("bootstrap.servers", "159.75.52.204:9092");
        // 制定consumer group
        props.put("group.id", "czy3");
        // 是否自动确认offset
        props.put("enable.auto.commit", "true");
        // 自动确认offset的时间间隔
        props.put("auto.commit.interval.ms", "100");
        // key的序列化类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // value的序列化类
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // 定义consumer

        KafkaConsumer<String,String> consumer=new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singletonList("testTopic"));
        // 读取数据，读取超时时间为100ms
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                String mes = "null";
                for (ConsumerRecord<String, String> record : records) {
                    mes = String.format("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
                SSEEmitterService.sendMessage("1",mes);

            }
        } finally {
            consumer.close();
        }

//        Thread                 .sleep(500);
//        return "retry:1000\ndata:" +mes + "\n\n";
    }
}
