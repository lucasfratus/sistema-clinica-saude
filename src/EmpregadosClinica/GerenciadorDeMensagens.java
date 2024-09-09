package EmpregadosClinica;

import EmpregadosClinica.Secretaria;
import Atendimento.Consulta;
import Atendimento.Paciente;
import java.util.ArrayList;

public class GerenciadorDeMensagens {
    private String cpf;
    private Secretaria secretaria;
    private ArrayList<String> mensagensEnviadas;
    
    public GerenciadorDeMensagens(Secretaria secretaria,ArrayList<String> mensagensEnviadas) {
        this.secretaria = secretaria;
        this.mensagensEnviadas = mensagensEnviadas;
    }
    
    public ArrayList<Consulta> getPacientesComContato(String dataDeAmanha){
        // Retorna um ArrayList de consultas que os pacientes possuem alguma forma de contato(email ou telefone)
        ArrayList[] relatorio = new ArrayList[2];
        relatorio = secretaria.gerarRelatorio(dataDeAmanha);
        return relatorio[1];
    }
    
    public void mandarEmail(String mensagem, String email){
        // Representa o envio de um email, que possui uma mensagem, ao paciente que possui um telefone.
    }
    
    public void mandarSms(String mensagem, String telefone){
        // Representa o envio de um SMS, que possui uma mensagem, ao paciente que possui um telefone.
    }
    
    public String enviarMensagens(String dataDeAmanha){
        // Envia mensagens aos pacientes que possuem email/telefone e possuem uma consulta marcada no próximo dia.
        ArrayList<Consulta> listaConsultas = new ArrayList();
        listaConsultas = getPacientesComContato(dataDeAmanha);
       
        for(int i = 0; i < listaConsultas.size(); i++){
            Paciente paciente = listaConsultas.get(i).getPaciente();
            Consulta consulta = listaConsultas.get(i);
            if ("Nao Informado".equals(paciente.getEmail())) {
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
        // Possibilita a visualização de todas as mensagens enviadas anteriormente,
        String buffer = null;
        for(int x = 0; x < mensagensEnviadas.size(); x++){
            buffer = buffer + '\n' + mensagensEnviadas.get(x);
        }
        return buffer;
    }
}
