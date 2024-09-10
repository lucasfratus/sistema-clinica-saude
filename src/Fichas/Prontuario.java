package Fichas;

import Sistema.PacienteCadastrado;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRONTUARIO")
public class Prontuario {
    @OneToOne(cascade = CascadeType.ALL)
    private PacienteCadastrado paciente;
    private String sintomas;
    private String diagnostico;
    private String tratamento;
    @Id
    private Integer idPront;
    
    public Prontuario(){
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public PacienteCadastrado getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteCadastrado paciente) {
        this.paciente = paciente;
    }

    public Integer getIdPront() {
        return idPront;
    }

    public void setIdPront(Integer idPront) {
        this.idPront = idPront;
    }
           
}
