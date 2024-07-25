/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fichas;

import Atendimento.Paciente;

public class RelatoriosMedicos {
    private Paciente paciente;
    private String receita;
    private boolean atestado;
    private boolean declaracaoAcompanhamento;

    public RelatoriosMedicos(){
    }
    
    public RelatoriosMedicos(Paciente paciente, String receita, boolean atestado, boolean declaracaoAcompanhamento){
        this.paciente = paciente;
        this.receita = receita;
        this.atestado = atestado;
        this.declaracaoAcompanhamento = declaracaoAcompanhamento;
    }

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

    public boolean isAtestado() {
        return atestado;
    }

    public void setAtestado(boolean atestado) {
        this.atestado = atestado;
    }

    public boolean isDeclaracaoAcompanhamento() {
        return declaracaoAcompanhamento;
    }

    public void setDeclaracaoAcompanhamento(boolean declaracaoAcompanhamento) {
        this.declaracaoAcompanhamento = declaracaoAcompanhamento;
    }
    
}
