package br.com.SpringBoot.service;

import br.com.SpringBoot.model.Medico;
import br.com.SpringBoot.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    //SALVAR CADASTRO MÈDICO
    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    // LISTAR
    public List<Medico> listar(){
        return medicoRepository.findAll();
    }
}
