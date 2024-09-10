package EmpregadosClinica;

import Atendimento.Consulta;
import Atendimento.Paciente;
import Sistema.MedicoCadastrado;
import Sistema.PacienteCadastrado;
import javax.persistence.EntityManager;


public class Secretaria {
    private String nomeFuncionario;
    private String cpf;


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
        PacienteCadastrado novoPaciente = new PacienteCadastrado();
        novoPaciente.setNome(nome);
        novoPaciente.setCpf(cpf);
        novoPaciente.setEmail(email);
        novoPaciente.setDataNascimento(dataNascimento);
        novoPaciente.setEndereco(endereco);
        novoPaciente.setTelefone(telefone);
        novoPaciente.setConvenio(convenio);
        return novoPaciente;
    }
    /*
    ARRUMAR
    
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
    
    public Medico buscarMedico(String nomeMedico){
        // Busca um médico na lista de médicos através do nome, retornando um objeto Medico que possui o nome desejado.
        Medico medicoBuscado = null;
        for(int i = 0; i < listaMedicos.size(); i++){
            if (listaMedicos.get(i).getNome().equals(nomeMedico)) {
                medicoBuscado = listaMedicos.get(i);
            }    
        }
        return medicoBuscado;
    }
    */
    // Permite a atualização/remoção de informações basicas de um paciente.
    public void atualizarPacienteNome(String novoNome, PacienteCadastrado paciente){
        paciente.setNome(novoNome); 
    }
    
    public void atualizarPacienteEmail(String email, PacienteCadastrado paciente){
        paciente.setEmail(email); 
    }
    
    public void atualizarPacienteCpf(String cpf, PacienteCadastrado paciente){
        paciente.setCpf(cpf); 
    }
    
    public void atualizarPacienteDataNascimento(String dataNascimento, PacienteCadastrado paciente){
        paciente.setDataNascimento(dataNascimento); 
    }
    
    public void atualizarPacienteEndereco(String endereco, PacienteCadastrado paciente){
        paciente.setEndereco(endereco);
    }
    
    public void atualizarPacienteTelefone(String telefone, PacienteCadastrado paciente){
        paciente.setTelefone(telefone);
    }
    
    public void atualizarPacienteConvenio(String convenio, PacienteCadastrado paciente){
        paciente.setConvenio(convenio);
    }
    
    public void removerPaciente(EntityManager em, String cpf){
        // Remove um paciente da lista de pacientes.
        PacienteCadastrado paciente = em.find(PacienteCadastrado.class, cpf);
        if(paciente != null){
            em.remove(paciente);
        }
    }
    
    public Consulta marcarConsulta(String data, String horario, MedicoCadastrado medico, PacienteCadastrado paciente, String tipoConsulta, EntityManager em){
        // Marca uma consulta, adicionando ela na lista de consultas
        Consulta novaConsulta = new Consulta(); 
        novaConsulta.setData(data);
        novaConsulta.setHorario(horario);
        novaConsulta.setMedico(medico);
        novaConsulta.setPaciente(paciente);
        novaConsulta.setTipoConsulta(tipoConsulta);
        em.persist(novaConsulta);
        return novaConsulta;
    }
    /*
    public Consulta buscarConsulta(String data, String horario, Medico medico){
        Busca uma consulta por meio da data, horario e medico da consulta marcada na lista de consultas. 
        Retorna um objeto do tipo consulta.
        Consulta consultaBuscada = null;
        for(int i = 0; i < listaConsultas.size(); i++){
            if(listaConsultas.get(i).getData().equals(data) && listaConsultas.get(i).getHorario().equals(horario) && listaConsultas.get(i).getMedico().equals(medico)){
                consultaBuscada = listaConsultas.get(i);
            }
        }
        return consultaBuscada;
    }
    */
    // Os métodos a seguir atualizam os dados de uma consulta
    public void atualizarConsultaData(String data, Consulta consulta){
        consulta.setData(data);
    }
    
    public void atualizarConsultaHorario(String horario, Consulta consulta){
        consulta.setHorario(horario);
    }
   
    public void atualizarConsultaMedico(MedicoCadastrado medico, Consulta consulta){
        consulta.setMedico(medico);
    }
    
    public void atualizarConsultaPaciente(PacienteCadastrado paciente, Consulta consulta){
        consulta.setPaciente(paciente);
    }
    
    public void atualizarConsultaTipo(String tipoConsulta, Consulta consulta){
        consulta.setTipoConsulta(tipoConsulta);
    }
    
    public void removerConsulta(Consulta consulta, EntityManager em){
        // Remove uma consulta da lista de consultas
        em.remove(consulta);
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

    