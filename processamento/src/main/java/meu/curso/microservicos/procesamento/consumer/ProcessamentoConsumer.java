package meu.curso.microservicos.procesamento.consumer;

import meu.curso.microservicos.procesamento.dto.PeditoDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProcessamentoConsumer {

    @RabbitListener(queues = "${broker.queue.processamento.name}")
    public void listenerProcessamentoQueue(PeditoDTO peditoDTO) {
        System.out.println(peditoDTO);
    }
}
