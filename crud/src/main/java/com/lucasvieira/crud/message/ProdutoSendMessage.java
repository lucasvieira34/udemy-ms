package com.lucasvieira.crud.message;

import com.lucasvieira.crud.data.vo.ProdutoVO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProdutoSendMessage {

    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("${crud.rabbitmq.routingKey}")
    String routingKey;

    public final RabbitTemplate rabbitTemplate;

    public ProdutoSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(ProdutoVO produtoVO) {
        rabbitTemplate.convertAndSend(exchange, routingKey, produtoVO);
    }

}
