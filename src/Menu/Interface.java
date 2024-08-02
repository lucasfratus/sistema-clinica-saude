package Menu;

import Atendimento.Consulta;
import Atendimento.Paciente;
import Fichas.Prontuario;
import Fichas.RelatoriosMedicos;
import EmpregadosClinica.GerenciadorDeMensagens;
import EmpregadosClinica.Medico;
import Sistema.ListasDeDados;
import EmpregadosClinica.Secretaria;
import java.util.Scanner;
import java.util.ArrayList;

public class Interface {
    public static void main(String[] args){        
        ListasDeDados dados = new ListasDeDados();
        
        String dataDeHoje = "01/08/2024";
        String dataDeAmanha = "02/08/2024";
        ArrayList[] dadosParaTeste = dados.TestarConsultasEPacientes();
        ArrayList<Paciente> pacientes = dadosParaTeste[0];
        ArrayList<Consulta> consultas = dadosParaTeste[1];
        ArrayList<Medico> medicos = dadosParaTeste[2];
        ArrayList<Secretaria> secretarias = dadosParaTeste[3];
        ArrayList<GerenciadorDeMensagens> gerenciadores = dadosParaTeste[4];
        Secretaria secretaria = secretarias.get(0); // define uma secretaria padrao
        GerenciadorDeMensagens gerenciador = gerenciadores.get(0); // define um gerenciador de mensagens padrao
        Scanner leitura = new Scanner(System.in);
        int opcao0 = 0;
        String Voltar = "";
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
                            Voltar = "";
                            System.out.println();
                            leitura.nextLine(); // Lê o \n;
                            System.out.println();
                            System.out.println("O que você deseja fazer? ");
                            System.out.println("1. Cadastrar Paciente \n2. Remover Paciente \n3. Atualizar Paciente\n4. Voltar ao menu anterior");
                            opcao3 = leitura.nextInt();
                            Voltar = "voltar";
                            switch(opcao3){
                                case 1:
                                    System.out.println();
                                    leitura.nextLine(); // Lê o \n
                                    System.out.println("------NOVO PACIENTE------");
                                    System.out.println("Insira o nome: ");
                                    String nome = leitura.nextLine();
                                    System.out.println("Insira o cpf(apenas números): ");
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
                                    Voltar = "voltar";
                                    break;
                                    
                                case 2:
                                    System.out.println();
                                    leitura.nextLine(); // Lê o \n
                                    System.out.println("Insira o CPF do paciente que deseja remover(Apenas numeros): ");
                                    String cpfBuscado = leitura.nextLine();
                                    Paciente pacienteBuscado = secretaria.buscarPaciente(cpfBuscado);
                                    if (pacienteBuscado == null){
                                        System.out.println("Paciente nao encontrado.(Pressione ENTER)");
                                    } else{
                                        secretaria.removerPaciente(pacienteBuscado);
                                        System.out.println("Paciente " + pacienteBuscado.getNome() + " removido.");
                                    }
                                    Voltar = "voltar";
                                    break;
                                    
                                case 3:
                                    int opcao32;
                                    Voltar = "";
                                    do{
                                    System.out.println();
                                    leitura.nextLine(); // Lê o \n
                                    System.out.println("Insira o CPF do paciente que deseja atualizar(Apenas numeros): ");
                                    String cpfAtualizar = leitura.nextLine();
                                    Paciente pacienteAtualizado = secretaria.buscarPaciente(cpfAtualizar);
                                    if (pacienteAtualizado == null){
                                        System.out.println("Paciente nao encontrado.(Pressione ENTER)");
                                        Voltar = "voltar";
                                        break;
                                    } else{ 
                                        System.out.println("O que você deseja atualizar?");
                                        System.out.println("1. Nome \n2. CPF \n3. Data de Nascimento \n4. Endereco \n5. Telefone \n6. E-mail \n7. Convenio\n8. Voltar");
                                        opcao32 = leitura.nextInt();
                                        switch(opcao32){
                                            case 1:
                                                System.out.println();
                                                leitura.nextLine(); // Lê o \n
                                                System.out.println("Insira o novo nome: ");
                                                String nomeAtualizado = leitura.nextLine();
                                                pacienteAtualizado.setNome(nomeAtualizado);
                                                Voltar = "voltar";
                                                break;
                                            case 2:
                                                System.out.println();
                                                leitura.nextLine(); // Lê o \n
                                                System.out.println("Insira o novo CPF: ");
                                                String cpfAtualizado = leitura.nextLine();
                                                pacienteAtualizado.setCpf(cpfAtualizado);
                                                Voltar = "voltar";
                                                break;
                                            case 3:
                                                System.out.println();
                                                leitura.nextLine(); // Lê o \n
                                                System.out.println("Insira a nova data de nascimento: ");
                                                String nascAtualizado = leitura.nextLine();
                                                pacienteAtualizado.setDataNascimento(nascAtualizado);
                                                Voltar = "voltar";
                                                break;
                                            case 4:
                                                System.out.println();
                                                leitura.nextLine(); // Lê o \n
                                                System.out.println("Insira o novo endereco: ");
                                                String enderecoAtualizado = leitura.nextLine();
                                                pacienteAtualizado.setEndereco(enderecoAtualizado);
                                                Voltar = "voltar";
                                                break;
                                            case 5:
                                                System.out.println();
                                                leitura.nextLine(); // Lê o \n
                                                System.out.println("Insira o novo telefone: ");
                                                String telefoneAtualizado = leitura.nextLine();
                                                pacienteAtualizado.setTelefone(telefoneAtualizado);
                                                System.out.println("Telefone Atualizado com sucesso(Pressione ENTER)");
                                                Voltar = "voltar";
                                                break;
                                            case 6:
                                                System.out.println();
                                                leitura.nextLine();
                                                System.out.println("Insira o novo e-mail: ");
                                                String emailAtualizado = leitura.nextLine();
                                                pacienteAtualizado.setEmail(emailAtualizado);
                                                Voltar = "voltar";
                                                break;
                                            case 7:
                                                System.out.println();
                                                leitura.nextLine();
                                                System.out.println("Insira o novo convenio: ");
                                                String convenioAtualizado = leitura.nextLine();
                                                pacienteAtualizado.setConvenio(convenioAtualizado); 
                                                Voltar = "voltar";
                                                break;
                                            }
                                        } 
                                    } while(opcao32 != 8|| Voltar.equals(""));
                                break;
                            } 
                        } while(opcao3 != 4 || Voltar.equals(""));
                        break;
                        case 2:
                            int opcao321;
                            do{
                            Voltar = "voltar";
                            System.out.println();
                            leitura.nextLine(); // Lê o \n
                            System.out.println("O que deseja fazer? ");
                            System.out.println("1. Marcar consulta \n2. Desmarcar consulta \n3. Atualizar consulta\n4. Voltar ao anterior");
                            opcao321 = leitura.nextInt();
                            switch(opcao321){
                                case 1:
                                    System.out.println();
                                    leitura.nextLine(); // Lê o \n
                                    System.out.println("Insira o CPF(apenas numeros) do paciente(deve estar cadastrado): ");
                                    String cpfConsulta = leitura.nextLine();
                                    Paciente pacienteConsulta = secretaria.buscarPaciente(cpfConsulta);
                                    if (pacienteConsulta == null){
                                        System.out.println("Paciente nao encontrado.(Pressione ENTER)");
                                        Voltar = "voltar";
                                        break;
                                    } else {
                                        System.out.println("Insira o nome do médico: ");
                                        String nomeMedico = leitura.nextLine();
                                        Medico medicoConsulta = secretaria.buscarMedico(nomeMedico);
                                        if (medicoConsulta == null){
                                            System.out.println("Medico nao encontrado.(Pressione ENTER)");
                                            Voltar = "voltar";
                                            break;
                                        } else {
                                            System.out.println("Insira a data(Formato DD/MM/AAAA): ");
                                            String dataConsulta = leitura.nextLine();
                                            System.out.println("Insira o horário: ");
                                            String horarioConsulta = leitura.nextLine();
                                            System.out.println("Insira o tipo de consulta(Normal/Retorno): ");
                                            String tipoConsulta = leitura.nextLine();
                                            secretaria.marcarConsulta(dataConsulta,horarioConsulta,medicoConsulta,pacienteConsulta,tipoConsulta);
                                            System.out.println("Consulta marcado com sucesso");
                                            Voltar = "voltar";
                                            break;
                                        }
                                    }   
                                case 2:
                                    System.out.println();
                                    leitura.nextLine(); // Lê o \n
                                    System.out.println("Insira o médico da consulta que deseja desmarcar: ");
                                    String nomeMedico = leitura.nextLine();
                                    Medico medicoDesmarcado = secretaria.buscarMedico(nomeMedico);
                                    if (medicoDesmarcado == null){
                                        System.out.println("Medico nao encontrado.(Pressione ENTER)");
                                        Voltar = "voltar";
                                        break;
                                    } else {
                                        System.out.println("Insira a data da consulta:");
                                        String dataDesmarcada = leitura.nextLine();
                                        System.out.println("Insira o horario da consulta(formato hh:mm): ");
                                        String horarioDesmarcada = leitura.nextLine();
                                        Consulta consultaDesmarcada = secretaria.buscarConsulta(dataDesmarcada, horarioDesmarcada, medicoDesmarcado);
                                        if(consultaDesmarcada == null) {
                                            System.out.println("Consulta nao encontrada.(Pressione ENTER)");
                                            Voltar = "voltar";
                                            break;
                                        } else {
                                            secretaria.removerConsulta(consultaDesmarcada);
                                            System.out.println("Consulta desmarcada com sucesso.");
                                            Voltar = "voltar";
                                            break;
                                        }
                                    }
                                case 3:
                                    int opcao322;
                                    do {
                                    System.out.println();
                                    leitura.nextLine(); // Lê o \n
                                    System.out.println("Insira o médico da consulta que deseja atualizar: ");
                                    String nomeMedicoAtualizada = leitura.nextLine();
                                    Medico medicoAtualizada = secretaria.buscarMedico(nomeMedicoAtualizada);
                                    if (medicoAtualizada == null){
                                        System.out.println("Medico nao encontrado.(Pressione ENTER)");
                                        Voltar = "voltar";
                                        break;
                                    } else {
                                        Scanner leituraNova = new Scanner(System.in);
                                        leituraNova.useDelimiter("\n");
                                        System.out.println("Insira a data da consulta:");
                                        String dataAtualizada = leituraNova.next();
                                        System.out.println("Insira o horario da consulta(formato hh:mm): ");
                                        String horarioAtualizada = leituraNova.next();
                                        Consulta consultaAtualizada = secretaria.buscarConsulta(dataAtualizada, horarioAtualizada, medicoAtualizada);
                                        if(consultaAtualizada == null) {
                                            System.out.println("Consulta nao encontrada.(Pressione ENTER)");
                                            Voltar = "voltar";
                                            break;
                                        } else {
                                            System.out.println("O que deseja atualizar? ");
                                            System.out.println("1.Data \n2.Horario \n3.Medico \n4.Paciente \n5.Tipo de Consulta \n6.Voltar");
                                            opcao322 = leitura.nextInt();
                                            switch(opcao322){
                                                case 1:
                                                    Voltar = "";
                                                    System.out.println();
                                                    leitura.nextLine(); // Lê o \n
                                                    System.out.println("Insira o nova data(formato: dd/mm/aaaa): ");
                                                    dataAtualizada = leitura.nextLine();
                                                    consultaAtualizada.setData(dataAtualizada);
                                                    Voltar = "voltar";
                                                    break;
                                                case 2:
                                                    Voltar = "";
                                                    System.out.println();
                                                    leitura.nextLine(); // Lê o \n
                                                    System.out.println("Insira o novo horario(formato: hh:mm): ");
                                                    horarioAtualizada = leitura.nextLine();
                                                    consultaAtualizada.setHorario(horarioAtualizada);
                                                    Voltar = "voltar";
                                                    break;  
                                                case 3:
                                                    Voltar = "";
                                                    System.out.println();
                                                    leitura.nextLine(); // Lê o \n
                                                    System.out.println("Insira o novo medico: ");
                                                    nomeMedicoAtualizada = leitura.nextLine();
                                                    Medico medicoBuscado = secretaria.buscarMedico(nomeMedicoAtualizada);
                                                    if(medicoBuscado == null){
                                                        System.out.println("Medico nao encontrado.(Pressione ENTER)");
                                                        Voltar = "voltar";
                                                        break;
                                                    } else {
                                                        consultaAtualizada.setMedico(medicoBuscado);
                                                        System.out.println("Medico atualizado com sucesso.");
                                                    }
                                                    Voltar = "voltar";
                                                    break;
                                                case 4:
                                                    Voltar = "";
                                                    System.out.println();
                                                    leitura.nextLine(); // Lê o \n
                                                    System.out.println("Insira o CPF(apenas numeros) do paciente(deve estar cadastrado): ");
                                                    cpfConsulta = leitura.nextLine();
                                                    pacienteConsulta = secretaria.buscarPaciente(cpfConsulta);
                                                    if (pacienteConsulta == null){
                                                        System.out.println("Paciente nao encontrado.(Pressione ENTER)");
                                                        Voltar = "voltar";
                                                        break;
                                                    } else {
                                                            consultaAtualizada.setPaciente(pacienteConsulta);
                                                            System.out.println("Paciente atualizado com sucesso.");
                                                    }
                                                    break;
                                                case 5:
                                                    Voltar = "";
                                                    System.out.println();
                                                    leitura.nextLine(); // Lê o \n
                                                    System.out.println("Insira o novo tipo de consulta: ");
                                                    String novoTipoConsulta = leitura.nextLine();
                                                    consultaAtualizada.setTipoConsulta(novoTipoConsulta);
                                                    System.out.println("Tipo de consulta atualizado com sucesso.");
                                                    Voltar = "voltar";
                                                    break;
                                        }  
                                    } 
                            }
                            } while(opcao322 != 6 || Voltar.equals(""));
                            }
                            } while(opcao321 != 4 || Voltar.equals(""));
                            break;
                        case 3:
                            Voltar = "";
                            System.out.println();
                            leitura.nextLine(); // Lê o \n
                            secretaria.gerarRelatorio(dataDeAmanha);
                            System.out.println("Relatorio gerado com sucesso");
                            break;
                    }
                    break;
                    } while(opcao2 != 4 || Voltar.equals(""));
                    break;
                case 2:
                    int opcao211;
                    Voltar = "";
                    do{
                    System.out.println();
                    leitura.nextLine();
                    System.out.println("Insira o seu nome: ");
                    String nomeMedico = leitura.nextLine();
                    Medico medicoLogado = secretaria.buscarMedico(nomeMedico);
                    if(medicoLogado == null){
                        System.out.println("Medico nao encontrado");
                        Voltar = "voltar";
                        break;
                    } else {
                    System.out.println();
                    System.out.println("O que deseja fazer?");
                    System.out.println("1. Gerenciar Pacientes\n2. Gerenciar Prontuarios\n3. Gerar Relatórios Médicos\n4. Voltar");
                    opcao211 = leitura.nextInt();
                    switch(opcao211){
                        case 1:
                            Voltar = "";
                            System.out.println();
                            leitura.nextLine();
                            System.out.println("Insira o CPF do paciente desejado: ");
                            String cpfPaciente = leitura.nextLine();
                            Paciente pacienteBuscadoPorMedico = medicoLogado.buscarPaciente(cpfPaciente);
                            if(pacienteBuscadoPorMedico == null){
                                System.out.println("Paciente não encontrado.");
                                Voltar = "voltar";
                                break;
                            } else {
                            int opcao220;
                            do{
                            System.out.println();
                            System.out.println("1. Adicionar dados adicionais\n2. Atualizar dados adicionais\n3. Voltar ");
                            opcao220 = leitura.nextInt();
                            switch(opcao220){
                                case 1:
                                    Voltar = "";
                                    System.out.println();
                                    leitura.nextLine();
                                    System.out.println("O paciente fuma?(true/false)");
                                    boolean fuma = leitura.nextBoolean();
                                    System.out.println("O paciente bebe?(true/false)");
                                    boolean bebe = leitura.nextBoolean();
                                    System.out.println("O paciente possui diabete?(true/false)");
                                    boolean diabete = leitura.nextBoolean();
                                    System.out.println("O paciente possui colesterol alto?(true/false)");
                                    boolean colesterol = leitura.nextBoolean();
                                    System.out.println("O paciente possui alguma doenca cardiaca?(true/false)");
                                    boolean doencaCardiaca = leitura.nextBoolean();
                                    ArrayList<String> listaCirurgias = new ArrayList();
                                    pacienteBuscadoPorMedico.setCirurgias(listaCirurgias);
                                    System.out.println("Quantas cirurgias o paciente fez?");
                                    int qntdCirurgias = leitura.nextInt();
                                    if(qntdCirurgias > 0){
                                        System.out.println("Insira cada uma das cirurgias:");
                                        for(int x = 0; x <= qntdCirurgias; x++){
                                            String cirurgia = leitura.nextLine();
                                            listaCirurgias.add(cirurgia);
                                        }   
                                    }
                                    ArrayList<String> listaAlergias = new ArrayList();
                                    pacienteBuscadoPorMedico.setAlergias(listaAlergias);
                                    System.out.println("Quantas alergias o paciente tem?");
                                    int qntdAlergias = leitura.nextInt();
                                    if(qntdAlergias > 0){
                                        System.out.println("Insira cada uma das alergias:");
                                        for(int x = 0; x <= qntdCirurgias; x++){
                                            String alergia = leitura.nextLine();
                                            listaAlergias.add(alergia);
                                        }
                                    medicoLogado.cadastrarInformacoesPaciente(pacienteBuscadoPorMedico, fuma, bebe, colesterol, diabete, doencaCardiaca, listaCirurgias, listaAlergias);
                                    System.out.println("Informacoes adicionais cadastradas com sucesso.");
                                    Voltar = "voltar";
                                    break;
                                    }
                                case 2:
                                    Voltar = "";
                                    System.out.println();
                                    leitura.nextLine();
                                    int opcao221;
                                    do{
                                    System.out.println("O que deseja atualizar? ");
                                    System.out.println("1. Fuma \n2. Bebe\n3. Colesterol\n4. Diabate \n5. Doenca Cardiaca\n6. Cirurgias\n7. Alergias\n8. Voltar ");
                                    opcao221 = leitura.nextInt();
                                    switch(opcao221){
                                        case 1:
                                            System.out.println("Insira a atualizacao: ");
                                            fuma = leitura.nextBoolean();
                                            pacienteBuscadoPorMedico.setFuma(fuma);
                                            System.out.println("Atualizado com sucesso.");
                                            Voltar = "voltar";
                                            break;
                                        case 2:
                                            System.out.println("Insira a atualizacao: ");
                                            bebe = leitura.nextBoolean();
                                            pacienteBuscadoPorMedico.setBebe(bebe);
                                            System.out.println("Atualizado com sucesso.");
                                            Voltar = "voltar";
                                            break;
                                        case 3:
                                            System.out.println("Insira a atualizacao: ");
                                            colesterol = leitura.nextBoolean();
                                            pacienteBuscadoPorMedico.setColesterolAlto(colesterol);
                                            System.out.println("Atualizado com sucesso.");
                                            Voltar = "voltar";
                                            break;
                                        case 4:
                                            System.out.println("Insira a atualizacao: ");
                                            diabete = leitura.nextBoolean();
                                            pacienteBuscadoPorMedico.setDiabete(diabete);
                                            System.out.println("Atualizado com sucesso.");
                                            Voltar = "voltar";
                                            break;
                                        case 5:
                                            System.out.println("Insira a atualizacao: ");
                                            doencaCardiaca = leitura.nextBoolean();
                                            pacienteBuscadoPorMedico.setDoencaCardiaca(doencaCardiaca);
                                            System.out.println("Ataulizado com sucesso.");
                                            Voltar = "voltar";
                                            break;
                                        case 6:
                                            System.out.println("O que você deseja? ");
                                            System.out.println("1. Adicionar \n2. Remover");
                                            int opcaoAtualizacao = leitura.nextInt();
                                            if(opcaoAtualizacao == 1){
                                                System.out.println("Qual cirurgia voce deseja adicionar?");
                                                String cirurgiaAdicionada = leitura.nextLine();
                                                medicoLogado.adicionarCirurgia(cirurgiaAdicionada, pacienteBuscadoPorMedico);
                                                System.out.println("Cirurgia adicionada com sucesso");
                                            } if(opcaoAtualizacao == 2) {
                                                System.out.println("Qual cirurgia voce deseja remover?");
                                                for(int x = 0; x < pacienteBuscadoPorMedico.getCirurgias().size(); x++){
                                                    System.out.println(pacienteBuscadoPorMedico.getCirurgias().get(x));
                                                }
                                                System.out.println();
                                                leitura.nextLine();
                                                String cirurgiaRemovida = leitura.nextLine();
                                                medicoLogado.removerCirurgia(cirurgiaRemovida, pacienteBuscadoPorMedico);
                                                System.out.println("Cirurgia removida com sucesso");
                                            }
                                            Voltar = "voltar";
                                            break;
                                        case 7:
                                            System.out.println("O que você deseja? ");
                                            System.out.println("1. Adicionar \n2. Remover");
                                            opcaoAtualizacao = leitura.nextInt();
                                            if(opcaoAtualizacao == 1){
                                                System.out.println("Qual alergia voce deseja adicionar?");
                                                String alergiaAdicionada = leitura.nextLine();
                                                medicoLogado.adicionarCirurgia(alergiaAdicionada, pacienteBuscadoPorMedico);
                                                System.out.println("Alergia adicionada com sucesso");
                                            } if(opcaoAtualizacao == 2) {
                                                System.out.println("Qual alergia voce deseja remover?");
                                                for(int x = 0; x < pacienteBuscadoPorMedico.getCirurgias().size(); x++){
                                                    System.out.println(pacienteBuscadoPorMedico.getCirurgias().get(x));
                                                }
                                                System.out.println();
                                                leitura.nextLine();
                                                String alergiaRemovida = leitura.nextLine();
                                                medicoLogado.removerAlergia(alergiaRemovida, pacienteBuscadoPorMedico);
                                                System.out.println("Alergia removida com sucesso");
                                            }
                                            break;
                                    }
                                    Voltar = "voltar";
                                    } while(opcao221 != 8 || Voltar.equals(""));
                                    break;
                            }
                            Voltar = "voltar";
                            } while(opcao220 != 3 || Voltar.equals(""));
                            }
                            break;
                        case 2:
                            Voltar = "";
                            System.out.println();
                            leitura.nextLine();
                            int opcao200;
                            System.out.println("Insira o CPF do paciente de que deseja alterar o prontuario:");
                            String cpfPacienteProntuario = leitura.nextLine();
                            Paciente pacienteProntuario = medicoLogado.buscarPaciente(cpfPacienteProntuario);
                            if(pacienteProntuario == null){
                                System.out.println("Paciente nao encontrado");
                                Voltar = "voltar";
                                break;
                            } else {
                            do{
                            System.out.println("O que deseja fazer?");
                            System.out.println("1. Cadastrar Prontuario \n2. Atualizar Prontuario\n3. Remover Prontuario");
                            opcao200 = leitura.nextInt();
                            switch(opcao200){
                                case 1:
                                    System.out.println();
                                    leitura.nextLine();
                                    System.out.println("Quais são os sintomas?");
                                    String sintomas = leitura.nextLine();
                                    System.out.println("Qual o diagnostico?");
                                    String diagnosticos = leitura.nextLine();
                                    System.out.println("Qual o tratamento");
                                    String tratamento = leitura.nextLine();
                                    medicoLogado.cadastrarProntuario(pacienteProntuario, sintomas, diagnosticos, tratamento);
                                    System.out.println("Prontuario cadastrado com sucesso.");
                                    break;
                                case 2:
                                    System.out.println();
                                    leitura.nextLine();
                                    int opcaoProntuario;
                                    do{
                                    System.out.println("O que deseja atualizar?");
                                    System.out.println("1. Sintomas\n2. Diagnostico\n3.Tratamento\n4. Voltar");
                                    opcaoProntuario = leitura.nextInt();
                                    if(opcaoProntuario == 1){
                                        System.out.println("Insira os sintomas: ");
                                        String novosSintomas = leitura.nextLine();
                                        medicoLogado.atualizarSintomasProntuario(pacienteProntuario, novosSintomas);
                                        System.out.println("Sintomas atualizados com sucesso.");
                                    } if(opcaoProntuario == 2){
                                        System.out.println("Insira o novo diagnostico: ");
                                        String diagnostico = leitura.nextLine();
                                        medicoLogado.atualizarDiagnosticoProntuario(pacienteProntuario, diagnostico);
                                        System.out.println("Diagnostico atualizado com sucesso.");
                                    } if(opcaoProntuario == 3){
                                        System.out.println("Insira o novo tratamento: ");
                                        String novoTratamento = leitura.nextLine();
                                        medicoLogado.atualizarTratamentoProntuario(pacienteProntuario, novoTratamento);
                                        System.out.println("Tratamento atualizado com sucesso.");
                                    }
                                    Voltar = "voltar";
                                    break;
                                    }while(opcaoProntuario != 4 || Voltar.equals(""));
                                case 3:
                                    System.out.println();
                                    leitura.nextLine();
                                    System.out.println("Deseja remover o prontuario do paciente " + pacienteProntuario.getNome() + "?\n"
                                            + "1. Sim\n2. Nao");
                                    int confirmacao;
                                    confirmacao = leitura.nextInt();
                                    if(confirmacao == 1){
                                        medicoLogado.removerProntuario(pacienteProntuario);
                                        System.out.println("Prontuario removido.");
                                    }
                                    Voltar = "voltar";
                                    break;
                            }
                            } while(opcao200 !=4 || Voltar.equals(""));
                            }
                        case 3:
                            Voltar = "";
                            System.out.println();
                            leitura.nextLine();
                            System.out.println("Insira o CPF do paciente desejado: ");
                            cpfPaciente = leitura.nextLine();
                            pacienteProntuario = medicoLogado.buscarPaciente(cpfPaciente);
                            if(pacienteProntuario == null){
                                System.out.println("Paciente não encontrado.");
                                Voltar = "voltar";
                                break;
                            } else {
                                if(pacienteProntuario.getProntuario() == null){
                                    System.out.println("O paciente não possui um prontuário ainda.");
                                } else {
                                System.out.println("----Relatorio Gerado----");
                                medicoLogado.gerarRelatorioMedico(pacienteProntuario);
                                }
                            }
                            Voltar = "";
                            break;
                    }
                    }
                    } while(opcao211 != 4 || Voltar.equals(""));
                    break;    
                case 3:
                    Voltar = "";
                    System.out.println();
                    leitura.nextLine();
                    System.out.println("Deseja enviar as mensagens para os pacientes de amanhã?\n1. Sim\n2. Nao");
                    int confirmacao = leitura.nextInt();
                    if(confirmacao == 1){
                        gerenciador.enviarMensagens(dataDeAmanha);
                        System.out.println("Mensagens enviadas com sucesso.");
                    }
                    Voltar = "voltar";
                    break;
                
                }
                } while (opcao1 != 4 || Voltar.equals("")); 

            }
        }
    }

