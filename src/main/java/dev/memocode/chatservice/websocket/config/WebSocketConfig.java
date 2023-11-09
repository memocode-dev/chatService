package dev.memocode.chatservice.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        /**
         * prefix가 /topic, /queue 둘 중에 하나는 등록을 시켜야 함
         */
        config.enableStompBrokerRelay("/topic")
                .setRelayHost("localhost") // host
                .setRelayPort(61613) // rabbitmq stomp port number
                .setClientLogin("admin") // 사용자가 사용하는 아이디
                .setClientPasscode("admin") // 사용자가 사용하는 비밀번호
                .setSystemLogin("admin") // 서버가 사용하는 아이디
                .setSystemPasscode("admin"); // 서버가 사용하는 비밀번호
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws");
    }
}
