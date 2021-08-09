package br.com.zupacademy.marciosouza.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class TransactionModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal valor;

    @Embedded
    private EstablishmentModel establishmentModel;

    @ManyToOne(cascade = CascadeType.MERGE)
    private CardModel card;

    @NotBlank
    private String effectiveDate;

    public TransactionModel(BigDecimal valor, EstablishmentModel establishmentModel, CardModel card, String effectiveDate) {
        this.valor = valor;
        this.establishmentModel = establishmentModel;
        this.card = card;
        this.effectiveDate = effectiveDate;
    }

    @Deprecated
    public TransactionModel() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstablishmentModel getEstablishment() {
        return establishmentModel;
    }

    public CardModel getCard() {
        return card;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }
}
