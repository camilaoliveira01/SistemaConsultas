package br.com.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro-cliente")
    public String cadastroCliente() {
        return "cadastro-cliente";
    }

    @GetMapping("/agendamento-consulta")
    public String agendamentoConsulta() {
        return "agendamento-consulta";
    }
}