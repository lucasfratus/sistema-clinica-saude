package Staff;

import Staff.Secretaria;
import Atendimento.Consulta;
import Atendimento.Paciente;
import java.util.ArrayList;

public class GerenciadorDeMensagens {
    private Secretaria secretaria;
    private ArrayList<String> mensagensEnviadas;
    
    public ArrayList<Consulta> getPacientesComContato(String dataDeAmanha){
        ArrayList[] relatorio = new ArrayList[2];
        relatorio = secretaria.gerarRelatorio(dataDeAmanha);
        return relatorio[1];
    }
    
    public void mandarEmail(String mensagem, String email){
    }
    
    public void mandarSms(String mensagem, String telefone){
    }
    
    public String enviarMensagens(String dataDeAmanha){
        ArrayList<Consulta> listaConsultas = new ArrayList();
        listaConsultas = getPacientesComContato(dataDeAmanha);
       
        for(int i = 0; i < listaConsultas.size(); i++){
            Paciente paciente = listaConsultas.get(i).getPaciente();
            Consulta consulta = listaConsultas.get(i);
            if ("NaoInformado".equals(paciente.getEmail())) {
                String mensagem = "Prezado(a) " + paciente.getNome() + " A sua consulta com o(a) Doutor(a) " + consulta.getMedico().getNome() + " eh amanha, as"
                        + " " + consulta.getHorario() ;
                mandarSms(mensagem, paciente.getTelefone());
                mensagensEnviadas.add("Enviado ao numero: " + paciente.getTelefone() + "\n" + mensagem);
            } else {
                String mensagem = "Prezado(a) " + paciente.getNome() + " A sua consulta com o(a) Doutor(a) " + consulta.getMedico().getNome() + " eh amanha, as"
                        + " " + consulta.getHorario() ;
                mandarEmail(mensagem, paciente.getEmail());
                mensagensEnviadas.add("Enviado ao email: " + paciente.getEmail() + "\n" + mensagem);
            }
        }
        return "Mensagens enviadas com sucesso";   
    }
    
    public String visualizarMensagensEnviadas(){
        String buffer = null;
        for(int x = 0; x < mensagensEnviadas.size(); x++){
            buffer = buffer + '\n' + mensagensEnviadas.get(x);
        }
        return buffer;
    }
}
