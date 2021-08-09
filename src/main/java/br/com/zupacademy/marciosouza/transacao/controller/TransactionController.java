package br.com.zupacademy.marciosouza.transacao.controller;

import br.com.zupacademy.marciosouza.transacao.config.exception.TransacationNotFoundException;
import br.com.zupacademy.marciosouza.transacao.controller.dto.TransactionReponse;
import br.com.zupacademy.marciosouza.transacao.model.TransactionModel;
import br.com.zupacademy.marciosouza.transacao.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/transacoes")
    public ResponseEntity<Page<TransactionReponse>> listTransactions(@RequestParam String id, @PageableDefault(size = 10, sort = "effective_date") Pageable page){

        Page<TransactionModel> transactions = transactionRepository.findByCardId(id, page);
        if(transactions.isEmpty()) throw new TransacationNotFoundException("Não foi encontrada registro de transações");

        return ResponseEntity.ok(TransactionReponse.converter(transactions));
    }
}
