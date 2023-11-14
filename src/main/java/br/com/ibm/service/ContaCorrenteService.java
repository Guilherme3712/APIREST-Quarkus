package br.com.ibm.service;

import br.com.ibm.entity.ContaCorrente;
import br.com.ibm.repository.ContaCorrenteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@ApplicationScoped
public class ContaCorrenteService {

    @Inject
    ContaCorrenteRepository correnteRepository;

    public List<ContaCorrente> findAllContas(){

        return correnteRepository.findAll().list();
    }

    @Transactional
    public void addConta(ContaCorrente contaCorrente){
        Random rand = new Random();

        int numGerado = rand.nextInt(1000000);
        contaCorrente.setNumeroConta(numGerado);
        correnteRepository.persist(contaCorrente);
    }
    @Transactional
    public void updateConta(Long id, ContaCorrente contaAtt){
        Optional<ContaCorrente> contaOp = correnteRepository.findByIdOptional(id);

        if (contaOp.isEmpty()){
            throw new NullPointerException("Conta not found");
        }

        ContaCorrente contaCorrente = contaOp.get();


        contaCorrente.setSaldo(contaAtt.getSaldo());

        correnteRepository.persist(contaCorrente);

    }
    @Transactional
    public void transferirContas(List<ContaCorrente> contas){
        for (ContaCorrente contaCorrente : contas){
            updateConta(contaCorrente.getId(),contaCorrente);
        }

    }
    @Transactional
    public void deleteConta(Long id){
        Optional<ContaCorrente> contaOp = correnteRepository.findByIdOptional(id);

        if (contaOp.isEmpty()){
            throw new NullPointerException("Conta not found");
        }

        ContaCorrente contaCorrente = contaOp.get();

        correnteRepository.delete(contaCorrente);
    }
}
