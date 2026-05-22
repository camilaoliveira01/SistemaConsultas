package br.com.SpringBoot.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import br.com.SpringBoot.model.Medico;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
    List<Medico> findByNomeEspecialidade(String nomeEspecialidade);

    @Query("SELECT DISTINCT m.nomeEspecialidade FROM Medico m")
    List<String> listarEspecialidades();
}
