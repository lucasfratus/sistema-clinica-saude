package Atendimento;

import EmpregadosClinica.Medico;
import Sistema.MedicoCadastrado;
import Sistema.PacienteCadastrado;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONSULTA")
public class Consulta {
    private String data;
    private String horario;
    private MedicoCadastrado medico;
    @Id
    private PacienteCadastrado paciente;
    private String tipoConsulta;
    

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public MedicoCadastrado getMedico() {
        return medico;
    }

    public void setMedico(MedicoCadastrado medico) {
        this.medico = medico;
    }

    public PacienteCadastrado getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteCadastrado paciente) {
        this.paciente = paciente;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
}
