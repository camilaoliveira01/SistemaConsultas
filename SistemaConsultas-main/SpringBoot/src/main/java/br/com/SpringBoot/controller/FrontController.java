package br.com.SpringBoot.controller;

import br.com.SpringBoot.model.Cliente;
import br.com.SpringBoot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;

@Controller
public class FrontController {

    @Autowired
    private ClienteService clienteService;

    // Rota da tela de Login
    @GetMapping("/login")
    public String abrirPaginaLogin() {
        return "login";
    }

    // Rota da tela de Cadastro
    @GetMapping("/cadastro-cliente")
    public String abrirPaginaCadastro() {
        return "cadastro-cliente";
    }

    // Processamento do Cadastro
    @PostMapping("/efetuar-cadastro")
    public String efetuarcadastro(@RequestParam("nome") String nome,
                                  @RequestParam("cpf") String cpf,
                                  @RequestParam("email") String email,
                                  @RequestParam("telefone") String telefone,
                                  @RequestParam("nascimento") String nascimento) {

        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nome);
        novoCliente.setCpf(cpf);
        novoCliente.setEmail(email);
        novoCliente.setTelefone(telefone);
        novoCliente.setNascimento(LocalDate.parse(nascimento));
        clienteService.salvar(novoCliente);

        return "redirect:/login";
    }

    // Rota da tela principal (Painel de Cards)
    @GetMapping("/agendamento-consulta")
    public String abrirPaginaAgendamento() {
        return "agendamento-consulta";
    }

    // Rota da tela de criar consulta presencial
    @GetMapping("/criar-consulta")
    public String abrirFormularioAgendamento() {
        return "criar-consulta";
    }

    // Rota da nova tela de Teleconsulta
    @GetMapping("/agendar-teleconsulta")
    public String abrirPaginaTeleconsulta() {
        return "agendar-teleconsulta";
    }

    // Rota da tela de histórico (Meus Agendamentos)
    @GetMapping("/meus-agendamentos")
    public String abrirMeusAgendamentos() {
        return "meus-agendamentos";
    }
}