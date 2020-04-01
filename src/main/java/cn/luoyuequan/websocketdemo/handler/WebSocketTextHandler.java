package cn.luoyuequan.websocketdemo.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p></p>
 *
 * @author luoyuequan
 * @date 2020/03/02
 * @time 14:41
 */
public class WebSocketTextHandler extends TextWebSocketHandler {
    private Map<Object, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    /**
     * process message
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String response = String.format("%s send message:%s", session.getId(), message.getPayload());
        for (Map.Entry<Object, WebSocketSession> entry : sessionMap.entrySet()) {
//            if (session.getId().equals(entry.getKey())) {
//                continue;
//            }
            entry.getValue().sendMessage(message);
        }
    }

    /**
     * 建立连接后
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        String uri = Objects.requireNonNull(session.getUri()).toString();
//        String response = String.format("%s connected,%s", session.getId(),
//                uri.substring(uri.lastIndexOf("/") + 1));
//        for (Map.Entry<Object, WebSocketSession> entry : sessionMap.entrySet()) {
//            entry.getValue().sendMessage(new TextMessage(response));
//        }
        sessionMap.put(session.getId(), session);
    }

    /**
     * 处理运输错误
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    /**
     * 连接关闭后
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
//        String response = String.format("%s closed", session.getId());
//        for (Map.Entry<Object, WebSocketSession> entry : sessionMap.entrySet()) {
//            entry.getValue().sendMessage(new TextMessage(response));
//        }
    }
}
