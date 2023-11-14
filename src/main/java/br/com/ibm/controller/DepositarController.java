package br.com.ibm.controller;

import br.com.ibm.entity.ContaCorrente;
import br.com.ibm.service.ContaCorrenteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("depositar")
public class DepositarController {
    @Inject
    ContaCorrenteService correnteService;

    @PUT
    @Path("{id}")
    public Response updateConta(@PathParam("id") Long id, ContaCorrente contaCorrente){
        correnteService.updateConta(id, contaCorrente);

        return Response.status(204).build();
    }

}
