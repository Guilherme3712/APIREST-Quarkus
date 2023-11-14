package br.com.ibm.controller;

import br.com.ibm.entity.Cliente;
import br.com.ibm.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("cliente")
public class ClienteController {
    @Inject
    ClienteService clienteService;
    @GET
    public List<Cliente> retriveCliente(){

        List<Cliente> clientes = new ArrayList<>();

        try {
            clientes = clienteService.findAllClientes();
        }catch (Exception e){
            e.printStackTrace();
        }
        return clientes;
    }

    @POST
    public void addCliente (Cliente cliente) {
        clienteService.addCliente(cliente);
    }

    @PUT
    @Path("{id}")
    public Response updateCliente(@PathParam("id") Long id, Cliente cliente){
        clienteService.updateCliente(id, cliente);

        return Response.status(204).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCliente(@PathParam("id") Long id){
        clienteService.deleteCliente(id);

        return Response.status(204).build();
    }


}
