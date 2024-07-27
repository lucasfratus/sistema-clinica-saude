package Main;

import Atendimento.Consulta;
import Atendimento.Paciente;
import Fichas.Prontuario;
import Fichas.RelatoriosMedicos;
import Staff.GerenciadorDeMensagens;
import Staff.Medico;
import Sistema.ListasDeDados;
import Staff.Secretaria;
import java.util.Scanner;
import java.util.ArrayList;

public class Interface {
    public static void main(String[] args){        
        ListasDeDados dados = new ListasDeDados();
        
        ArrayList[] dadosParaTeste = dados.TestarConsultasEPacientes();
        ArrayList<Paciente> pacientes = dadosParaTeste[0];
        ArrayList<Consulta> consultas = dadosParaTeste[1];
        ArrayList<Medico> medicos = dadosParaTeste[2];
        ArrayList<Secretaria> secretarias = dadosParaTeste[3];
        Secretaria secretaria = secretarias.get(0);
        for(int x = 0; x < pacientes.size(); x++){
            System.out.println("paciente:" + pacientes.get(x).getNome());
        }
        Scanner leitura = new Scanner(System.in);
        int opcao0 = 0;
        switch(opcao0){
            default:
            int opcao1;
            do{
            System.out.println();
            System.out.println("----- Sistema de controle: Saúde & Cia -----");
            System.out.println("Selecione seu cargo: \n1. Secretaria \n2. Medico \n3. Gerenciador de Mensagens \n4. Encerrar Sistema");
            opcao1 = leitura.nextInt();
            switch(opcao1){  
                case 1:
                    int opcao2;
                    do{
                    System.out.println();
                    System.out.println("O que você deseja fazer? ");
                    System.out.println("1. Gerenciar Pacientes \n2. Gerenciar Consultas \n3. Gerar Relatorio\n4. Voltar ao menu anterior");
                    opcao2 = leitura.nextInt();
                    switch(opcao2){
                        case 1:
                            int opcao3;
                            do{
                            System.out.println();
                            System.out.println("O que você deseja fazer? ");
                            System.out.println("1. Cadastrar Paciente \n2. Remover Paciente \n3. Atualizar Paciente\n4. Voltar ao menu anterior");
                            opcao3 = leitura.nextInt();
                            switch(opcao3){
                                case 1:
                                    System.out.println();
                                    leitura.nextLine(); // Lê o \n
                                    System.out.println("------NOVO PACIENTE------");
                                    System.out.println("Insira o nome: ");
                                    String nome = leitura.nextLine();
                                    System.out.println("Insira o cpf: ");
                                    String cpf = leitura.nextLine();
                                    System.out.println("Insira o email(Caso não haja, colocar 'NaoInformado'): ");
                                    String email = leitura.nextLine();
                                    System.out.println("Insira a data de nascimento(formato: xx/xx/xxxx): ");
                                    String dataNasc = leitura.nextLine();
                                    System.out.println("Insira o endereco: ");
                                    String endereco = leitura.nextLine();
                                    System.out.println("Insira o telefone(Caso não haja, colocar 'NaoInformado'): ");
                                    String telefone = leitura.nextLine();
                                    System.out.println("Insira o convênio: ");
                                    String convenio = leitura.next();
                                    Paciente paciente = secretaria.cadastrarPaciente(nome, cpf, email, dataNasc, endereco, telefone, convenio);
                                    System.out.println("Paciente " + paciente.getNome() + " cadastrado com sucesso");
                        }   
                        } while(opcao3 != 4);
                    }
                    } while (opcao2 != 4);
            }   
            }while (opcao1 != 4);
        }
    }
}

