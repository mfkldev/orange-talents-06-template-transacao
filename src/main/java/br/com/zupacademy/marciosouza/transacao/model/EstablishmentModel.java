package br.com.zupacademy.marciosouza.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Embeddable
public class EstablishmentModel {

    @NotBlank
    private String name;
    @NotBlank
    private String city;
    @NotBlank
    private String address;

    @Deprecated
    public EstablishmentModel() {
    }

    public EstablishmentModel(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}