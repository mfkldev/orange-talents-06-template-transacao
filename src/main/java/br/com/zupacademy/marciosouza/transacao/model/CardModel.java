package br.com.zupacademy.marciosouza.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class CardModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String email;

    @OneToMany(mappedBy = "card")
    private List<TransactionModel> transactionModelList;

    public CardModel(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    public CardModel() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}