package conference.Contorller;

import com.fasterxml.jackson.core.JsonProcessingException;
import conference.service.KafkaSendService;
import conference.service.MessagePushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
