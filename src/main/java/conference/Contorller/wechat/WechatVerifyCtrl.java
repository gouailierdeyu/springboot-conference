package conference.Contorller.wechat;

import conference.property.MpProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import conference.Utils.wechat.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * UTF-8
 * Created by czy  Time : 2020/10/28 20:24
 *
 * @version 1.0
 */
@Controller
@RequestMapping("/mp")
public class WechatVerifyCtrl {
    @Autowired
    MpProperty mpProperty;

    @GetMapping
    @ResponseBody
    public String verify(@RequestParam("signature")String signature,
                         @RequestParam("timestamp")String timestamp,
                         @RequestParam("nonce")String nonce,
                         @RequestParam("echostr")String echostr) throws Exception{
        String calsign=SHA1.getSHA1(mpProperty.getToken(),timestamp,nonce,"");
       if (calsign.equals(signature)) {
           return echostr;
       }
       return null;
    }

    @PostMapping
    @ResponseBody
    public String responseMessage(@RequestBody String s) throws IOException, SAXException {
        String mess="success";
        String fromUserName=XMLParse.extractFromUserName(s);
        String toUserName = XMLParse.extractToUserName(s);
        LocalDateTime now = LocalDateTime.now();
        long time=now.toEpochSecond(ZoneOffset.ofHours(8));
        if (now.getHour()>20)
        {
            mess=XMLParse.generateText(toUserName,fromUserName,time,"好好休息，明天又是快乐的一天呢！");
        }else if (now.getHour()<5){
            mess=XMLParse.generateText(toUserName,fromUserName,time,"还不睡觉，你要变丑了！");
        }else if(5<=now.getHour()&&now.getHour()<10) {
            mess=XMLParse.generateText(toUserName,fromUserName,time,"早安，打工人！打工人，打工魂，打工都是人上人！");
        }else if(13<=now.getHour()&&now.getHour()<14){
            mess=XMLParse.generateText(toUserName,fromUserName,time,"午休时间到了，快睡觉吧，嘻嘻！");
        }else {
            mess=XMLParse.generateText(toUserName,fromUserName,time,"你好啊，嘻嘻");
        }
        return mess;
    }
}
