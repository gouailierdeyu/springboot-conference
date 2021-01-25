package conference.message;

import org.springframework.stereotype.Service;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 16:01
 *
 * @version 1.0
 */
@Service
public class WechatPush {

    public void pushMessgae(String mes){
        System.out.println(mes);
        System.out.println("WechatPush thread id :"+Thread.currentThread().getId());
    }
}
