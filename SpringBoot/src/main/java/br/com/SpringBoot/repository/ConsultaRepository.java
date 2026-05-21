package br.com.SpringBoot.repository;

import br.com.SpringBoot.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
} //Tipagem da chave primária