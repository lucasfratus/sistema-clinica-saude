package Staff;

import Atendimento.Consulta;
import Atendimento.Paciente;
import java.util.ArrayList;

public class Secretaria {
    private String nomeFuncionario;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Consulta> listaConsultas;

    public Secretaria(String nomeFuncionario, ArrayList<Paciente> listaPacientes, ArrayList<Consulta> listaConsultas) {
        this.nomeFuncionario = nomeFuncionario;
        this.listaPacientes = listaPacientes;
        this.listaConsultas = listaConsultas;
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

    public Paciente buscarPaciente(String cpf, ArrayList<Paciente> listaPacientes){
        Paciente paciente = null;
        for(int i = 0; i < listaPacientes.size(); i++){
            if (listaPacientes.get(i).getCpf() == cpf) {
                paciente = listaPacientes.get(i);
            }    
        }
        return paciente;
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
    
    public void gerarRelatorio(String dataDeAmanha){
        ArrayList<Consulta> relatorioComContato = new ArrayList();
        ArrayList<Consulta> relatorioSemContato = new ArrayList();
        for(int i = 0; i < listaConsultas.size(); i++)
            if (listaConsultas.get(i).getData() == dataDeAmanha) {
                if (listaConsultas.get(i).getPaciente().getTelefone() == null & listaConsultas.get(i).getPaciente().getEmail() == null){
                    relatorioSemContato.add(String.valueOf(listaConsultas.get(i)));
                } else {
                    relatorioComContato.add(listaConsultas.get(i));
                }        
            }
        System.out.println("---Relatório de Consultas de Amanha---\n" + 
                "Com email/telefone:\n" + relatorioComContato + "\n" + "Sem email/telefone:\n" + relatorioSemContato);
    }









}

    