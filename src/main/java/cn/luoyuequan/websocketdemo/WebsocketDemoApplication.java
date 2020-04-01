package cn.luoyuequan.websocketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
public class WebsocketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketDemoApplication.class, args);
    }

}
