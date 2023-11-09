package dev.memocode.chatservice.websocket.config;

import dev.memocode.chatservice.websocket.properties.StompBrokerReplayProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
@EnableConfigurationProperties(StompBrokerReplayProperties.class)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final StompBrokerReplayProperties replayProperties;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        /**
         * prefix가 /topic, /queue 둘 중에 하나는 등록을 시켜야 함
         */
        config.enableStompBrokerRelay("/topic")
                .setRelayHost(replayProperties.getHost()) // host
                .setRelayPort(replayProperties.getPort()) // rabbitmq stomp port number
                .setClientLogin(replayProperties.getClientUsername()) // 사용자가 사용하는 아이디
                .setClientPasscode(replayProperties.getClientPassword()) // 사용자가 사용하는 비밀번호
                .setSystemLogin(replayProperties.getSystemUsername()) // 서버가 사용하는 아이디
                .setSystemPasscode(replayProperties.getSystemPassword()); // 서버가 사용하는 비밀번호
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws");
    }
}
