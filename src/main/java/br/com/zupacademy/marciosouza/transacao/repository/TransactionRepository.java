package br.com.zupacademy.marciosouza.transacao.repository;

import br.com.zupacademy.marciosouza.transacao.model.TransactionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
    Page<TransactionModel> findByCardId(String id, Pageable page);
}
