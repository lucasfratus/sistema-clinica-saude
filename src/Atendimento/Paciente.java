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
    private boolean fuma;
    private boolean bebe;
    private boolean colesterolAlto;
    private boolean diabete;
    private boolean doencaCardiaca;
    private String cirurgias;
    private String alergias;
      
    public Paciente(){        
    }
    
    public Paciente(String nome, String cpf, String dataNascimento, String endereco, String convenio, String email, String telefone){
    /* Construtor para a instanciação de um objeto Paciente. Utilizado, principalmente, para o cadastro do paciente realizado pela
    secretaria */
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.convenio = convenio;
        this.email = email;
        this.telefone = telefone;
    }
    
    public Paciente(String nome, String email, String cpf, String dataNascimento, String endereco, String telefone, String convenio,
            boolean fuma, boolean bebe, boolean colesterolAlto, boolean diabete, boolean doencaCardiaca, String
                    cirurgias, String alergias){
        /* Construtor para a instanciação de um objeto Paciente. Consta informações adicionais, além das informações do construtor anterior */
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.convenio = convenio;
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterolAlto = colesterolAlto;
        this.diabete = diabete;
        this.doencaCardiaca = doencaCardiaca;
        this.cirurgias = cirurgias;
        this.alergias = alergias;
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

    public String getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    
}
