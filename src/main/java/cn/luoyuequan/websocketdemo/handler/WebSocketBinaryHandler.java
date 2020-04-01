package cn.luoyuequan.websocketdemo.handler;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * binary data
 * </p>
 *
 * @author luoyuequan
 * @date 2020/03/30
 * @time 11:19
 */
public class WebSocketBinaryHandler extends BinaryWebSocketHandler {
    private Map<Object, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        System.out.println(message);
        for (Map.Entry<Object, WebSocketSession> entry : sessionMap.entrySet()) {
//            if (session.getId().equals(entry.getKey())) {
//                continue;
//            }
            entry.getValue().sendMessage(message);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(session.getId());
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(session.getId());
        sessionMap.remove(session.getId());
    }
}
