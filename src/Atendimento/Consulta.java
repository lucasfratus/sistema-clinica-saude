package Atendimento;

import EmpregadosClinica.Medico;
import Sistema.MedicoCadastrado;
import Sistema.PacienteCadastrado;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONSULTA")
public class Consulta {
    private String data;
    private String horario;
    @OneToOne(cascade = CascadeType.ALL)
    private MedicoCadastrado medico;
    @OneToOne(cascade = CascadeType.ALL)
    private PacienteCadastrado paciente;
    private String tipoConsulta;
    @Id
    private String idConsulta;
    

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

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }
    
}
