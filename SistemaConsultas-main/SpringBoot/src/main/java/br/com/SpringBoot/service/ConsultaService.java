package br.com.SpringBoot.service;

import br.com.SpringBoot.model.Consulta;
import br.com.SpringBoot.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.SpringBoot.enums.StatusConsulta;
import br.com.SpringBoot.repository.ClienteRepository;
import br.com.SpringBoot.repository.MedicoRepository;
import java.time.LocalTime;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    // DEFNINDO HORÁRIO COMERCIAL PARA A CLINICA
    // SALVAR CONSULTA
    public Consulta salvar(Consulta consulta) {
        if (consulta.getDataConsulta().getDayOfWeek().getValue() == 6 ||
                consulta.getDataConsulta().getDayOfWeek().getValue() == 7) {
            throw new RuntimeException("Consulta não pode ser marcada no final de semana");
        }
        if (consulta.getHoraConsulta().isBefore(LocalTime.of(8,0)) ||
                consulta.getHoraConsulta().isAfter(LocalTime.of(17,0))) {
            throw new RuntimeException("Horario fora do funcionamento da clinica");
        }
        boolean existeConsulta = consultaRepository
                .existsByMedicoIdAndDataConsultaAndHoraConsultaAndStatus(
                        consulta.getMedico().getId(),
                        consulta.getDataConsulta(),
                        consulta.getHoraConsulta(),
                        StatusConsulta.AGENDADA
                );

        if (existeConsulta) {
            throw new RuntimeException("Ja existe consulta nesse horario");
        }

        consulta.setStatus(StatusConsulta.AGENDADA);
        return consultaRepository.save(consulta);
    }
    // BUSCAR CONSULTA POR PROTOCOLO
    public Consulta buscarPorProtocolo(Long protocolo) {
        return consultaRepository.findById(protocolo).orElse(null);
    }
    // CANCELAR CONSULTA
    public Consulta cancelarConsulta(Long protocolo) {
        Consulta consulta = buscarPorProtocolo(protocolo);
        if (consulta != null) {
            consulta.setStatus(StatusConsulta.CANCELADA);
            return consultaRepository.save(consulta);
        }
        return null;}

    // LISTAR CONSULTAS
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    // ALTERAR / REAGENDAR CONSULTA
    public Consulta alterarConsulta(Long protocolo, Consulta consultaAlterada) {
        Consulta consulta = buscarPorProtocolo(protocolo);
        if (consulta != null) {
            consulta.setDataConsulta(consultaAlterada.getDataConsulta());
            consulta.setHoraConsulta(consultaAlterada.getHoraConsulta());
            consulta.setStatus(StatusConsulta.REAGENDADA);
            return consultaRepository.save(consulta);
        }
        return null;
    }
}