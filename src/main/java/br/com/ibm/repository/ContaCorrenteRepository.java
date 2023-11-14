package br.com.ibm.repository;

import br.com.ibm.entity.ContaCorrente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContaCorrenteRepository implements PanacheRepository<ContaCorrente> {
}
