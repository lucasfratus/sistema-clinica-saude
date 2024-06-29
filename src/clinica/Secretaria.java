/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica;

/**
 *
 * @author lucas
 */
public class Secretaria {
    private String nomeFuncionario;
    private String horarioAtendimento;
    private String numeroSecretaria;
    private Paciente paciente;
    private Consultas consulta;

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public String getNumeroSecretaria() {
        return numeroSecretaria;
    }

    public void setNumeroSecretaria(String numeroSecretaria) {
        this.numeroSecretaria = numeroSecretaria;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setConsulta(Consultas consulta) {
        this.consulta = consulta;
    }
    
    
   
}
    