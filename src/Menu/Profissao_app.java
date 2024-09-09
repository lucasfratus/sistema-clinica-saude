package Menu;

import EmpregadosClinica.Medico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Profissao_app {

    // Estruturas para armazenar pacientes e consultas
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private static HashMap<String, Consulta> listaConsultas = new HashMap<>();

    public static void main(String[] args) {
        // Criação do frame principal
        JFrame inicioFrame = new JFrame("Seleção de Profissão");
        inicioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicioFrame.setSize(300, 200);
        inicioFrame.setLayout(new FlowLayout());
        inicioFrame.getContentPane().setBackground(Color.decode("#ececec"));

        // Criação do combo box para seleção de profissões
        String[] profissoes = {"Selecione", "Médico", "Secretária", "Gerenciador de Mensagens"};
        JComboBox<String> profissaoComboBox = new JComboBox<>(profissoes);
        JButton okButton = new JButton("OK");

        // Adiciona componentes ao frame
        inicioFrame.add(new JLabel("Selecione uma profissão:"));
        inicioFrame.add(profissaoComboBox);
        inicioFrame.add(okButton);

        // Adiciona o listener ao botão OK
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String profissaoSelecionada = (String) profissaoComboBox.getSelectedItem();
                if (!"Selecione".equals(profissaoSelecionada)) {
                    abrirPaginaProfissao(profissaoSelecionada, inicioFrame);
                } else {
                    JOptionPane.showMessageDialog(inicioFrame, "Por favor, selecione uma profissão.");
                }
            }
        });

        centralizarFrame(inicioFrame);
    }
        // Função para criar e configurar um JFrame com cor e botão Voltar
    private static JFrame criarFrame(String nome, String corHex, JFrame frameAnterior) {
        JFrame frame = new JFrame(nome);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Color cor = Color.decode(corHex);
        frame.getContentPane().setBackground(cor);
        frame.setLayout(new BorderLayout());
        
        // Adiciona o botão Voltar na parte inferior (sul)
        JPanel painelSul = new JPanel();
        adicionarBotaoVoltar(frame, frameAnterior, painelSul);
        frame.add(painelSul, BorderLayout.SOUTH);

        centralizarFrame(frame);
        frameAnterior.setVisible(false); // Oculta o frame anterior

        return frame;
    }
    
    private static void abrirPaginaProfissao(String profissao, JFrame frameAnterior) {
        JFrame profissaoFrame = new JFrame("Seleção de Profissão");
        profissaoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profissaoFrame.setSize(400, 300);
        profissaoFrame.setLayout(new FlowLayout());
        profissaoFrame.getContentPane().setBackground(Color.decode("#c7e0fc"));
        profissaoFrame.setVisible(true);
        centralizarFrame(profissaoFrame);
        JPanel painel = new JPanel();
        painel.setBackground(Color.decode("#c7e0fc"));
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); 
        GridLayout layout = new GridLayout(4,1);
        painel.setLayout(new GridLayout(4,1));
        layout.setVgap(100);
        switch (profissao) {
            case "Médico" -> {
                JButton gerenciarPacientesBotao = criarBotao("Gerenciar Pacientes", profissaoFrame);
                painel.add(gerenciarPacientesBotao);
                gerenciarPacientesBotao.addActionListener(e -> abrirGerenciarPacientes(profissaoFrame));
                
                JButton gerenciarProntuariosBotao = criarBotao("Gerenciar Prontuarios", profissaoFrame);
                painel.add(gerenciarProntuariosBotao);
                gerenciarProntuariosBotao.addActionListener(e -> abrirGerenciarProntuarios(profissaoFrame));
                
                JButton gerarRelatorioBotao = criarBotao("Gerar relatórios médicos", profissaoFrame);
                painel.add(gerarRelatorioBotao);
                gerarRelatorioBotao.addActionListener(e -> abrirGerarRelatorioMedico(profissaoFrame));
            }
            case "Secretária" -> {
                JButton gerenciarPacientesBotao = criarBotao("Gerenciar Pacientes", profissaoFrame);
                painel.add(gerenciarPacientesBotao);
                gerenciarPacientesBotao.addActionListener(e -> abrirGerenciarPacientesSecretaria(profissaoFrame));
                
                JButton gerenciarConsultasBotao = criarBotao("Gerenciar Consultas", profissaoFrame);
                painel.add(gerenciarConsultasBotao);
                gerenciarConsultasBotao.addActionListener(e -> abrirGerenciarConsultas(profissaoFrame));
                
                JButton gerarRelatorioBotao = criarBotao("Gerar Relatório", profissaoFrame);
                painel.add(gerarRelatorioBotao);
                gerarRelatorioBotao.addActionListener(e -> gerarRelatorioConsultas(profissaoFrame));
            }
            case "Gerenciador de Mensagens" -> {
                JButton enviarBotao = criarBotao("<html>Enviar mensagens para <br> os pacientes de amanhã", profissaoFrame);
                painel.add(enviarBotao);
                
                enviarBotao.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(painel, "Mensagem enviada com sucesso!");
                }
            }
        );
                GridLayout layoutMsg = new GridLayout(3,1); //organizar em grid para nao empurrar o botao para fora da tela
                painel.setLayout(new GridLayout(3,1));
                String[] pacientesAmanha = {"Lista dos pacientes de amanhã","mad","nargenio","EJL"};
                JComboBox<String> boxPacientesAmanha = new JComboBox<>(pacientesAmanha);

                boxPacientesAmanha.addItemListener(new ItemListener() {
                    @Override
                        public void itemStateChanged(ItemEvent e) {
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                boxPacientesAmanha.setSelectedIndex(0);
                        }
                    }
                });
                painel.add(boxPacientesAmanha);

            }
        }
        
        adicionarBotaoVoltar(profissaoFrame, frameAnterior, painel);
        profissaoFrame.add(painel, BorderLayout.CENTER);
  
}
    private static void abrirGerenciarPacientes(JFrame frameAnterior) {
        JFrame gerenciarPacienteFrame = criarFrame("Gerenciar Pacientes", "#c7e0fc", frameAnterior);

        gerenciarPacienteFrame.setLayout(null); // Define layout como null para uso de setBounds
        
        JLabel labelPacientes = new JLabel("Escreva o CPF do paciente (somente números): ");
        labelPacientes.setBounds(260, 200, 320, 30);
        gerenciarPacienteFrame.add(labelPacientes);

        JTextField fieldPaciente = new JTextField();
        fieldPaciente.setBounds(250, 240, 300, 30);
        gerenciarPacienteFrame.add(fieldPaciente);

        JButton okButton = new JButton("OK");
        okButton.setBounds(350, 300, 80, 30);
        gerenciarPacienteFrame.add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = fieldPaciente.getText();
                try {
                    int cpfInt = Integer.parseInt(cpf);
                    abrirAtualizarDados(gerenciarPacienteFrame); // Abre a tela de atualizar dados
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(gerenciarPacienteFrame, "Por favor, insira um número inteiro válido.");
                }
            }
        });
    }    
    
    private static void abrirGerenciarProntuarios(JFrame frameAnterior) {
        JFrame gerenciarProntuariosFrame = criarFrame("Gerenciar Prontuários", "#c7e0fc", frameAnterior);

        gerenciarProntuariosFrame.setLayout(null);

        JLabel labelPacientes = new JLabel("Escreva o CPF do paciente (somente números): ");
        labelPacientes.setBounds(260, 200, 320, 30);
        gerenciarProntuariosFrame.add(labelPacientes);

        JTextField fieldPaciente = new JTextField();
        fieldPaciente.setBounds(250, 240, 300, 30);
        gerenciarProntuariosFrame.add(fieldPaciente);

        JButton okButton = new JButton("OK");
        okButton.setBounds(350, 300, 80, 30); 
        okButton.setBounds(350, 300, 80, 30);
        gerenciarProntuariosFrame.add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = fieldPaciente.getText();
                try {
                    int cpfInt = Integer.parseInt(cpf);
                    abrirCadastrarAttDados(gerenciarProntuariosFrame); // Abre a tela de atualizar dados
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(gerenciarProntuariosFrame, "Por favor, insira um número inteiro válido.");
                }
            }
        });
    }
    
    private static void abrirCadastrarAttDados(JFrame frameAnterior){
        JFrame cadastrarAttDados = criarFrame("Cadastrar e Atualizar dados","#c7e0fc", frameAnterior);
        cadastrarAttDados.setLayout(null);
        //cria e adiciona labels
        JLabel titulo = new JLabel("<html><font size='4'>Cadastre e atualize informações do paciente: ");
        cadastrarAttDados.add(titulo);
        titulo.setBounds(230, 20, 400, 30);//(x,y,w,h)
        
        JLabel lblSintomas = new JLabel("Digite os sintomas");
        JLabel lblDiagnostico = new JLabel("Digite o diagnóstico");
        JLabel lblTratamento  = new JLabel("Digite o tratamento");
        JTextField fieldSintomas = new JTextField();
        JTextField fieldDiagnostico = new JTextField();
        JTextField fieldTratamento = new JTextField();
        
        cadastrarAttDados.add(lblSintomas);
        cadastrarAttDados.add(lblDiagnostico);
        cadastrarAttDados.add(lblTratamento);
        
        lblSintomas.setBounds(60, 90, 400, 40);//(x,y,w,h)
        lblDiagnostico.setBounds(60, 160, 400, 40);
        lblTratamento.setBounds(60, 230, 400, 40);
        
        fieldSintomas.setBounds(180, 90, 180, 40);
        fieldDiagnostico.setBounds(180, 160, 180, 40);
        fieldTratamento.setBounds(180, 230, 180, 40);
        
        cadastrarAttDados.add(fieldSintomas);
        cadastrarAttDados.add(fieldDiagnostico);
        cadastrarAttDados.add(fieldTratamento);
        
        JLabel lblNota = new JLabel("<html><font size='4'>Verifique se as informações<br>" //<br> é a quebra de linha. 
                + "estão corretas antes<br>de confirmar sua ação!</html>"); //Por algum motivo o jlabel sozinho não quebra linha
        lblNota.setBounds(500, 115, 200, 125);
        cadastrarAttDados.add(lblNota);
        
        JButton okButton = new JButton("OK");
        cadastrarAttDados.add(okButton);
        okButton.setBounds(345, 300, 100, 30);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificando se os campos estão vazios
                if (fieldSintomas.getText().isEmpty() || fieldDiagnostico.getText().isEmpty()||fieldTratamento.getText().isEmpty()) {
                    // Exibindo pop-up de erro (ícone X vermelho)
                    JOptionPane.showMessageDialog(cadastrarAttDados, 
                        "Por favor, informe todos os campos", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);

                } else {
                    // Exibindo pop-up de sucesso (ícone de confirmação)
                    JOptionPane.showMessageDialog(cadastrarAttDados, 
                        "Dados do paciente atualizados", 
                        "Sucesso", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    
    private static void abrirAtualizarDados(JFrame frameAnterior) {
        JFrame attDadosFrame = criarFrame("Atualizar Dados", "#c7e0fc", frameAnterior);
        attDadosFrame.setLayout(null);
        JLabel labelAtt = new JLabel("Escreva o CPF do paciente (somente números): ");
        labelAtt.setBounds(260, 200, 320, 30);
        attDadosFrame.add(labelAtt);

        JTextField fieldAtt = new JTextField();
        fieldAtt.setBounds(250, 240, 300, 30);
        attDadosFrame.add(fieldAtt);

        JButton okButton = new JButton("OK");
        okButton.setBounds(350, 300, 80, 30);
        attDadosFrame.add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = fieldAtt.getText();
                try {
                    int cpfInt = Integer.parseInt(cpf);
                    abrirMarcaDados(attDadosFrame);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(attDadosFrame, "Por favor, insira um número inteiro válido.");
                }
            }
        });
    }
    
    private static void abrirMarcaDados(JFrame frameAnterior){
        JFrame marcaDadosFrame = criarFrame("Marcar Dados", "#c7e0fc", frameAnterior);
        marcaDadosFrame.setLayout(null);
        
        //Bool fuma, bebe, diabetes, colesterol alto, doença cardíaca; int cirurgias, alergias; String cirurgias, alergias
        JLabel labelTitulo = new JLabel ("Marque as condições que o paciente possui:");
        labelTitulo.setBounds(260, 10, 450 ,30);
        marcaDadosFrame.add(labelTitulo);
                
        JLabel labelFuma = new JLabel ("Fuma:");
        labelFuma.setBounds(200, 50, 150 ,30);
        marcaDadosFrame.add(labelFuma);
        JCheckBox boxFuma = new JCheckBox();
        boxFuma.setBounds(330, 50, 20, 20);
        marcaDadosFrame.add(boxFuma);
        
        JLabel labelBebe = new JLabel ("Bebe:");
        labelBebe.setBounds(200, 90, 150 ,30);
        marcaDadosFrame.add(labelBebe);
        JCheckBox boxBebe = new JCheckBox();
        boxBebe.setBounds(330, 90, 20, 20);
        marcaDadosFrame.add(boxBebe);
        
        JLabel labelDiabetes = new JLabel ("Diabetes:");
        labelDiabetes.setBounds(200, 130, 150 ,30);
        marcaDadosFrame.add(labelDiabetes);
        JCheckBox boxDiabetes = new JCheckBox();
        boxDiabetes.setBounds(330, 130, 20, 20);
        marcaDadosFrame.add(boxDiabetes);
        
        JLabel labelColesterolAlto = new JLabel ("Colesterol Alto:");
        labelColesterolAlto.setBounds(200, 170, 150 ,30);
        marcaDadosFrame.add(labelColesterolAlto);
        JCheckBox boxColesterolAlto = new JCheckBox();
        boxColesterolAlto.setBounds(330, 170, 20, 20);
        marcaDadosFrame.add(boxColesterolAlto);
        
        JLabel labelDoencaCardiaca = new JLabel ("Doença Cardíaca:");
        labelDoencaCardiaca.setBounds(200, 210, 150 ,30);
        marcaDadosFrame.add(labelDoencaCardiaca);
        JCheckBox boxDoencaCardiaca = new JCheckBox();
        boxDoencaCardiaca.setBounds(330, 210, 20, 20);
        marcaDadosFrame.add(boxDoencaCardiaca);
        
        JLabel labelCirurgia = new JLabel ("Cirurgias:");
        labelCirurgia.setBounds(200, 250, 150 ,30);
        marcaDadosFrame.add(labelCirurgia);
        
        JLabel labelAlergia = new JLabel ("Alergias:");
        labelAlergia.setBounds(200, 290, 150 ,30);
        marcaDadosFrame.add(labelAlergia);
        
        JTextField textCirurgia = new JTextField ();
        textCirurgia.setBounds(280, 250, 150 ,30);
        marcaDadosFrame.add(textCirurgia);
        
        JTextField textAlergia = new JTextField ();
        textAlergia.setBounds(280, 290, 150 ,30);
        marcaDadosFrame.add(textAlergia);
        
        JButton okButton = new JButton("OK");
        okButton.setBounds(350, 400, 80, 30);
        marcaDadosFrame.add(okButton);
        
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(marcaDadosFrame, "Laudos foram atualizados com sucesso!");
                }
            }
        );
    }
    
    private static void abrirGerarRelatorioMedico(JFrame frameAnterior) {
        JFrame relatorioFrame = criarFrame("Gerar Relatório Médico", "#c7e0fc", frameAnterior);

        relatorioFrame.setLayout(null); // Define layout como null para uso de setBounds

        JLabel labelPaciente = new JLabel("CPF do paciente:");
        labelPaciente.setBounds(220, 30, 150, 30);
        relatorioFrame.add(labelPaciente);

        JTextField fieldCpf = new JTextField();
        fieldCpf.setBounds(350, 30, 150, 30);
        relatorioFrame.add(fieldCpf);

        JLabel labelNome = new JLabel("Nome do paciente:");
        labelNome.setBounds(220, 70, 150, 30);
        relatorioFrame.add(labelNome);

        JTextField fieldNome = new JTextField();
        fieldNome.setBounds(350, 70, 150, 30);
        relatorioFrame.add(fieldNome);

        JLabel labelData = new JLabel("<html> Data de hoje <br>(dd/mm/aaaa):");
        labelData.setBounds(220, 110, 200, 30);
        relatorioFrame.add(labelData);

        JTextField fieldData = new JTextField();
        fieldData.setBounds(350, 110, 150, 30);
        relatorioFrame.add(fieldData);

        JLabel labelReceita = new JLabel("Receita médica:");
        labelReceita.setBounds(220, 150, 150, 30);
        relatorioFrame.add(labelReceita);

        JTextArea areaReceita = new JTextArea();
        areaReceita.setBounds(350, 150, 150, 60);
        areaReceita.setLineWrap(true);
        areaReceita.setWrapStyleWord(true);
        relatorioFrame.add(areaReceita);

        JLabel labelAtestado = new JLabel("Atestado: (*Documento em pdf*)");
        labelAtestado.setBounds(220, 220, 300, 30);
        relatorioFrame.add(labelAtestado);

        JLabel labelDeclaracao = new JLabel("Declaração de acompanhamento: (*Documento em pdf*)");
        labelDeclaracao.setBounds(220, 250, 350, 30);
        relatorioFrame.add(labelDeclaracao);

        JButton gerarRelatorioButton = new JButton("Gerar Relatório");
        gerarRelatorioButton.setBounds(290, 300, 200, 30);
        relatorioFrame.add(gerarRelatorioButton);
        
        

        gerarRelatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = fieldCpf.getText();
                String nome = fieldNome.getText();
                String data = fieldData.getText();
                String receita = areaReceita.getText();

                if (cpf.isEmpty() || nome.isEmpty() || data.isEmpty() || receita.isEmpty()) {
                    JOptionPane.showMessageDialog(relatorioFrame, "Por favor, preencha todos os campos.");
                } else {
                    StringBuilder relatorio = new StringBuilder();
                    relatorio.append("Nome do paciente: ").append(nome).append("\n");
                    relatorio.append("CPF do paciente: ").append(cpf).append("\n");
                    relatorio.append("Data: ").append(data).append("\n");
                    relatorio.append("Receita: ").append(receita).append("\n");
                    relatorio.append("Atestado: (*Documento em pdf*)").append("\n");
                    relatorio.append("Declaração de acompanhamento: (*Documento em pdf*)").append("\n");

                    JOptionPane.showMessageDialog(relatorioFrame, relatorio.toString());
                    JOptionPane.showMessageDialog(relatorioFrame, "Relatório gerado com sucesso!");

                    // Fechar o frame após gerar o relatório, se necessário
                    relatorioFrame.dispose();
                    frameAnterior.setVisible(true);
                }
            }
        });
    }
    
    private static void abrirGerenciarPacientesSecretaria(JFrame frameAnterior) {

        // Criação do frame utilizando a função criarFrame
        JFrame framePacientes = criarFrame("Gerenciar Pacientes", "#c7e0fc", frameAnterior);

        // Define um painel principal com BoxLayout para alinhar os componentes verticalmente
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBackground(Color.decode("#c7e0fc"));

        // Espaçamento entre os componentes
        painelPrincipal.add(Box.createVerticalStrut(20));

        // Cadastrar Paciente Button
        JButton cadastrarButton = criarBotao("Cadastrar Paciente", framePacientes);
        cadastrarButton.setPreferredSize(new Dimension(200, 50));
        cadastrarButton.setMaximumSize(cadastrarButton.getPreferredSize());
        cadastrarButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        cadastrarButton.addActionListener(e -> cadastrarPaciente(framePacientes));
        painelPrincipal.add(cadastrarButton);

        // Espaçamento entre os botões
        painelPrincipal.add(Box.createVerticalStrut(20));

        // Remover Paciente Button
        JButton removerButton = criarBotao("Remover Paciente", framePacientes);
        removerButton.setPreferredSize(new Dimension(200, 50));
        removerButton.setMaximumSize(removerButton.getPreferredSize());
        removerButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        removerButton.addActionListener(e -> removerPaciente(framePacientes));
        painelPrincipal.add(removerButton);

        // Espaçamento entre os botões
        painelPrincipal.add(Box.createVerticalStrut(20));

        // Atualizar Paciente Button
        JButton atualizarButton = criarBotao("Atualizar Paciente", framePacientes);
        atualizarButton.setPreferredSize(new Dimension(200, 50));
        atualizarButton.setMaximumSize(atualizarButton.getPreferredSize());
        atualizarButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        atualizarButton.addActionListener(e -> atualizarPaciente(framePacientes));
        painelPrincipal.add(atualizarButton);

        // Espaçamento entre o último botão e o botão Voltar
        painelPrincipal.add(Box.createVerticalStrut(20));

        // Painel inferior para o botão Voltar
        JPanel painelInferior = new JPanel();
        painelInferior.setBackground(Color.decode("#c7e0fc"));

        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS));
        painelInferior.add(Box.createVerticalStrut(20));
        painelPrincipal.add(painelInferior);

        // Adiciona o painel principal ao frame
        framePacientes.add(painelPrincipal);
        framePacientes.setVisible(true);
    }

    private static void abrirGerenciarConsultas(JFrame frameAnterior) {
        // Criação do frame e painel principal
        JFrame frame = criarFrame("Gerenciar Consultas", "#c7e0fc", frameAnterior);
        JPanel painel = new JPanel();
        painel.setBackground(Color.decode("#c7e0fc"));
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));  // Alinha os componentes verticalmente

        // Espaçamento entre os componentes
        painel.add(Box.createVerticalStrut(20));

        // Botão "Marcar Consulta"
        JButton marcarButton = criarBotao("Marcar Consulta", frame);
        marcarButton.setPreferredSize(new Dimension(200, 50));
        marcarButton.setMaximumSize(marcarButton.getPreferredSize());
        marcarButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        marcarButton.addActionListener(e -> marcarConsulta(frame));
        painel.add(marcarButton);

        // Espaçamento entre os botões
        painel.add(Box.createVerticalStrut(20));

        // Botão "Desmarcar Consulta"
        JButton desmarcarButton = criarBotao("Desmarcar Consulta", frame);
        desmarcarButton.setPreferredSize(new Dimension(200, 50));
        desmarcarButton.setMaximumSize(desmarcarButton.getPreferredSize());
        desmarcarButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        desmarcarButton.addActionListener(e -> desmarcarConsulta(frame));
        painel.add(desmarcarButton);

        // Espaçamento entre os botões
        painel.add(Box.createVerticalStrut(20));

        // Botão "Atualizar Consulta"
        JButton atualizarButton = criarBotao("Atualizar Consulta", frame);
        atualizarButton.setPreferredSize(new Dimension(200, 50));
        atualizarButton.setMaximumSize(atualizarButton.getPreferredSize());
        atualizarButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        atualizarButton.addActionListener(e -> atualizarConsulta(frame));
        painel.add(atualizarButton);

        // Espaçamento após o último botão
        painel.add(Box.createVerticalStrut(20));

        // Adiciona o painel ao frame e exibe a janela
        frame.add(painel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void gerarRelatorioConsultas(JFrame frameAnterior) {
        StringBuilder relatorio = new StringBuilder("Consultas Registradas:\n");
        for (Consulta consulta : listaConsultas.values()) {
            relatorio.append(consulta).append("\n");
        }
        JOptionPane.showMessageDialog(frameAnterior, relatorio.toString());
    }
    
    // Funções para cadastrar, remover e atualizar pacientes
    private static void cadastrarPaciente(JFrame frame) {
        String nome = JOptionPane.showInputDialog(frame, "Insira o Nome do Paciente:");
        String cpf = JOptionPane.showInputDialog(frame, "Insira o CPF do Paciente (somente números):");
        String email = JOptionPane.showInputDialog(frame, "Insira o Email do Paciente (ou 'NaoInformado'):");
        String dataNascimento = JOptionPane.showInputDialog(frame, "Insira a Data de Nascimento:");
        String endereco = JOptionPane.showInputDialog(frame, "Insira o Endereço do Paciente:");
        String telefone = JOptionPane.showInputDialog(frame, "Insira o Telefone do Paciente (ou 'NaoInformado'):");
        String convenio = JOptionPane.showInputDialog(frame, "Insira o Convênio:");

        listaPacientes.add(new Paciente(nome, cpf, email, dataNascimento, endereco, telefone, convenio));
        JOptionPane.showMessageDialog(frame, "Paciente " + nome + " cadastrado com sucesso.");
    }

    private static void removerPaciente(JFrame frame) {
        String cpf = JOptionPane.showInputDialog(frame, "Insira o CPF do Paciente que deseja remover (somente números):");
        Paciente paciente = buscarPaciente(cpf);
        if (paciente != null) {
            listaPacientes.remove(paciente);
            JOptionPane.showMessageDialog(frame, "Paciente " + paciente.getNome() + " removido.");
        } else {
            JOptionPane.showMessageDialog(frame, "Paciente não encontrado.");
        }
    }

    private static void atualizarPaciente(JFrame frame) {
        String cpf = JOptionPane.showInputDialog(frame, "Insira o CPF do Paciente que deseja atualizar:");
        Paciente paciente = buscarPaciente(cpf);
        if (paciente != null) {
            String opcao = JOptionPane.showInputDialog(frame, "O que você deseja atualizar? (Nome, CPF, Data de Nascimento, Endereço, Telefone, Email, Convênio):").toLowerCase();
            switch (opcao) {
                case "nome":
                    String novoNome = JOptionPane.showInputDialog(frame, "Digite o novo nome:");
                    paciente.setNome(novoNome);
                    break;
                case "cpf":
                    String novoCpf = JOptionPane.showInputDialog(frame, "Digite o novo CPF:");
                    paciente.setCpf(novoCpf);
                    break;
                case "data de nascimento":
                    String novaDataNascimento = JOptionPane.showInputDialog(frame, "Digite a nova data de nascimento:");
                    paciente.setDataNascimento(novaDataNascimento);
                    break;
                case "endereço":
                    String novoEndereco = JOptionPane.showInputDialog(frame, "Digite o novo endereço:");
                    paciente.setEndereco(novoEndereco);
                    break;
                case "telefone":
                    String novoTelefone = JOptionPane.showInputDialog(frame, "Digite o novo telefone:");
                    paciente.setTelefone(novoTelefone);
                    break;
                case "email":
                    String novoEmail = JOptionPane.showInputDialog(frame, "Digite o novo email:");
                    paciente.setEmail(novoEmail);
                    break;
                case "convênio":
                    String novoConvenio = JOptionPane.showInputDialog(frame, "Digite o novo convênio:");
                    paciente.setConvenio(novoConvenio);
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Opção inválida.");
                    return;
            }
            JOptionPane.showMessageDialog(frame, "Paciente atualizado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(frame, "Paciente não encontrado.");
        }
    }

    private static Paciente buscarPaciente(String cpf) {
        for (Paciente p : listaPacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    // Funções para marcar, desmarcar e atualizar consultas
    private static void marcarConsulta(JFrame frame) {
        String pacienteCpf = JOptionPane.showInputDialog(frame, "Insira o CPF do Paciente:");
        Paciente paciente = buscarPaciente(pacienteCpf);
        if (paciente == null) {
            JOptionPane.showMessageDialog(frame, "Paciente não encontrado.");
            return;
        }
        String data = JOptionPane.showInputDialog(frame, "Insira a data da consulta (dd/MM/yyyy):");
        String horario = JOptionPane.showInputDialog(frame, "Insira o horário da consulta (HH:mm):");
        String descricao = JOptionPane.showInputDialog(frame, "Insira a descrição da consulta:");

        String consultaId = data + " " + horario; // ID único baseado em data e horário
        listaConsultas.put(consultaId, new Consulta(paciente, data, horario, descricao));
        JOptionPane.showMessageDialog(frame, "Consulta marcada com sucesso.");
    }

    private static void desmarcarConsulta(JFrame frame) {
        String consultaId = JOptionPane.showInputDialog(frame, "Insira a data e horário da consulta (dd/MM/yyyy HH:mm):");
        if (listaConsultas.remove(consultaId) != null) {
            JOptionPane.showMessageDialog(frame, "Consulta desmarcada com sucesso.");
        } else {
            JOptionPane.showMessageDialog(frame, "Consulta não encontrada.");
        }
    }

    private static void atualizarConsulta(JFrame frame) {
        String consultaId = JOptionPane.showInputDialog(frame, "Insira a data e horário da consulta a ser atualizada (dd/MM/yyyy HH:mm):");
        Consulta consulta = listaConsultas.get(consultaId);
        if (consulta != null) {
            String novaDescricao = JOptionPane.showInputDialog(frame, "Insira a nova descrição da consulta:");
            consulta.setDescricao(novaDescricao);
            JOptionPane.showMessageDialog(frame, "Consulta atualizada com sucesso.");
        } else {
            JOptionPane.showMessageDialog(frame, "Consulta não encontrada.");
        }
    }

    private static JButton criarBotao(String texto, JFrame frame) {
        JButton botao = new JButton(texto);
        botao.setPreferredSize(new Dimension(200, 50));
        return botao;
    }

    private static void adicionarBotaoVoltar(JFrame frame, JFrame frameAnterior, JPanel painel) {
        JButton voltarButton = criarBotao("Voltar", frame);
        voltarButton.addActionListener(e -> {
            frame.dispose();
            frameAnterior.setVisible(true);
        });
        painel.add(voltarButton);
    }

    private static void centralizarFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    // Classe Paciente
    static class Paciente {
        private String nome;
        private String cpf;
        private String email;
        private String dataNascimento;
        private String endereco;
        private String telefone;
        private String convenio;

        public Paciente(String nome, String cpf, String email, String dataNascimento, String endereco, String telefone, String convenio) {
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
            this.dataNascimento = dataNascimento;
            this.endereco = endereco;
            this.telefone = telefone;
            this.convenio = convenio;
        }

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }

        public String getCpf() { return cpf; }
        public void setCpf(String cpf) { this.cpf = cpf; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getDataNascimento() { return dataNascimento; }
        public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

        public String getEndereco() { return endereco; }
        public void setEndereco(String endereco) { this.endereco = endereco; }

        public String getTelefone() { return telefone; }
        public void setTelefone(String telefone) { this.telefone = telefone; }

        public String getConvenio() { return convenio; }
        public void setConvenio(String convenio) { this.convenio = convenio; }

        @Override
        public String toString() {
            return "Paciente: " + nome + ", CPF: " + cpf + ", Email: " + email + ", Data de Nascimento: " + dataNascimento + 
                   ", Endereço: " + endereco + ", Telefone: " + telefone + ", Convênio: " + convenio;
        }
    }

    // Classe Consulta
    static class Consulta {
        private Paciente paciente;
        private String data;
        private String horario;
        private String descricao;

        public Consulta(Paciente paciente, String data, String horario, String descricao) {
            this.paciente = paciente;
            this.data = data;
            this.horario = horario;
            this.descricao = descricao;
        }

        public Paciente getPaciente() { return paciente; }
        public void setPaciente(Paciente paciente) { this.paciente = paciente; }

        public String getData() { return data; }
        public void setData(String data) { this.data = data; }

        public String getHorario() { return horario; }
        public void setHorario(String horario) { this.horario = horario; }

        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }

        @Override
        public String toString() {
            return "Consulta com " + paciente.getNome() + " em " + data + " às " + horario + ". Descrição: " + descricao;
        }
    }
}
