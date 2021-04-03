package conference.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/25 10:16
 *
 * @version 1.0
 */

/**
 * 两个线程独立执行，因为打印顺序是乱的
 * 每次输出顺序不一定
 */
@Component
public class KafkaMessageReceive {
    @KafkaListener(topics = {"testTopic"},groupId = "czy")
    public void receiveMessage(ConsumerRecord<String,String> consumerRecord ){
        System.out.println("1=== thread id "+Thread.currentThread().getId());
        System.out.println("1=== topic "+ consumerRecord.topic());
        System.out.println("1=== key "+consumerRecord.key());
        System.out.println("1=== value "+consumerRecord.value());
        System.out.println("1=== "+consumerRecord);
    }

    @KafkaListener(topics = {"testTopic"},groupId = "czy2")
    public void receiveMessage2(ConsumerRecord<String,String> consumerRecord){
        System.out.println("2=== thread id "+Thread.currentThread().getId());
        System.out.println("2=== topic "+ consumerRecord.topic());
        System.out.println("2=== key "+consumerRecord.key());
        System.out.println("2=== value "+consumerRecord.value());
        System.out.println("2=== "+consumerRecord);
    }

    @KafkaListener(topics = {"testTopic"},groupId = "czy3")
    public void receiveMessage3(ConsumerRecord<String,String> consumerRecord){
        if (WebSocketService.clients!=null && !WebSocketService.clients.isEmpty()){
            WebSocketService.clients.forEach((key ,value)->{
                        value.sendMessage(consumerRecord.value());
            });
        }
        System.out.println("3=== thread id "+Thread.currentThread().getId());
        System.out.println("3=== topic "+ consumerRecord.topic());
        System.out.println("3=== key "+consumerRecord.key());
        System.out.println("3=== value "+consumerRecord.value());
        System.out.println("3=== "+consumerRecord);
    }

}
