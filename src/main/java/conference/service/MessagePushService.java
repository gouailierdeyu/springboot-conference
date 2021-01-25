package conference.service;

import conference.message.WechatPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 15:55
 *
 * @version 1.0
 */
@Service
@Async(value = "messagePool")
public class MessagePushService {
    final
    WechatPush wechatPush;

    public MessagePushService(WechatPush wechatPush) {
        this.wechatPush = wechatPush;
    }


    public void pushMessageToWechat(String mes){
        wechatPush.pushMessgae(mes);
    }
}
