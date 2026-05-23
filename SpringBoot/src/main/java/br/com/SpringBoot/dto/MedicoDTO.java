package br.com.SpringBoot.dto;

import br.com.SpringBoot.enums.StatusMedico;

public class MedicoDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private String nomeEspecialidade;
    private StatusMedico status;



    //  GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public StatusMedico getStatus() {
        return status;
    }

    public void setStatus(StatusMedico status) {
        this.status = status;
    }
}