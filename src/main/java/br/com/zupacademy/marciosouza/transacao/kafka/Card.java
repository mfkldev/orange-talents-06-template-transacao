package br.com.zupacademy.marciosouza.transacao.kafka;

public class Card {

    private String id;
    private String email;

    public Card(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
