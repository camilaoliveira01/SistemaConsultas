package br.com.SpringBoot.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import br.com.SpringBoot.model.Cliente;
import br.com.SpringBoot.model.Medico;

public class ConsultaDTO {

    private LocalDate dataConsulta;
    private LocalTime horaConsulta;

    private Cliente cliente;
    private Medico medico;

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}