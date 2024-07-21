/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Staff;

import Atendimento.Consulta;
import Atendimento.Paciente;
import java.util.ArrayList;

public class Secretaria {
    private String nomeFuncionario;
    private Paciente paciente;
    private Consulta consulta;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Consulta> listaConsultas;

    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Paciente cadastrarPaciente(String nome, String email, String cpf, String dataNascimento, String endereco, String telefone, String convenio){
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setCpf(cpf);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setTelefone(telefone);
        paciente.setConvenio(convenio);
        listaPacientes.add(paciente);
        return paciente;
    }
    
    public void atualizarPacienteNome(String nome){
        paciente.setNome(nome); 
    }
    
    public void atualizarPacienteEmail(String email){
        paciente.setEmail(email); 
    }
    
    public void atualizarPacienteCpf(String cpf){
        paciente.setCpf(cpf); 
    }
    
    public void atualizarPacienteDataNascimento(String dataNascimento){
        paciente.setDataNascimento(dataNascimento); 
    }
    
    public void atualizarPacienteEndereco(String endereco){
        paciente.setEndereco(endereco);
    }
    
    public void atualizarPacienteTelefone(String telefone){
        paciente.setTelefone(telefone);
    }
    
    public void atualizarPacienteConvenio(String convenio){
        paciente.setConvenio(convenio);
    }
    
    public void removerPaciente(Paciente paciente){
        listaPacientes.remove(paciente);
    }
    
    public Consulta marcarConsulta(String data, String horario, Medico medico, Paciente paciente, String tipoConsulta){
        consulta.setData(data);
        consulta.setHorario(horario);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setTipoConsulta(tipoConsulta);
        listaConsultas.add(consulta);
        return consulta;
    }
    
    public void atualizarConsultaData(String data){
        consulta.setData(data);
    }
    
    public void atualizarConsultaHorario(String horario){
        consulta.setHorario(horario);
    }
   
    public void atualizarConsultaMedico(Medico medico){
        consulta.setMedico(medico);
    }
    
    public void atualizarConsultaPaciente(Paciente paciente){
        consulta.setPaciente(paciente);
    }
    
    public void atualizarConsultaPaciente(String tipoConsulta){
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
                    relatorioSemContato.add(listaConsultas.get(i));
                } else {
                    relatorioComContato.add(listaConsultas.get(i));
                }        
            }
        System.out.println("---Relatório de Consultas de Amanha---\n" + 
                "Com email/telefone:\n" + relatorioComContato + "\n" + "Sem email/telefone:\n" + relatorioSemContato);
    }









}

    