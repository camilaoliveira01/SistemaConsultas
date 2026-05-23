package br.com.SpringBoot.service;

import br.com.SpringBoot.model.Medico;
import br.com.SpringBoot.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.SpringBoot.enums.StatusMedico;


import java.util.List;
@Service

public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;


    //SALVAR CADASTRO MÉDICO
    public Medico salvar(Medico medico) { medico.setStatus(StatusMedico.ATIVO);
        return medicoRepository.save(medico);
    }

    // LISTAR
    public List<Medico> listar(){
        return medicoRepository.findAll();
    }

    //BUSCAR MEDICO ID
    public Medico buscarPorId(Integer id) {
        return medicoRepository.findById(id).orElse(null);
    }


    //BUSCAR MÉDICO POR ESPECIALIDADE
    public List<Medico> buscarPorEspecialidade(String especialidade) {
        return medicoRepository.findByNomeEspecialidade(especialidade);
    }

    //BUSCAR  ESPECIALIDADE
    public List<String> listarEspecialidades() {
        return medicoRepository.listarEspecialidades();
    }

    //ATUALIZAR MEDICO
    public Medico atualizarMedico(Integer id, Medico medico) {
        medico.setId(id);
        return medicoRepository.save(medico);
    }

    //INATIVAR MEDICO
    public Medico inativarMedico(Integer id) {
        Medico medico = medicoRepository.findById(id).orElse(null);

        if (medico != null) {medico.setStatus(StatusMedico.INATIVO);
            return medicoRepository.save(medico);
        }

        return null;
    }
}
