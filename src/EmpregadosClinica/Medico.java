 package EmpregadosClinica;

import Atendimento.Consulta;
import Atendimento.Paciente;
import Fichas.Prontuario;
import java.util.ArrayList;
import Sistema.ListasDeDados;

public class Medico {
    private String nome;
    private String numeroDeRegistro;
    private String especialidade;
    private int numeroDoConsultorio;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Consulta> listaConsultas;    
    private int numeroAtendidos;
    
    public Medico() {
    }
    
    public Medico(String nome, String numeroDeRegistro, String especialidade, int numeroDoConsultorio, ArrayList<Paciente> listaPacientes, ArrayList<Consulta> listaConsultas) {
        this.nome = nome;
        this.numeroDeRegistro = numeroDeRegistro;
        this.especialidade = especialidade;
        this.numeroDoConsultorio = numeroDoConsultorio;
        this.listaPacientes = listaPacientes;
        this.listaConsultas = listaConsultas;
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
    
    public void setNumeroAtendidos(){
        this.numeroAtendidos += 1;
    }
    
    public int getNumeroAtendidos(){
        return numeroAtendidos;
    }
    public Paciente cadastrarPaciente(String nome, String email, String cpf, String dataNascimento, String endereco, String telefone, String convenio){
        Paciente novoPaciente = new Paciente();
        novoPaciente.setNome(nome);
        novoPaciente.setEmail(email);
        novoPaciente.setCpf(cpf);
        novoPaciente.setDataNascimento(dataNascimento);
        novoPaciente.setEndereco(endereco);
        novoPaciente.setTelefone(telefone);
        novoPaciente.setConvenio(convenio);
        listaPacientes.add(novoPaciente);
        return novoPaciente;
    }
    
    public Paciente buscarPaciente(String cpf){
        Paciente paciente = null;
        for(int i = 0; i < listaPacientes.size(); i++){
            if (listaPacientes.get(i).getCpf().equals(cpf)) {
                paciente = listaPacientes.get(i);
            }    
        }
        return paciente;
    }
    
    public void cadastrarInformacoesPaciente(Paciente paciente, boolean fuma, boolean bebe, boolean colesterolAlto, boolean diabete, boolean doencaCardiaca, 
            ArrayList<String> cirurgias, ArrayList<String> alergias) {
        paciente.setFuma(fuma);
        paciente.setBebe(bebe);
        paciente.setColesterolAlto(colesterolAlto);
        paciente.setDiabete(diabete);
        paciente.setDoencaCardiaca(doencaCardiaca);
        paciente.setCirurgias(cirurgias);
        paciente.setAlergias(alergias);
    }

    public void atualizarPacienteProntuario(Prontuario prontuario, Paciente paciente){
        paciente.setProntuario(prontuario); 
    }
    
    public void atualizarPacienteFuma(boolean fuma, Paciente paciente){
        paciente.setFuma(fuma); 
    }
    
    public void atualizarPacienteCpf(boolean bebe, Paciente paciente){
        paciente.setBebe(bebe); 
    }
    
    public void atualizarPacienteColesterol(boolean colesterolAlto, Paciente paciente){
        paciente.setColesterolAlto(colesterolAlto); 
    }
    
    public void atualizarPacienteDiabete(boolean diabete, Paciente paciente){
        paciente.setDiabete(diabete);
    }
    
    public void atualizarPacienteDoencaCardiaca(boolean doencaCardiaca, Paciente paciente){
        paciente.setDoencaCardiaca(doencaCardiaca);
    }
    
    public void atualizarPacienteCirurgias(ArrayList<String> cirurgias, Paciente paciente){
        paciente.setCirurgias(cirurgias);
    }
    
    public void atualizarPacienteAlergias(ArrayList<String> alergias, Paciente paciente){
        paciente.setAlergias(alergias);
    }
    
    public void adicionarAlergia(String alergia, Paciente paciente){
        ArrayList<String> listaAlergias = paciente.getAlergias();
        listaAlergias.add(alergia);
        paciente.setAlergias(listaAlergias);
    }
    
    public void removerAlergia(String alergia, Paciente paciente){
        ArrayList<String> listaAlergias = paciente.getAlergias();
        listaAlergias.remove(alergia);
        paciente.setAlergias(listaAlergias);
    }
    
    public void adicionarCirurgia(String cirurgia, Paciente paciente){
        ArrayList<String> listaCirurgias = paciente.getCirurgias();
        listaCirurgias.add(cirurgia);
        paciente.setCirurgias(listaCirurgias); 
    }
    
    public void removerCirurgia(String cirurgia, Paciente paciente){
        ArrayList<String> listaCirurgias = paciente.getCirurgias();
        listaCirurgias.remove(cirurgia);
        paciente.setCirurgias(listaCirurgias); 
    }
    
    public void cadastrarProntuario(Paciente paciente, String sintoma, String diagnostico, String tratamento){
        Prontuario prontuarioPaciente = new Prontuario(sintoma, diagnostico, tratamento);
        paciente.setProntuario(prontuarioPaciente);
    }
    
    public void atualizarDiagnosticoProntuario(Paciente paciente, String diagonostico){
        paciente.getProntuario().setDiagnostico(diagonostico);
    }
    
    public void atualizarSintomasProntuario(Paciente paciente, String sintomas){
        paciente.getProntuario().setSintomas(sintomas);
    }
    
    public void atualizarTratamentoProntuario(Paciente paciente, String tratamento){
        paciente.getProntuario().setTratamento(tratamento);
    }
    
    public void removerProntuario(Paciente paciente){
        paciente.getProntuario().setDiagnostico(null);
        paciente.getProntuario().setSintomas(null);
        paciente.getProntuario().setTratamento(null);
    }
    
    public void gerarRelatorioMedico(Paciente paciente){
        this.setNumeroAtendidos();
        System.out.println("Nome do paciente: " + paciente.getNome());
        System.out.println("Receita: " + paciente.getProntuario().getTratamento());
        System.out.println("Atestado: (*Documento em pdf*)");
        System.out.println("Declaração de acompanhamento: (*Documento em pdf*)");
        System.out.println("Clientes atendidos no mês: " + this.getNumeroAtendidos());
    }
}
