package br.com.SpringBoot.repository;

import br.com.SpringBoot.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import br.com.SpringBoot.enums.StatusConsulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndDataConsultaAndHoraConsultaAndStatus(
            Integer medicoId,
            LocalDate dataConsulta,
            LocalTime horaConsulta,
            StatusConsulta status
    );


} //Tipagem da chave primária