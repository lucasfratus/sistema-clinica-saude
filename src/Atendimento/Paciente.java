/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atendimento;

import java.util.ArrayList;
import Fichas.Prontuario;

public class Paciente {
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String convenio;
    private Prontuario prontuario;
    private boolean fuma;
    private boolean bebe;
    private boolean colesterolAlto;
    private boolean diabete;
    private boolean doencaCardiaca;
    private ArrayList<String> cirurgias;
    private ArrayList<String> alergias;
      
    public Paciente(){        
    }
    
    public Paciente(String nome, String cpf, String dataNascimento, String endereco, String convenio, String email, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.convenio = convenio;
        this.email = email;
        this.telefone = telefone;
    }
    
    public Paciente(String nome, String email, String cpf, String dataNascimento, String endereco, String telefone, String convenio,
            Prontuario prontuario, boolean fuma, boolean bebe, boolean colesterolAlto, boolean diabete, boolean doencaCardiaca, ArrayList<String>
                    cirurgias, ArrayList<String> alergias){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.convenio = convenio;
        this.prontuario = prontuario;
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterolAlto = colesterolAlto;
        this.diabete = diabete;
        this.doencaCardiaca = doencaCardiaca;
        this.cirurgias = cirurgias;
        this.alergias = alergias;
        }
    
    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public boolean isBebe() {
        return bebe;
    }

    public void setBebe(boolean bebe) {
        this.bebe = bebe;
    }

    public boolean isColesterolAlto() {
        return colesterolAlto;
    }

    public void setColesterolAlto(boolean colesterolAlto) {
        this.colesterolAlto = colesterolAlto;
    }

    public boolean isDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean isDoencaCardiaca() {
        return doencaCardiaca;
    }

    public void setDoencaCardiaca(boolean doencaCardiaca) {
        this.doencaCardiaca = doencaCardiaca;
    }

    public ArrayList<String> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(ArrayList<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }
    
}
