package EmpregadosClinica;

import Atendimento.Consulta;
import Fichas.Prontuario;
import Sistema.MedicoCadastrado;
import Sistema.PacienteCadastrado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class Secretaria {
    private String nomeFuncionario;
    private String cpf;
    private EntityManager em;


    public Secretaria(String nomeFuncionario, String cpf, EntityManager em) {
        this.nomeFuncionario = nomeFuncionario;
        this.cpf = cpf;
        this.em = em;
    }
        
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
    public PacienteCadastrado cadastrarPaciente(String nome,String cpf, String email, String dataNascimento, String endereco, String telefone, String convenio){
        // Cadastra as informações basicas de um paciente, colocando um objeto da classe POJO PacienteCadastrado no banco de dados.
        em.getTransaction().begin();
        PacienteCadastrado novoPaciente = new PacienteCadastrado();
        novoPaciente.setNome(nome);
        novoPaciente.setCpf(cpf);
        novoPaciente.setEmail(email);
        novoPaciente.setDataNascimento(dataNascimento);
        novoPaciente.setEndereco(endereco);
        novoPaciente.setTelefone(telefone);
        novoPaciente.setConvenio(convenio);
        em.persist(novoPaciente);
        em.getTransaction().commit();
        return novoPaciente;
    }
    

    // Permite a atualização/remoção de informações basicas de um paciente.
    public void atualizarPacienteNome(String novoNome, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setNome(novoNome); 
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteEmail(String email, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setEmail(email); 
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteCpf(String cpf, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setCpf(cpf); 
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteDataNascimento(String dataNascimento, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setDataNascimento(dataNascimento); 
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteEndereco(String endereco, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setEndereco(endereco);
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteTelefone(String telefone, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setTelefone(telefone);
        em.getTransaction().commit();
    }
    
    public void atualizarPacienteConvenio(String convenio, PacienteCadastrado paciente){
        em.getTransaction().begin();
        paciente.setConvenio(convenio);
        em.getTransaction().commit();
    }
    
    public void removerPaciente(EntityManager em, String cpf){
        // Remove um paciente do banco de dados.
        em.getTransaction().begin();
        PacienteCadastrado paciente = em.find(PacienteCadastrado.class, cpf);
        if(paciente != null){
            em.remove(paciente);
            Prontuario possivelProntuario = em.find(Prontuario.class, cpf);
            if(possivelProntuario != null){
                em.remove(possivelProntuario);
            }
        }
        em.getTransaction().commit();
    }
    
    public void marcarConsulta(String data, String horario, MedicoCadastrado medico, PacienteCadastrado paciente, String tipoConsulta, String idConsulta){
        // Marca uma consulta, adicionando ela na base de dados
        em.getTransaction().begin();
        Consulta novaConsulta = new Consulta(); 
        novaConsulta.setData(data);
        novaConsulta.setHorario(horario);
        novaConsulta.setMedico(medico);
        novaConsulta.setPaciente(paciente);
        novaConsulta.setTipoConsulta(tipoConsulta);
        novaConsulta.setIdConsulta(idConsulta);
        em.persist(novaConsulta);
        em.getTransaction().commit();
    }
    
    // Os métodos a seguir atualizam os dados de uma consulta
    public void atualizarConsultaData(String data, Consulta consulta){
        em.getTransaction().begin();
        consulta.setData(data);
        em.getTransaction().commit();
    }
    
    public void atualizarConsultaHorario(String horario, Consulta consulta){
        em.getTransaction().begin();
        consulta.setHorario(horario);
        em.getTransaction().commit();
    }
   
    public void atualizarConsultaMedico(MedicoCadastrado medico, Consulta consulta){
        em.getTransaction().begin();
        consulta.setMedico(medico);
        em.getTransaction().commit();
    }
    
    public void atualizarConsultaPaciente(PacienteCadastrado paciente, Consulta consulta){
        em.getTransaction().begin();
        consulta.setPaciente(paciente);
        em.getTransaction().commit();
    }
    
    public void atualizarConsultaTipo(String tipoConsulta, Consulta consulta){
        em.getTransaction().begin();
        consulta.setTipoConsulta(tipoConsulta);
        em.getTransaction().commit();
    }
    
    public void removerConsulta(Consulta consulta, EntityManager em){
        // Remove uma consulta da lista de consultas
        em.getTransaction().begin();
        em.remove(consulta);
        em.getTransaction().commit();
    } 
    
    public List<List<Consulta>> gerarRelatorio(String data){
        
        //Gera um relatorio de consultas de uma determinada data.
        //Mostra as informações dessa consultas, como data, horario, medico, paciente, tipo de consulta.
        //Mostra, também, quais pacientes possuem ou não uma forma de contato(email/telefone).
        //Retorna um ArrayList, sendo o primeiro espaço outro ArrayList contendo as consultas que os pacientes
        //não possuem forma de contato. No outro espaço, há outro ArrayList, mas este contém as consultas que os
        //pacientes possuem alguma forma de contato.
        
        
        Query query = em.createNamedQuery("findConsultas");
        query.setParameter("dataAmanha", data);
        
        List<Consulta> consultasDoDia = query.getResultList();
        
        List<Consulta> consultasSemContato = new ArrayList<Consulta>();
        List<Consulta> consultasComContato = new ArrayList<Consulta>();
        
        for(int z = 0; z < consultasDoDia.size(); z++) {
            if (consultasDoDia.get(z).getPaciente().getTelefone().isEmpty() && consultasDoDia.get(z).getPaciente().getEmail().isEmpty()){
                consultasSemContato.add(consultasDoDia.get(z));
            } else {
                consultasComContato.add(consultasDoDia.get(z));
            }        
        }
        List<List<Consulta>> relatorios = new ArrayList<List<Consulta>>();
        relatorios.add(consultasSemContato);
        relatorios.add(consultasComContato);
        
        return relatorios;
    }
}

    