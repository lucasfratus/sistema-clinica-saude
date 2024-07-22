package Main;

import Atendimento.Consulta;
import Atendimento.Paciente;
import Fichas.Prontuario;
import Fichas.RelatoriosMedicos;
import Gerenciador.GerenciadorDeMensagens;
import Staff.Medico;
import Staff.Secretaria;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Paciente> pacientes1 = new ArrayList();
        ArrayList<Consulta> consultas1 = new ArrayList();
        ArrayList<Medico> medicos1 = new ArrayList();
        
        Paciente paciente0 = new Paciente("Wednesday Addams", "123.456.789-01", "13/01/2006", "123, Rua Fulano de Tal, Bairro Landia, Cidade Metropole", "Particular",
                "wandinha123@gmail.com","(44)99101-0160");
        pacientes1.add(paciente0);
        
        Paciente paciente1 = new Paciente("Tireon Lanester", "997.323.800-12", "01/04/1968" , "500, Avenida Pedro Amaro dos Santos 585, Centro, Alto Paraiso", "Plano de Saude",
                "tireongamer234@hotmail.com","(46) 98781-7115");
        pacientes1.add(paciente1);
        
        Paciente paciente2 = new Paciente("Shadow The Hedgehog", "000.000.000-07", "23/06/2002", "571, Rua Intergalactica 701, Colonia Espacial Ark", "Particular",
                "shadowdarkpro@outlook.com","(18) 2819-5167");
        pacientes1.add(paciente2);
        
        Paciente paciente3 = new Paciente("Matt Ishida", "111.111.111-37", "24/02/2005", "7, Rua Yokohama 666, Odaiba", "Particular",
                "gabumonmattt@yahoo.com.br", "(92) 98481-3332");
        pacientes1.add(paciente3);
        
        Paciente paciente4 = new Paciente("Kuririn", "777.777.777-00", "11/03/736", "Casa do Kame (NBI 8250012 B.)", "Plano de Saúde",
                "seteesferas@dbmail.com", "(77) 7777-7777");
        pacientes1.add(paciente4);

        Medico medico1 = new Medico("Geralt Robotnik", "1234516-7/BR", "Geneticista", 3);
        medicos1.add(medico1);
        
        Medico medico2 = new Medico("Maki Gero", "20202020-2/JP", "Neurocirurgiao", 4);
        medicos1.add(medico2);
        
        Medico medico3 = new Medico("Ivo Robotnik", "777777-1/BR", "Infectologista", 2);
        medicos1.add(medico3);
                
        
        
        Secretaria secretaria1 = new Secretaria("Missandei", pacientes1, consultas1);        
        // Marcar Consultas
        secretaria1.marcarConsulta("22/07/2024", "16:30", medico3, paciente0, "Consulta normal");
        secretaria1.marcarConsulta("01/08/2024", "12:30", medico2, paciente1, "Consulta retorno");
        secretaria1.marcarConsulta("22/07/2024", "13:30", medico1, paciente2, "Consulta normal");
        
        // Gerar relatorios
        secretaria1.gerarRelatorio("22/07/2024");
        
        /*
        int opcao;
        
        System.out.println("----- Sistema de controle: Saúde & Cia -----");
        Scanner leitura = new Scanner(System.in);
        System.out.println("Selecione seu cargo: \n (1) Secretaria \n (2) Medico \n (3) Gerenciador de Mensagens");
        opcao = leitura.nextInt();
        if(opcao == 1){  
            System.out.println("O que você deseja fazer? ");
            System.out.println("(1) Gerenciar Pacientes \n (2) Gerenciar Consultas \n (3) Gerar Relatorio \n");
            opcao = leitura.nextInt();  
        }
        */
    }
}
