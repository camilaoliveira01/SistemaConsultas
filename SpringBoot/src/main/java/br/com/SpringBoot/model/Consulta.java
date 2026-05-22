package br.com.SpringBoot.model;

import jakarta.persistence.*;               // Importuda tudo acima e mais um pouco de uma vez
import java.time.LocalDate;                 // Importa datas do Sql
import java.time.LocalTime;                 // Importa Horários Banco de dados
import br.com.SpringBoot.enums.StatusConsulta;

@Entity
@Table(name ="Consulta")
    public class Consulta {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)

        private Long protocolo;

        private LocalDate dataConsulta;

        private LocalTime horaConsulta;

        @Enumerated(EnumType.STRING)
        private StatusConsulta status;
        //    private Integer idCliente;
        //    private Integer idMedico;
        @ManyToOne
        @JoinColumn(name = "id_cliente")
        private Cliente cliente;

        @ManyToOne
        @JoinColumn(name = "id_medico")
        private Medico medico;

        public Long getProtocolo() {
            return protocolo;
        }

        public void setProtocolo(Long protocolo) {
            this.protocolo = protocolo;
        }

        public LocalDate getDataConsulta() {
            return dataConsulta; }

        public void setDataConsulta(LocalDate dataConsulta) {
            this.dataConsulta = dataConsulta; }

        public LocalTime getHoraConsulta() {
            return horaConsulta; }

        public void setHoraConsulta(LocalTime horaConsulta) {
            this.horaConsulta = horaConsulta; }

        public StatusConsulta getStatus() {
            return status;
        }

        public void setStatus(StatusConsulta status) {
            this.status = status;
        }


        public Cliente getCliente() {
            return cliente; }
        public void setCliente(Cliente cliente) {
            this.cliente = cliente; }

        public Medico getMedico() {
            return medico; }

        public void setMedico(Medico medico) {
            this.medico = medico; }

    }
