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

    //BUSCAR MEDICO
    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Integer id) {
        return medicoService.buscarPorId(id);
    }

    //ATUALISAR MÉDICO

    @PutMapping("/{id}")
    public Medico atualizarMedico(@PathVariable Integer id, @RequestBody Medico medico){
        return medicoService.atualizarMedico(id,medico);
    }

    //INATIVAR MEDICO
    @PutMapping("/inativar/{id}")
    public Medico inativarMedico(@PathVariable Integer id){
        return medicoService.inativarMedico(id);
    }
}