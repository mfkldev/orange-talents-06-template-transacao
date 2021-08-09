package br.com.zupacademy.marciosouza.transacao.kafka;

import br.com.zupacademy.marciosouza.transacao.model.TransactionModel;
import br.com.zupacademy.marciosouza.transacao.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransactionRepository transactionRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransactionModel transactionModel) {
        transactionRepository.save(transactionModel);
    }
}