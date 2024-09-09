package EmpregadosClinica;

import Atendimento.Consulta;
import Atendimento.Paciente;
import Fichas.Prontuario;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public class Medico {
    private String nome;
    private String numeroDeRegistro;
    private String especialidade;
    private String numeroDoConsultorio;  
    private int numeroAtendidos;
    private EntityManager em;
    
    public Medico() {
    }
    
    public Medico(String nome, String numeroDeRegistro, String especialidade, String numeroDoConsultorio, int numeroAtendidos) {
        this.nome = nome;
        this.numeroDeRegistro = numeroDeRegistro;
        this.especialidade = especialidade;
        this.numeroDoConsultorio = numeroDoConsultorio;
        this.numeroAtendidos = numeroAtendidos;
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

    public String getNumeroDoConsultorio() {
        return numeroDoConsultorio;
    }

    public void setNumeroDoConsultorio(String numeroDoConsultorio) {
        this.numeroDoConsultorio = numeroDoConsultorio;
    }
    
    public void setNumeroAtendidos(){
        this.numeroAtendidos += 1;
    }
    
    public int getNumeroAtendidos(){
        return numeroAtendidos;
    }
    public Paciente cadastrarPaciente(String nome, String email, String cpf, String dataNascimento, String endereco, String telefone, String convenio){
        // Cadastra as informações básicas de um paciente, semelhante ao cadastrar paciente da secretaria;
        Paciente novoPaciente = new Paciente(nome, cpf, dataNascimento, endereco, convenio, email, telefone);
        return novoPaciente;
    }
    /*
    // ARRUMAR
    public Paciente buscarPaciente(String cpf){
       // Busca um paciente na lista de pacientes através do CPF, retornando um objeto Paciente que possui o CPF desejado.
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
        // Cadastra as informações adicionais do paciente. Só pode ser realizado pelo médico, diferente do cadastrarPaciente().
        paciente.setFuma(fuma);
        paciente.setBebe(bebe);
        paciente.setColesterolAlto(colesterolAlto);
        paciente.setDiabete(diabete);
        paciente.setDoencaCardiaca(doencaCardiaca);
        paciente.setCirurgias(cirurgias);
        paciente.setAlergias(alergias);
    }
    */
    // Os métodos a seguir atualizam e removem as informações adicionais dos Pacientes. 
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
        // Cadastra um prontuário de um paciente,
        Prontuario prontuarioPaciente = new Prontuario(sintoma, diagnostico, tratamento);
        paciente.setProntuario(prontuarioPaciente);
    }
    
    // Os métodos a seguir permitem a atualização dos dados de um prontuario de um paciente
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
    
    /* Gera um relatório médico do paciente, com seu nome, receita, atestado e declaração de acompanhamento (os dois ultimos
    gerados de forma representativa). Além disso mostra qual é o número do paciente atendido naquele mês.*/
    public void gerarRelatorioMedico(Paciente paciente){
        this.setNumeroAtendidos();
        System.out.println("Nome do paciente: " + paciente.getNome());
        System.out.println("Receita: " + paciente.getProntuario().getTratamento());
        System.out.println("Atestado: (*Documento em pdf*)");
        System.out.println("Declaração de acompanhamento: (*Documento em pdf*)");
        System.out.println("Paciente atendido no mês: " + this.getNumeroAtendidos());
    }
}
