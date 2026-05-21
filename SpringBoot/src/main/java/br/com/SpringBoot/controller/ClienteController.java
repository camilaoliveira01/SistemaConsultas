package br.com.SpringBoot.controller;

import br.com.SpringBoot.model.Cliente;
import br.com.SpringBoot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // SALVAR CLIENTE
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }

    // LISTAR CLIENTES
    @GetMapping
    public List<Cliente> listar(){
        return clienteService.listar();
    }

    // BUSCAR CLIENTE POR ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Integer id){
        return clienteService.buscarPorId(id);
    }

    // ATUALIZAR CLIENTE
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Integer id,
                             @RequestBody Cliente cliente){

        return clienteService.atualizar(id, cliente);
    }

    //DELETAR CLIENTE
    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Integer id){
        try {
            clienteService.deletarCliente(id);
            return "Cliente deletado com sucesso!";
        } catch (Exception e) {
            return "Não é possível deletar este cliente, pois ele possui consultas cadastradas.";
        }
    }
}
