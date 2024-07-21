/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Staff;

import Atendimento.Consultas;
import Atendimento.Paciente;

/**
 *
 * @author lucas
 */
public class Secretaria {
    private String nomeFuncionario;
    private Paciente paciente;
    private Consultas consulta;

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
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
    
    public Consultas getConsulta() {
        return consulta;
    }
    
   
}
    