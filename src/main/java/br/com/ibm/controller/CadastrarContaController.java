package br.com.ibm.controller;

import br.com.ibm.entity.ContaCorrente;
import br.com.ibm.service.ContaCorrenteService;
import jakarta.inject.Inject;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("cadastrar-conta")
public class CadastrarContaController {
    @Inject
    ContaCorrenteService correnteService;

    @POST
    public void addConta(ContaCorrente contaCorrente) {
        correnteService.addConta(contaCorrente);
    }
}
