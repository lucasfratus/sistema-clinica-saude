package EmpregadosClinica;

import Fichas.Prontuario;
import Fichas.RelatoriosMedicos;
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
    
    public Medico(String nome, String numeroDeRegistro, String especialidade, String numeroDoConsultorio, int numeroAtendidos, EntityManager em) {
        this.nome = nome;
        this.numeroDeRegistro = numeroDeRegistro;
        this.especialidade = especialidade;
        this.numeroDoConsultorio = numeroDoConsultorio;
        this.numeroAtendidos = numeroAtendidos;
        this.em = em;
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
            String cirurgias, String alergias) {
        // Cadastra as informações adicionais do paciente. Só pode ser realizado pelo médico, diferente do cadastrarPaciente().
        em.getTransaction().begin();
        paciente.setFuma(fuma);
        paciente.setBebe(bebe);
        paciente.setColesterolAlto(colesterolAlto);
        paciente.setDiabete(diabete);
        paciente.setDoencaCardiaca(doencaCardiaca);
        paciente.setCirurgias(cirurgias);
        paciente.setAlergias(alergias);
        em.getTransaction().commit();
    }
    // Os métodos a seguir atualizam e removem as informações adicionais dos Pacientes. 
    public void atualizarPacienteProntuario(Prontuario prontuario, PacienteCadastrado paciente){
        em.getTransaction().begin();
        prontuario.setCpfPaciente(paciente.getCpf());
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteFuma(boolean fuma, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setFuma(fuma);
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteBebe(boolean bebe, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setBebe(bebe); 
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteColesterol(boolean colesterolAlto, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setColesterolAlto(colesterolAlto);
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteDiabete(boolean diabete, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setDiabete(diabete);
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteDoencaCardiaca(boolean doencaCardiaca, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setDoencaCardiaca(doencaCardiaca);
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteCirurgias(String cirurgias, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setCirurgias(cirurgias);
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteAlergias(String alergias, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setAlergias(alergias);
        em.getTransaction().commit();
    }
    
    public void adicionarAlergia(String alergia, PacienteCadastrado paciente){
        em.getTransaction().begin();
        StringBuilder listaAlergias = new StringBuilder(paciente.getAlergias());
        listaAlergias.append(", " + alergia);
        paciente.setAlergias(listaAlergias.toString());
        em.getTransaction().commit();
    }
    
    
    public void adicionarCirurgia(StringBuilder cirurgia, PacienteCadastrado paciente){
        em.getTransaction().begin();
        StringBuilder Cirurgias = new StringBuilder(paciente.getCirurgias());
        Cirurgias.append(", " + cirurgia);
        paciente.setCirurgias(Cirurgias.toString()); 
        em.getTransaction().commit();
    }

    
    public void cadastrarProntuario(PacienteCadastrado paciente, String sintoma, String diagnostico, String tratamento){
        // Cadastra um prontuário de um paciente,

        Prontuario prontuarioPaciente = new Prontuario();
        prontuarioPaciente.setDiagnostico(diagnostico);
        prontuarioPaciente.setDiagnostico(diagnostico);
        prontuarioPaciente.setCpfPaciente(paciente.getCpf());
        em.getTransaction().begin();
        em.persist(prontuarioPaciente);
        em.getTransaction().commit();
    }
    
    // Os métodos a seguir permitem a atualização dos dados de um prontuario de um paciente
    public void atualizarDiagnosticoProntuario(Prontuario prontuario, String diagnostico){
        em.getTransaction().begin();
        prontuario.setDiagnostico(diagnostico);
        em.getTransaction().commit();
    }
    
    public void atualizarSintomasProntuario(Prontuario prontuario, String sintomas){
        em.getTransaction().begin();
        prontuario.setSintomas(sintomas);
        em.getTransaction().commit();
    }
    
    public void atualizarTratamentoProntuario(Prontuario prontuario, String tratamento){
        em.getTransaction().begin();
        prontuario.setTratamento(tratamento);
        em.getTransaction().commit();
    }
    
    public void removerProntuario(String cpfPaciente){
        Prontuario prontuarioRemovido = em.find(Prontuario.class, cpfPaciente);
        em.getTransaction().begin();
        em.remove(prontuarioRemovido);
        em.getTransaction().commit();
    }
    
    /* Gera um relatório médico do paciente, com seu nome, receita, atestado e declaração de acompanhamento (os dois ultimos
    gerados de forma representativa)*/
    
    public String gerarRelatorioMedico(PacienteCadastrado paciente){
        this.setNumeroAtendidos();
        StringBuilder buffer = new StringBuilder();
        buffer.append("Nome do paciente: " + paciente.getNome());
        buffer.append("; \nReceita: " + em.find(Prontuario.class,paciente.getCpf()).getTratamento());
        buffer.append("; \nAtestado: (*Documento em pdf*)");
        buffer.append("; \nDeclaração de acompanhamento: (*Documento em pdf*)");
        buffer.append("; \nNumero do paciente atendido no mês: " + this.getNumeroAtendidos());
        String bufferString = buffer.toString();
        
        RelatoriosMedicos novoRelatorio = new RelatoriosMedicos();
        novoRelatorio.setCpfPaciente(paciente.getCpf());
        novoRelatorio.setAtestado("*Documento em pdf*");
        novoRelatorio.setDeclaracaoAcompanhamento("*Documento em pdf*");
        novoRelatorio.setReceita(em.find(Prontuario.class,paciente.getCpf()).getTratamento());
        em.getTransaction().begin();
        em.persist(novoRelatorio);
        em.getTransaction().commit();
        return bufferString;
    }

}
