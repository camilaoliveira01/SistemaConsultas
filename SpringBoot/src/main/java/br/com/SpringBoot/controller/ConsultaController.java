package br.com.SpringBoot.controller;

import br.com.SpringBoot.model.Consulta;
import br.com.SpringBoot.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    // SALVAR CONSULTA
    @PostMapping
    public Consulta salvar(@RequestBody Consulta consulta) {
        return consultaService.salvar(consulta);
    }

    // LISTAR CONSULTAS
    @GetMapping
    public List<Consulta> listar() {
        return consultaService.listar();
    }

    // BUSCAR CONSULTA POR PROTOCOLO
    @GetMapping("/{protocolo}")
    public Consulta buscarConsultaProtocolo(@PathVariable Long protocolo) {
        return consultaService.buscarPorProtocolo(protocolo);
    }

    // ALTERAR / REAGENDAR CONSULTA
    @PutMapping("/{protocolo}")
    public Consulta alterarConsulta(@PathVariable Long protocolo, @RequestBody Consulta consulta) {
        return consultaService.alterarConsulta(protocolo, consulta);
    }

    //  CANCELAR - SEM APAGAR NO BANCO
    // MEIO Q CANCELAR TAMBÉM É UMA ALTERAÇÃO

    @PutMapping("/cancelar/{protocolo}")
    public Consulta cancelarConsulta(@PathVariable Long protocolo) {
        return consultaService.cancelarConsulta(protocolo);
    }


}