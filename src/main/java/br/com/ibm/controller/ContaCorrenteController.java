package br.com.ibm.controller;

import br.com.ibm.entity.ContaCorrente;
import br.com.ibm.service.ContaCorrenteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.ArrayList;
import java.util.List;

@Path("conta")
public class ContaCorrenteController {
    @Inject
    ContaCorrenteService correnteService;
    @GET
    public List<ContaCorrente> retriveConta(){

        List<ContaCorrente> contas = new ArrayList<>();

        try {
            contas = correnteService.findAllContas();
        }catch (Exception e){
            e.printStackTrace();
        }
        return contas;
    }

}
