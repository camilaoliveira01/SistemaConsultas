package br.com.SpringBoot.service;

import br.com.SpringBoot.model.Consulta;
import br.com.SpringBoot.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.SpringBoot.enums.StatusConsulta;
import br.com.SpringBoot.repository.ClienteRepository;
import br.com.SpringBoot.repository.MedicoRepository;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    // SALVAR CONSULTA
    public Consulta salvar(Consulta consulta) {
        consulta.setStatus(StatusConsulta.AGENDADA);
        return consultaRepository.save(consulta);
    }

    // LISTAR CONSULTAS
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    // BUSCAR CONSULTA POR PROTOCOLO
    public Consulta buscarPorProtocolo(Long protocolo) {
        return consultaRepository.findById(protocolo).orElse(null);
    }

    // ALTERAR / REAGENDAR CONSULTA
    public Consulta alterarConsulta(Long protocolo, Consulta consultaAlterada) {

        Consulta consulta = buscarPorProtocolo(protocolo);

        if (consulta != null) {

            consulta.setDataConsulta(consultaAlterada.getDataConsulta());

            consulta.setHoraConsulta(
                    consultaAlterada.getHoraConsulta());
            consulta.setStatus(StatusConsulta.REAGENDADA);

            return consultaRepository.save(consulta);
        }

        return null;
    }

    // CANCELAR CONSULTA
    public Consulta cancelarConsulta(Long protocolo) {

        Consulta consulta = buscarPorProtocolo(protocolo);

        if (consulta != null) {

            consulta.setStatus(StatusConsulta.CANCELADA);

            return consultaRepository.save(consulta);
        }

        return null;
    }

}