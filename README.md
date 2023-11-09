# 도커로 RabbitMQ 실행 방법
```bash
docker run -d --name rabbitmq \
  -p 5672:5672 -p 15672:15672 -p 61613:61613 \
  -e RABBITMQ_DEFAULT_USER=user \
  -e RABBITMQ_DEFAULT_PASS=1234 \
  rabbitmq:3-management
```

# STOMP 플러그인 실행 방법
```bash
docker exec rabbitmq rabbitmq-plugins enable rabbitmq_stomp
```