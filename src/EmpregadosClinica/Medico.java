package EmpregadosClinica;

import Fichas.Prontuario;
import Sistema.PacienteCadastrado;
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
    
    
    public void cadastrarInformacoesPaciente(PacienteCadastrado paciente, boolean fuma, boolean bebe, boolean colesterolAlto, boolean diabete, boolean doencaCardiaca, 
            StringBuilder cirurgias, StringBuilder alergias) {
        // Cadastra as informações adicionais do paciente. Só pode ser realizado pelo médico, diferente do cadastrarPaciente().
        paciente.setFuma(fuma);
        paciente.setBebe(bebe);
        paciente.setColesterolAlto(colesterolAlto);
        paciente.setDiabete(diabete);
        paciente.setDoencaCardiaca(doencaCardiaca);
        paciente.setCirurgias(cirurgias);
        paciente.setAlergias(alergias);
    }
    // Os métodos a seguir atualizam e removem as informações adicionais dos Pacientes. 
    public void atualizarPacienteProntuario(Prontuario prontuario, PacienteCadastrado paciente){
        paciente.setProntuario(prontuario); 
    }
    
    public void atualizarPacienteFuma(boolean fuma, PacienteCadastrado paciente){
        paciente.setFuma(fuma); 
    }
    
    public void atualizarPacienteCpf(boolean bebe, PacienteCadastrado paciente){
        paciente.setBebe(bebe); 
    }
    
    public void atualizarPacienteColesterol(boolean colesterolAlto, PacienteCadastrado paciente){
        paciente.setColesterolAlto(colesterolAlto); 
    }
    
    public void atualizarPacienteDiabete(boolean diabete, PacienteCadastrado paciente){
        paciente.setDiabete(diabete);
    }
    
    public void atualizarPacienteDoencaCardiaca(boolean doencaCardiaca, PacienteCadastrado paciente){
        paciente.setDoencaCardiaca(doencaCardiaca);
    }
    
    public void atualizarPacienteCirurgias(StringBuilder cirurgias, PacienteCadastrado paciente){
        paciente.setCirurgias(cirurgias);
    }
    
    public void atualizarPacienteAlergias(StringBuilder alergias, PacienteCadastrado paciente){
        paciente.setAlergias(alergias);
    }
    
    public void adicionarAlergia(String alergia, PacienteCadastrado paciente){
        StringBuilder listaAlergias = paciente.getAlergias();
        listaAlergias.append(", " + alergia);
        paciente.setAlergias(listaAlergias);
    }
    
    
    public void adicionarCirurgia(StringBuilder cirurgia, PacienteCadastrado paciente){
        StringBuilder Cirurgias = paciente.getCirurgias();
        Cirurgias.append(cirurgia);
        paciente.setCirurgias(Cirurgias); 
    }

    
    public void cadastrarProntuario(PacienteCadastrado paciente, String sintoma, String diagnostico, String tratamento){
        // Cadastra um prontuário de um paciente,
        Prontuario prontuarioPaciente = new Prontuario(sintoma, diagnostico, tratamento);
        paciente.setProntuario(prontuarioPaciente);
    }
    
    // Os métodos a seguir permitem a atualização dos dados de um prontuario de um paciente
    public void atualizarDiagnosticoProntuario(PacienteCadastrado paciente, String diagonostico){
        paciente.getProntuario().setDiagnostico(diagonostico);
    }
    
    public void atualizarSintomasProntuario(PacienteCadastrado paciente, String sintomas){
        paciente.getProntuario().setSintomas(sintomas);
    }
    
    public void atualizarTratamentoProntuario(PacienteCadastrado paciente, String tratamento){
        paciente.getProntuario().setTratamento(tratamento);
    }
    
    public void removerProntuario(PacienteCadastrado paciente){
        paciente.getProntuario().setDiagnostico(null);
        paciente.getProntuario().setSintomas(null);
        paciente.getProntuario().setTratamento(null);
    }
    
    /* Gera um relatório médico do paciente, com seu nome, receita, atestado e declaração de acompanhamento (os dois ultimos
    gerados de forma representativa). Além disso mostra qual é o número do paciente atendido naquele mês.*/
    public void gerarRelatorioMedico(PacienteCadastrado paciente){
        this.setNumeroAtendidos();
        System.out.println("Nome do paciente: " + paciente.getNome());
        System.out.println("Receita: " + paciente.getProntuario().getTratamento());
        System.out.println("Atestado: (*Documento em pdf*)");
        System.out.println("Declaração de acompanhamento: (*Documento em pdf*)");
        System.out.println("Paciente atendido no mês: " + this.getNumeroAtendidos());
    }
}
