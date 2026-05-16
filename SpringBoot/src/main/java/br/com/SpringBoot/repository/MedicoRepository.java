package br.com.SpringBoot.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import br.com.SpringBoot.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
