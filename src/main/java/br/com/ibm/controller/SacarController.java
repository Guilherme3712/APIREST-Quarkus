package br.com.ibm.controller;

import br.com.ibm.entity.ContaCorrente;
import br.com.ibm.service.ContaCorrenteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("sacar")
public class SacarController {
    @Inject
    ContaCorrenteService correnteService;

    @PUT
    @Path("{id}")
    public Response updateConta(@PathParam("id") Long id, ContaCorrente contaCorrente){
        correnteService.updateConta(id, contaCorrente);

        return Response.status(204).build();
    }

}
