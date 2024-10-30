package br.edu.fatecpg.cep.buscacep.repository;

import br.edu.fatecpg.cep.buscacep.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    boolean existsByCep(String cep);
}
