package br.com.SpringBoot.controller;

import br.com.SpringBoot.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.SpringBoot.model.Medico;
import br.com.SpringBoot.service.MedicoService;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {


    @Autowired
    private MedicoService medicoService;

    //SALVAR
    @PostMapping
    public Medico salvar(@RequestBody Medico medico){
        return medicoService.salvar(medico);
    }

    //LISTAR
    @GetMapping
    public List<Medico> listar(){
        return medicoService.listar();
    }

}