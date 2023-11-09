package dev.memocode.chatservice.websocket.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "custom.stomp.relay")
public class StompBrokerReplayProperties {
    private final String host;
    private final Integer port;
    private final String clientUsername;
    private final String clientPassword;
    private final String systemUsername;
    private final String SystemPassword;
}
