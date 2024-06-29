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
    private String numeroDeRegistro;
    private String especialidade;
    private int numeroDoConsultorio;
    
    public Medico() {
    }
    
    public Medico(String nome, String numeroDeRegistro, String especialidade, int numeroDoConsultorio, String numeroDoTelefone) {
        this.nome = nome;
        this.numeroDeRegistro = numeroDeRegistro;
        this.especialidade = especialidade;
        this.numeroDoConsultorio = numeroDoConsultorio;
        this.numeroDoTelefone = numeroDoTelefone;
        this.atendimentoPorConvenio = atendimentoPorConvenio;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    public void setNumeroDeRegistro(String numeroDeRegistro) {
        this.numeroDeRegistro = numeroDeRegistro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getNumeroDoConsultorio() {
        return numeroDoConsultorio;
    }

    public void setNumeroDoConsultorio(int numeroDoConsultorio) {
        this.numeroDoConsultorio = numeroDoConsultorio;
    }

}
