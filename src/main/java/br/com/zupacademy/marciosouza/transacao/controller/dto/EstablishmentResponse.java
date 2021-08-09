package br.com.zupacademy.marciosouza.transacao.controller.dto;

import br.com.zupacademy.marciosouza.transacao.model.EstablishmentModel;

public class EstablishmentResponse {

    private String name;
    private String city;
    private String address;

    public EstablishmentResponse(EstablishmentModel establishmentModel) {
        this.name = establishmentModel.getName();
        this.city = establishmentModel.getCity();
        this.address = establishmentModel.getAddress();
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
