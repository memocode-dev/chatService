## 1. stomp가 설치된 rabbitmq 이미지 만들기
- 도커파일
    ```dockerfile
    FROM rabbitmq:3.11.16-management
    RUN rabbitmq-plugins enable rabbitmq_stomp
    COPY rabbitmq.conf /etc/rabbitmq/rabbitmq.conf
    ```
- rabbitmq.conf 파일
    ```conf
    loopback_users = none
    listeners.tcp.default = 5672
    default_pass = admin
    default_user = admin
    hipe_compile = false
    management.listener.port = 15672
    management.listener.ssl = false
    stomp.listeners.tcp.1 = 61613
    stomp.default_user = admin
    stomp.default_pass = admin
    ```
- 빌드하기
    ```bash
    docker build -t local/rabbitmq:0.1 .
    ```

## 실행 명령어
```bash
docker run -d --name rabbitmq \
  -p 5672:5672 -p 15672:15672 -p 61613:61613 \
  local/rabbitmq:0.1
```
