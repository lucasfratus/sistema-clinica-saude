package EmpregadosClinica;

import Atendimento.Consulta;
import Sistema.MedicoCadastrado;
import Sistema.PacienteCadastrado;
import javax.persistence.EntityManager;


public class Secretaria {
    private String nomeFuncionario;
    private String cpf;
    private EntityManager em;


    public Secretaria(String nomeFuncionario, String cpf) {
        this.nomeFuncionario = nomeFuncionario;
        this.cpf = cpf;
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
        // Cadastra as informações basicas de um paciente
        em.getTransaction().begin();
        PacienteCadastrado novoPaciente = new PacienteCadastrado();
        novoPaciente.setNome(nome);
        novoPaciente.setCpf(cpf);
        novoPaciente.setEmail(email);
        novoPaciente.setDataNascimento(dataNascimento);
        novoPaciente.setEndereco(endereco);
        novoPaciente.setTelefone(telefone);
        novoPaciente.setConvenio(convenio);
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
        }
        em.getTransaction().commit();
    }
    
    public Consulta marcarConsulta(String data, String horario, MedicoCadastrado medico, PacienteCadastrado paciente, String tipoConsulta, EntityManager em){
        // Marca uma consulta, adicionando ela na base de dados
        em.getTransaction().begin();
        Consulta novaConsulta = new Consulta(); 
        novaConsulta.setData(data);
        novaConsulta.setHorario(horario);
        novaConsulta.setMedico(medico);
        novaConsulta.setPaciente(paciente);
        novaConsulta.setTipoConsulta(tipoConsulta);
        em.persist(novaConsulta);
        em.getTransaction().commit();
        return novaConsulta;
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
    /*
    public ArrayList[] gerarRelatorio(String data){
        
        Gera um relatorio de consultas de uma determinada data.
        Mostra as informações dessa consultas, como data, horario, medico, paciente, tipo de consulta.
        Mostra, também, quais pacientes possuem ou não uma forma de contato(email/telefone).
        Retorna um ArrayList, sendo o primeiro espaço outro ArrayList contendo as consultas que os pacientes
        não possuem forma de contato. No outro espaço, há outro ArrayList, mas este contém as consultas que os
        pacientes possuem alguma forma de contato.
        
        ArrayList<Consulta> relatorioComContato = new ArrayList();
        ArrayList<Consulta> relatorioSemContato = new ArrayList();
        
        for(int z = 0; z < listaConsultas.size(); z++)
            if (listaConsultas.get(z).getData() == data) {
                if (listaConsultas.get(z).getPaciente().getTelefone() == "Nao Informado" && listaConsultas.get(z).getPaciente().getEmail() == "Nao Informado"){
                    relatorioSemContato.add(listaConsultas.get(z));
                } else {
                    relatorioComContato.add(listaConsultas.get(z));
                }        
            }
        
        ArrayList<Consulta>[] relatorios = new ArrayList[2];
        relatorios[0] = relatorioSemContato;
        relatorios[1] = relatorioComContato;
        
        System.out.println("---Relatório de Consultas de " + data + "---\n\nCom email/telefone:");
        for(int i = 0;i < relatorioComContato.size(); i++){
            System.out.println("Data: " + relatorioComContato.get(i).getData());
            System.out.println("Horario: " + relatorioComContato.get(i).getHorario());
            System.out.println("Medico: " + relatorioComContato.get(i).getMedico().getNome());
            System.out.println("Paciente: " + relatorioComContato.get(i).getPaciente().getNome());
            System.out.println("Telefone do Paciente: " + relatorioComContato.get(i).getPaciente().getTelefone());
            System.out.println("E-mail do Paciente: " + relatorioComContato.get(i).getPaciente().getEmail());
            System.out.println("Tipo de Consulta: " + relatorioComContato.get(i).getTipoConsulta());
            System.out.println("");  
        }
        System.out.println("------------------");
        System.out.println("Sem e-mail/telefone:");
        for(int x = 0;x < relatorioSemContato.size(); x++){
            System.out.println("Data: " + relatorioSemContato.get(x).getData());
            System.out.println("Horario: " + relatorioSemContato.get(x).getHorario());
            System.out.println("Medico: " + relatorioSemContato.get(x).getMedico().getNome());
            System.out.println("Paciente: " + relatorioSemContato.get(x).getPaciente().getNome());
            System.out.println("Tipo de Consulta: " + relatorioSemContato.get(x).getTipoConsulta());
            System.out.println("");
        }
        System.out.println("------------------");
        return relatorios;
    }
    */
}

    