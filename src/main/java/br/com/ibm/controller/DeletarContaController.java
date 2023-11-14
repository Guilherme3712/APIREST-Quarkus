package br.com.ibm.controller;


import br.com.ibm.service.ContaCorrenteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("deletar-conta")
public class DeletarContaController {
    @Inject
    ContaCorrenteService correnteService;

    @DELETE
    @Path("{id}")
    public Response deleteConta(@PathParam("id") Long id){
        correnteService.deleteConta(id);

        return Response.status(204).build();
    }


}
