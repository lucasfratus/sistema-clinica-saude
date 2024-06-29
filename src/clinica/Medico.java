/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica;

/**
 *
 * @author lucas
 */
public class Medico {

    private String nome;
    private String numero_de_registro;
    private String especialidade;
    private int numero_consultorio;
    private String numero_telefone;
    private boolean atendimento_por_convenio;
    
    public Medico() {
    }
    
    public Medico(String nome, String numero_de_registro, String especialidade, int numero_consultorio, String numero_telefone) {
        this.nome = nome;
        this.numero_de_registro = numero_de_registro;
        this.especialidade = especialidade;
        this.numero_consultorio = numero_consultorio;
        this.numero_telefone = numero_telefone;
        this.atendimento_por_convenio = atendimento_por_convenio;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero_de_registro() {
        return numero_de_registro;
    }

    public void setNumero_de_registro(String numero_de_registro) {
        this.numero_de_registro = numero_de_registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getNumero_consultorio() {
        return numero_consultorio;
    }

    public void setNumero_consultorio(int numero_consultorio) {
        this.numero_consultorio = numero_consultorio;
    }

    public String getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    public boolean isAtendimento_por_convenio() {
        return atendimento_por_convenio;
    }

    public void setAtendimento_por_convenio(boolean atendimento_por_convenio) {
        this.atendimento_por_convenio = atendimento_por_convenio;
    }
}
