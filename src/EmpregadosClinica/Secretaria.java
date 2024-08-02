package EmpregadosClinica;

import Atendimento.Consulta;
import Atendimento.Paciente;
import java.util.ArrayList;


public class Secretaria {
    private String nomeFuncionario;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<Medico> listaMedicos;

    public Secretaria(String nomeFuncionario, ArrayList<Paciente> listaPacientes, ArrayList<Consulta> listaConsultas, ArrayList<Medico> listaMedicos) {
        this.nomeFuncionario = nomeFuncionario;
        this.listaPacientes = listaPacientes;
        this.listaConsultas = listaConsultas;
        this.listaMedicos = listaMedicos;
    }
        
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    
    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(ArrayList<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }
    
    
    public Paciente cadastrarPaciente(String nome,String cpf, String email, String dataNascimento, String endereco, String telefone, String convenio){
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
    
    public Medico buscarMedico(String nomeMedico){
        Medico medicoBuscado = null;
        for(int i = 0; i < listaMedicos.size(); i++){
            if (listaMedicos.get(i).getNome().equals(nomeMedico)) {
                medicoBuscado = listaMedicos.get(i);
            }    
        }
        return medicoBuscado;
    }
    
    public void atualizarPacienteNome(String novoNome, Paciente paciente){
        paciente.setNome(novoNome); 
    }
    
    public void atualizarPacienteEmail(String email, Paciente paciente){
        paciente.setEmail(email); 
    }
    
    public void atualizarPacienteCpf(String cpf, Paciente paciente){
        paciente.setCpf(cpf); 
    }
    
    public void atualizarPacienteDataNascimento(String dataNascimento, Paciente paciente){
        paciente.setDataNascimento(dataNascimento); 
    }
    
    public void atualizarPacienteEndereco(String endereco, Paciente paciente){
        paciente.setEndereco(endereco);
    }
    
    public void atualizarPacienteTelefone(String telefone, Paciente paciente){
        paciente.setTelefone(telefone);
    }
    
    public void atualizarPacienteConvenio(String convenio, Paciente paciente){
        paciente.setConvenio(convenio);
    }
    
    public void removerPaciente(Paciente paciente){
        listaPacientes.remove(paciente);
    }
    
    public Consulta marcarConsulta(String data, String horario, Medico medico, Paciente paciente, String tipoConsulta){
        Consulta novaConsulta = new Consulta(); 
        novaConsulta.setData(data);
        novaConsulta.setHorario(horario);
        novaConsulta.setMedico(medico);
        novaConsulta.setPaciente(paciente);
        novaConsulta.setTipoConsulta(tipoConsulta);
        listaConsultas.add(novaConsulta);
        return novaConsulta;
    }
    
    public Consulta buscarConsulta(String data, String horario, Medico medico){
        Consulta consultaBuscada = null;
        for(int i = 0; i < listaConsultas.size(); i++){
            if(listaConsultas.get(i).getData().equals(data) && listaConsultas.get(i).getHorario().equals(horario) && listaConsultas.get(i).getMedico().equals(medico)){
                consultaBuscada = listaConsultas.get(i);
            }
        }
        return consultaBuscada;
    }
    
    public void atualizarConsultaData(String data, Consulta consulta){
        consulta.setData(data);
    }
    
    public void atualizarConsultaHorario(String horario, Consulta consulta){
        consulta.setHorario(horario);
    }
   
    public void atualizarConsultaMedico(Medico medico, Consulta consulta){
        consulta.setMedico(medico);
    }
    
    public void atualizarConsultaPaciente(Paciente paciente, Consulta consulta){
        consulta.setPaciente(paciente);
    }
    
    public void atualizarConsultaPaciente(String tipoConsulta, Consulta consulta){
        consulta.setTipoConsulta(tipoConsulta);
    }
    
    public void removerConsulta(Consulta consulta){
        listaConsultas.remove(consulta);
    } 
   
    public ArrayList[] gerarRelatorio(String data){
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
}

    