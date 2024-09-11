package EmpregadosClinica;

import Atendimento.Consulta;
import Atendimento.Paciente;
import Sistema.PacienteCadastrado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GerenciadorDeMensagens {
    private String cpf;
    private String nome;
    private EntityManager em;
    
    public GerenciadorDeMensagens(String cpf, String nome, EntityManager em){
        this.cpf = cpf;
        this.nome = nome;
        this.em = em;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public void mandarEmail(String mensagem, String email){
        // Representa o envio de um email, que possui uma mensagem, ao paciente que possui um telefone.
    }
    
    public void mandarSms(String mensagem, String telefone){
        // Representa o envio de um SMS, que possui uma mensagem, ao paciente que possui um telefone.
    }
    
    public List<String> enviarMensagens(String dataDeAmanha){
        // Envia mensagens aos pacientes que possuem email/telefone e possuem uma consulta marcada no dia desejado.
        Query query = em.createNamedQuery("findConsultas");
        query.setParameter("dataAmanha", dataDeAmanha);
        List<Consulta> listaConsultas = query.getResultList(); 
       
        List<String> mensagensEnviadas = new ArrayList<String>();
        if(mensagensEnviadas.isEmpty() == false){
            for(int i = 0; i < listaConsultas.size(); i++){
                PacienteCadastrado paciente = listaConsultas.get(i).getPaciente();
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
    }
        return mensagensEnviadas;   
    }
}
