package br.com.ibm.service;

import br.com.ibm.entity.Cliente;
import br.com.ibm.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public List<Cliente> findAllClientes(){

        return clienteRepository.findAll().list();
    }

    @Transactional
    public void addCliente(Cliente cliente){
        clienteRepository.persist(cliente);
    }
    @Transactional
    public void updateCliente(Long id, Cliente clienteAtt){
        Optional<Cliente> clienteOp = clienteRepository.findByIdOptional(id);

        if (clienteOp.isEmpty()){
            throw new NullPointerException("Cliente not found");
        }

        Cliente cliente = clienteOp.get();

        cliente.setNome(clienteAtt.getNome());
        cliente.setCpf(clienteAtt.getCpf());

        clienteRepository.persist(cliente);

    }
    @Transactional
    public void deleteCliente(Long id){
        Optional<Cliente> clienteOp = clienteRepository.findByIdOptional(id);

        if (clienteOp.isEmpty()){
            throw new NullPointerException("Cliente not found");
        }

        Cliente cliente = clienteOp.get();

        clienteRepository.delete(cliente);
    }




}
