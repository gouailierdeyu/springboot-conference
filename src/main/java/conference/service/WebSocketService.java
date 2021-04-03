package conference.service;

import io.netty.util.internal.ConcurrentSet;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * UTF-8
 * Created by czy  Time : 2021/2/3 10:21
 *
 * @version 1.0
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocketService {
    /**
     * 存放所有在线的客户端
     */
    public static Map<String, WebSocketService> clients = new ConcurrentHashMap<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println(session.getId());
        //将新用户存入在线的组
        clients.put(session.getId(), this);
    }

    /**
     * 客户端关闭
     * @param session session
     */
    @OnClose
    public void onClose(Session session) {

        //将掉线的用户移除在线的组里
        clients.remove(session.getId());
    }

    /**
     * 发生错误
     * @param throwable e
     */
    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * 收到客户端发来消息
     * @param message  消息对象
     */
    @OnMessage
    public void onMessage(String message) {

        this.sendAll(message);
    }

    /**
     * 群发消息
     * @param message 消息内容
     */
    private void sendAll(String message) {
        for (Map.Entry<String, WebSocketService> sessionEntry : clients.entrySet()) {
            sessionEntry.getValue().session.getAsyncRemote().sendText(message);
        }
    }

    public void sendMessage(String message)  {
        try {
            this.session.getBasicRemote().sendText(message);
        }catch (Exception e){
            e.printStackTrace();
        }

        //this.session.getAsyncRemote().sendText(message);
    }
}

