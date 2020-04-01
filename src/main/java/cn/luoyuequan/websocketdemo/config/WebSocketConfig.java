package cn.luoyuequan.websocketdemo.config;

import cn.luoyuequan.websocketdemo.handler.WebSocketBinaryHandler;
import cn.luoyuequan.websocketdemo.handler.WebSocketTextHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * <p>
 * start WebSocket provider
 * </p>
 *
 * @author luoyuequan
 * @date 2020/03/02
 * @time 11:56
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketTextHandler(), "/video")
                .addHandler(webSocketBinaryHandler(), "/web/binary")
                .addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("*");
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }

    @Bean
    public WebSocketTextHandler webSocketTextHandler() {
        return new WebSocketTextHandler();
    }

    @Bean
    public WebSocketBinaryHandler webSocketBinaryHandler() {
        return new WebSocketBinaryHandler();
    }
}
