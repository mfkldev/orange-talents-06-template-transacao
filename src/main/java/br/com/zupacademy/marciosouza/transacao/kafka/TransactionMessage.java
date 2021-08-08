package br.com.zupacademy.marciosouza.transacao.kafka;

import java.math.BigDecimal;

public class TransactionMessage {

    private String id;
    private BigDecimal valor;
    private Establishment establishment;
    private Card card;
    private String effectiveDate;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }
}
