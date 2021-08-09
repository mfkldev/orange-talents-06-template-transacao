package br.com.zupacademy.marciosouza.transacao.controller.dto;

import br.com.zupacademy.marciosouza.transacao.model.TransactionModel;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class TransactionReponse {

    private BigDecimal valor;
    private EstablishmentResponse establishmentResponse;
    private String effectiveDate;

    public TransactionReponse(TransactionModel transactionModel) {
        this.valor = transactionModel.getValor();
        this.establishmentResponse = new EstablishmentResponse(transactionModel.getEstablishment());
        this.effectiveDate = transactionModel.getEffectiveDate();
    }

    public static Page<TransactionReponse> converter(Page<TransactionModel> transactions) {
        return transactions.map(TransactionReponse::new);
    }


    public BigDecimal getValor() {
        return valor;
    }

    public EstablishmentResponse getEstablishmentResponse() {
        return establishmentResponse;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }
}
