package br.com.SpringBoot.repository;

import br.com.SpringBoot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByCpf(String cpf);
        Cliente findByCpfAndNascimento(String cpf, LocalDate nascimento);
}