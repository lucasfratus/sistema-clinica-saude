package MenuMedico;

import MenuMedico.TelaMedAtualizarProntuario;
import EmpregadosClinica.Medico;
import Fichas.Prontuario;
import Sistema.PacienteCadastrado;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class TelaMedGerenciarProntuarios extends javax.swing.JFrame {
    EntityManager em;
    Medico medicoLogado;        
   
    public TelaMedGerenciarProntuarios(Medico medicoLogado, EntityManager em) {
        initComponents();
        this.em = em;
        this.medicoLogado = medicoLogado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoCriarProntuario = new javax.swing.JButton();
        botaoRemoverProntuario = new javax.swing.JButton();
        botaoAtualizarProntuário = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Prontuários");

        botaoCriarProntuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoCriarProntuario.setText("Criar novo prontuário");
        botaoCriarProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarProntuarioActionPerformed(evt);
            }
        });

        botaoRemoverProntuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoRemoverProntuario.setText("Remover prontuário");
        botaoRemoverProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverProntuarioActionPerformed(evt);
            }
        });

        botaoAtualizarProntuário.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoAtualizarProntuário.setText("Atualizar Prontuário");
        botaoAtualizarProntuário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarProntuárioActionPerformed(evt);
            }
        });

        botaoVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Gerenciador de Prontuários");

        jMenu1.setText("Sistema");

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Sobre");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoCriarProntuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoRemoverProntuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoAtualizarProntuário, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(125, 125, 125))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(botaoCriarProntuario)
                .addGap(42, 42, 42)
                .addComponent(botaoRemoverProntuario)
                .addGap(42, 42, 42)
                .addComponent(botaoAtualizarProntuário)
                .addGap(42, 42, 42)
                .addComponent(botaoVoltar)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // Voltar para a tela principal do médico
        TelaPrincipalMed telaAnterior = new TelaPrincipalMed(medicoLogado,em);
        telaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoRemoverProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverProntuarioActionPerformed
       // Remove um prontuario de um paciente
       String cpfPaciente = JOptionPane.showInputDialog(null, "Insira o CPF do paciente:");
       Prontuario pacienteProntuario = em.find(Prontuario.class, cpfPaciente); // Busca o prontuario do paciente no banco de dados
       if(pacienteProntuario != null){
            medicoLogado.removerProntuario(cpfPaciente); // Remove o prontuario do paciente
            JOptionPane.showMessageDialog(null, "Prontuario removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O paciente não possui um prontuário cadastrado", "Prontuario não encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoRemoverProntuarioActionPerformed

    private void botaoCriarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarProntuarioActionPerformed
        // Cria um prontuario para um paciente
        String cpfPaciente = JOptionPane.showInputDialog(null, "Insira o CPF do paciente:");
        PacienteCadastrado pacienteCadastrado = em.find(PacienteCadastrado.class, cpfPaciente); // Busca o paciente no banco de dados
        Prontuario pacienteProntuario = em.find(Prontuario.class, cpfPaciente);
        if(pacienteCadastrado != null && pacienteProntuario == null){ // Se o paciente existe e não possui um prontuario
            String sintomas = JOptionPane.showInputDialog(null, "Insira os sintomas:");
            String diagnostico = JOptionPane.showInputDialog(null, "Insira o diagnóstico:");
            String tratamento = JOptionPane.showInputDialog(null, "Insira o tratamento:");
            medicoLogado.cadastrarProntuario(pacienteCadastrado, sintomas, diagnostico, tratamento); // Cadastra o prontuario do paciente
            JOptionPane.showMessageDialog(null, "Prontuario criado com sucesso!");
        } if(pacienteCadastrado == null){ // Se o paciente não existe
            JOptionPane.showMessageDialog(null, "Paciente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);    
        } if(pacienteCadastrado != null && pacienteProntuario != null) { // Se o paciente já possui um prontuario
            JOptionPane.showMessageDialog(null, "O paciente já possui um prontuário.", "Erro", JOptionPane.ERROR_MESSAGE);    
        }  
    
    }//GEN-LAST:event_botaoCriarProntuarioActionPerformed

    private void botaoAtualizarProntuárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarProntuárioActionPerformed
        // Atualiza um prontuario de um paciente
        String cpfPaciente = JOptionPane.showInputDialog(null, "Insira o CPF do paciente que deseja atualizar o prontuario:");
        Prontuario pacienteProntuario = em.find(Prontuario.class, cpfPaciente); // Busca o prontuario do paciente no banco de dados
        if(pacienteProntuario != null){ // Se o paciente possui um prontuario
            TelaMedAtualizarProntuario telaAtualizacao = new TelaMedAtualizarProntuario(medicoLogado, pacienteProntuario, em); // Abre a tela de atualização do prontuario
            telaAtualizacao.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "O paciente não possui um prontuário.", "Erro", JOptionPane.ERROR_MESSAGE);    
        }   
    
    }//GEN-LAST:event_botaoAtualizarProntuárioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizarProntuário;
    private javax.swing.JButton botaoCriarProntuario;
    private javax.swing.JButton botaoRemoverProntuario;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
