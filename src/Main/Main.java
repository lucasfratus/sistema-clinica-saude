package Main;

import Atendimento.Consulta;
import Atendimento.Paciente;
import Fichas.Prontuario;
import Fichas.RelatoriosMedicos;
import Gerenciador.GerenciadorDeMensagens;
import Staff.Medico;
import Staff.Secretaria;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Secretaria secretaria = new Secretaria();
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
    }
}
