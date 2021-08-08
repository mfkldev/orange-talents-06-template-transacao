package br.com.zupacademy.marciosouza.transacao.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransactionMessage transactionMessage) {
        System.out.println(transactionMessage);
    }
}