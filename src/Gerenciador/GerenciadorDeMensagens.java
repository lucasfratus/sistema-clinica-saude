/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciador;

import Staff.Secretaria;
import Atendimento.Consulta;
import java.util.ArrayList;
import Atendimento.Paciente;
/**
 *
 * @author lucas
 */
public class GerenciadorDeMensagens {
    private Secretaria secretaria;
    
    public ArrayList<Consulta> getPacientesComContato(String dataDeAmanha){
        ArrayList[] relatorio = new ArrayList[2];
        relatorio = secretaria.gerarRelatorio(dataDeAmanha);
        return relatorio[1];
    }
    
    public void mandarEmail(String mensagem, String email){
    }
    
    public void mandarSms(String mensagem, String telefone){
    }
    
    public void enviarMensagens(String dataDeAmanha){
        ArrayList<Consulta> listaConsultas = new ArrayList();
        listaConsultas = getPacientesComContato(dataDeAmanha);
        for(int i = 0; i < listaConsultas.size(); i++){
            Paciente paciente = listaConsultas.get(i).getPaciente();
            Consulta consulta = listaConsultas.get(i);
            if ("Nao Informado".equals(paciente.getEmail())) {
                String mensagem = "Prezado(a) " + paciente.getNome() + " A sua consulta com o(a) Doutor(a) " + consulta.getMedico().getNome() + " é amanhã, as"
                        + " " + consulta.getHorario() ;
                mandarSms(mensagem, paciente.getTelefone());
            }
        }
    }
    
}
