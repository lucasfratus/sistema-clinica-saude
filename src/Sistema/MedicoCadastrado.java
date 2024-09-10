/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICO")
public class MedicoCadastrado {
    private String nome;
    @Id
    private String numeroDeRegistro;
    private String especialidade;
    private String numeroDoConsultorio;
    private int numeroAtendidos;

    public String getNome() {
        return nome;
    }

    public String getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getNumeroDoConsultorio() {
        return numeroDoConsultorio;
    }

    public int getNumeroAtendidos() {
        return numeroAtendidos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDeRegistro(String numeroDeRegistro) {
        this.numeroDeRegistro = numeroDeRegistro;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setNumeroDoConsultorio(String numeroDoConsultorio) {
        this.numeroDoConsultorio = numeroDoConsultorio;
    }

    public void setNumeroAtendidos(int numeroAtendidos) {
        this.numeroAtendidos = numeroAtendidos;
    }
    
    
}
