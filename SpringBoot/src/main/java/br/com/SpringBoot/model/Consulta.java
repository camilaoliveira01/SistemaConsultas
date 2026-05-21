package br.com.SpringBoot.model;

import java.util.List;                      // Criar Listas
import jakarta.persistence.Entity;          // Transforma classe em tabrla
import jakarta.persistence.Id;              // Define chave primária
import jakarta.persistence.GenerationType;  // Define como gerar ID
import jakarta.persistence.GeneratedValue;  // Gera ID de forma automática
import jakarta.persistence.Table;           // Define o nome da tabela
import jakarta.persistence.*;               // Importuda tudo acima e mais um pouco de uma vez
import java.time.LocalDate;                 // Importa datas do Sql
import java.time.LocalTime;                 // Importa Horários Banco de dados

@Entity
@Table(name ="Consulta")
public class Consulta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long protocolo;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private String status;
    //    private Integer idCliente;
    //    private Integer idMedico;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;


    public Long getProtocolo() {
        return protocolo;}

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo; }

    public LocalDate getDataConsulta() {
        return dataConsulta; }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta; }

    public LocalTime getHoraConsulta() {
        return horaConsulta; }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta; }

    public String getStatus() {
        return status; }

    public void setStatus(String status) {
        this.status = status; }

    //public Integer getIdCliente() { return idCliente; }
    //public void setIdCliente(Integer idCliente) {  this.idCliente = idCliente; }

    //public Integer getIdMedico() { return idMedico; }
    //public void setIdMedico(Integer idMedico) { this.idMedico = idMedico; }

    public Cliente getCliente() {
        return cliente; }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente; }

    public Medico getMedico() {
        return medico; }

    public void setMedico(Medico medico) {
        this.medico = medico; }

}
