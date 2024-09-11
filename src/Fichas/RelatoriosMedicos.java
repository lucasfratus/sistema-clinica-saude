package Fichas;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "RELATORIO")
public class RelatoriosMedicos {
    @Id
    private String cpfPaciente;
    private String receita;
    private String atestado;
    private String declaracaoAcompanhamento;

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getAtestado() {
        return atestado;
    }

    public void setAtestado(String atestado) {
        this.atestado = atestado;
    }

    public String getDeclaracaoAcompanhamento() {
        return declaracaoAcompanhamento;
    }

    public void setDeclaracaoAcompanhamento(String declaracaoAcompanhamento) {
        this.declaracaoAcompanhamento = declaracaoAcompanhamento;
    }
}
