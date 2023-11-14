package br.com.ibm.controller;

import br.com.ibm.entity.ContaCorrente;
import br.com.ibm.service.ContaCorrenteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("transferir")
public class TransferirController {
    @Inject
    ContaCorrenteService correnteService;

    @PUT
    public Response updateContas(List<ContaCorrente> contas){

        correnteService.transferirContas(contas);

        return Response.status(204).build();
    }

}
