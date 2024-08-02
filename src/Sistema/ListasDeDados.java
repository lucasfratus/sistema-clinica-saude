package Sistema;

import Atendimento.Consulta;
import Atendimento.Paciente;
import EmpregadosClinica.GerenciadorDeMensagens;
import EmpregadosClinica.Medico;
import EmpregadosClinica.Secretaria;
import java.util.ArrayList;

public class ListasDeDados {
    private ArrayList<Consulta> consultasMarcadas;
    private ArrayList<Paciente> pacientesCadastrados;
    private ArrayList<Medico> medicos;  
    private ArrayList<Secretaria> secretarias;
    private ArrayList<GerenciadorDeMensagens> gerenciadores;

    public ListasDeDados(ArrayList<Consulta> consultasMarcadas, ArrayList<Paciente> pacientesCadastrados, ArrayList<Medico> medicos, ArrayList<GerenciadorDeMensagens> gerenciador) {
        this.consultasMarcadas = consultasMarcadas;
        this.pacientesCadastrados = pacientesCadastrados;
        this.medicos    = medicos;
        this.secretarias = secretarias;
        this.gerenciadores = gerenciador;
    }

    public ListasDeDados(){
    }

    public ArrayList<Consulta> getConsultasMarcadas() {
        return consultasMarcadas;
    }

    public void setConsultasMarcadas(ArrayList<Consulta> consultasMarcadas) {
        this.consultasMarcadas = consultasMarcadas;
    }

    public ArrayList<Paciente> getPacientesCadastrados() {
        return pacientesCadastrados;
    }

    public void setPacientesCadastrados(ArrayList<Paciente> pacientesCadastrados) {
        this.pacientesCadastrados = pacientesCadastrados;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }
    
    public ArrayList[] TestarConsultasEPacientes(){
        // Gera dados pré-definidos para facilitar o teste do código. Retorna um ArrayList com todos os dados gerados.
        ArrayList<Paciente> pacientes1 = new ArrayList();
        ArrayList<Consulta> consultas1 = new ArrayList();
        ArrayList<Medico> medicos1 = new ArrayList();
        ArrayList<Secretaria> secretarias1 = new ArrayList();
        ArrayList<GerenciadorDeMensagens> gerenciadores1 = new ArrayList();
        
        ArrayList[] dadosParaTeste = new ArrayList[5];

        // Criando pacientes para o teste
        Paciente paciente0 = new Paciente("Wednesday Addams", "12345678901", "13/01/2006", "123, Rua Fulano de Tal, Bairro Landia, Cidade Metropole", "Particular",
                   "Nao Informado", "Nao Informado");
        pacientes1.add(paciente0);
        
        Paciente paciente1 = new Paciente("Tireon Lanester", "99732380012", "01/04/1968" , "500, Avenida Pedro Amaro dos Santos 585, Centro, Alto Paraiso", "Plano de Saude",
                "tireongamer234@hotmail.com","(46) 98781-7115");
        pacientes1.add(paciente1);
        
        Paciente paciente2 = new Paciente("Shadow The Hedgehog", "00000000007", "23/06/2002", "571, Rua Intergalactica 701, Colonia Espacial Ark", "Particular",
                "shadowdarkpro@outlook.com","(18) 2819-5167");
        pacientes1.add(paciente2);
        
        Paciente paciente3 = new Paciente("Matt Ishida", "11111111137", "24/02/2005", "7, Rua Yokohama 666, Odaiba", "Particular",
                "gabumonmattt@yahoo.com.br", "(92) 98481-3332");
        pacientes1.add(paciente3);
        
        Paciente paciente4 = new Paciente("Kuririn", "77777777700", "11/03/736", "Casa do Kame (NBI 8250012 B.)", "Plano de Saúde",
                "seteesferas@dbmail.com", "(77) 7777-7777");
        pacientes1.add(paciente4);

        // Criando médicos para o teste
        Medico medico1 = new Medico("Geralt Robotnik", "1234516-7/BR", "Geneticista", 3,pacientes1,consultas1);
        medicos1.add(medico1);
        
        Medico medico2 = new Medico("Maki Gero", "20202020-2/JP", "Neurocirurgiao", 4, pacientes1, consultas1);
        medicos1.add(medico2);
        
        Medico medico3 = new Medico("Ivo Robotnik", "777777-1/BR", "Infectologista", 2, pacientes1, consultas1);
        medicos1.add(medico3);
                
        // Criando uma secretaria para o teste
        Secretaria secretaria1 = new Secretaria("Missandei", pacientes1, consultas1, medicos1);   
        secretarias1.add(secretaria1);
        
        // Marcando consultas para o teste
        secretaria1.marcarConsulta("02/08/2024", "16:30", medico3, paciente0, "Consulta normal");
        secretaria1.marcarConsulta("05/08/2024", "12:30", medico2, paciente1, "Consulta retorno");
        secretaria1.marcarConsulta("02/08/2024", "13:30", medico1, paciente2, "Consulta normal");
        
        // mensagens enviadas
        ArrayList<String> msgEnviadas = new ArrayList();
        // Criando um objeto gerenciador
        GerenciadorDeMensagens gerenciador = new GerenciadorDeMensagens(secretaria1, msgEnviadas);
        gerenciadores1.add(gerenciador);
        
        // Setando o array para o return
        dadosParaTeste[0] = pacientes1;
        dadosParaTeste[1] = consultas1;
        dadosParaTeste[2] = medicos1;
        dadosParaTeste[3] = secretarias1;
        dadosParaTeste[4] = gerenciadores1;
        
        
        return dadosParaTeste;
    }
    

}
