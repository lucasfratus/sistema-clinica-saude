package Fichas;

import Atendimento.Paciente;

public class RelatoriosMedicos {
    private Paciente paciente;
    private String receita;
    private String atestado;
    private String declaracaoAcompanhamento;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
