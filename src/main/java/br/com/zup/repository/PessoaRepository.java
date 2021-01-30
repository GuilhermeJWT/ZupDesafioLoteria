package br.com.zup.repository;

import br.com.zup.model.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    @Query("select e from Pessoa e where e.email like %?1")
    Optional<Pessoa> findUserByEmail(String email);

}
