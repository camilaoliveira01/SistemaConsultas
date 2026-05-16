package br.com.SpringBoot.service;

import br.com.SpringBoot.model.Cliente;
import br.com.SpringBoot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // SALVAR
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    // LISTAR
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    // BUSCAR CLIENTE POR ID
    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }

    // ATUALIZAR CLIENTE
    public Cliente atualizar(Integer id, Cliente cliente){

        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

        if(clienteExistente != null){

            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setCpf(cliente.getCpf());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setTelefone(cliente.getTelefone());
            clienteExistente.setNascimento(cliente.getNascimento());

            return clienteRepository.save(clienteExistente);
        }

        return null;
    }

    // EXCLUIR CLIENTE
    public void deletar(Integer id){
        clienteRepository.deleteById(id);
    }

}