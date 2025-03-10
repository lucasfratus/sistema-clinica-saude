package MenuMedico;

import EmpregadosClinica.Medico;
import Sistema.PacienteCadastrado;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class TelaMedGerenciarPaciente extends javax.swing.JFrame {
    private Medico medicoLogado;
    private EntityManager em;
    
    public TelaMedGerenciarPaciente(Medico medicoLogado, EntityManager em) {
        initComponents();
        this.medicoLogado = medicoLogado;
        this.em = em;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoCadastrarInfo = new javax.swing.JButton();
        BotaoAtualizarInfo = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Pacientes");

        botaoCadastrarInfo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoCadastrarInfo.setText("Cadastrar Informações adicionais");
        botaoCadastrarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarInfoActionPerformed(evt);
            }
        });

        BotaoAtualizarInfo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotaoAtualizarInfo.setText("Atualizar Informações Adicionais");
        BotaoAtualizarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtualizarInfoActionPerformed(evt);
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
        jLabel1.setText("Gerenciador de Pacientes");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoCadastrarInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoAtualizarInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addComponent(botaoCadastrarInfo)
                .addGap(51, 51, 51)
                .addComponent(BotaoAtualizarInfo)
                .addGap(50, 50, 50)
                .addComponent(botaoVoltar)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botaoCadastrarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarInfoActionPerformed
        // Cadastra as informações adicionais de um paciente
        String cpfPaciente = JOptionPane.showInputDialog(null, "Insira o CPF do paciente que deseja cadastrar informações adicionais: ");
        PacienteCadastrado pacienteAdicionais = em.find(PacienteCadastrado.class, cpfPaciente);
        if(pacienteAdicionais != null){
            TelaMedInfoAdicional telaInfoAd = new TelaMedInfoAdicional(em, medicoLogado, pacienteAdicionais);
            telaInfoAd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "CPF incorreto/Paciente não existe.", "Credenciais não encontradas", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_botaoCadastrarInfoActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        TelaPrincipalMed telaMed = new TelaPrincipalMed(medicoLogado, em);
        telaMed.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void BotaoAtualizarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizarInfoActionPerformed
        String cpfPaciente = JOptionPane.showInputDialog(null, "Insira o CPF do paciente que deseja cadastrar informações adicionais: ");
        PacienteCadastrado pacienteAdicionais = em.find(PacienteCadastrado.class, cpfPaciente);
        if(pacienteAdicionais != null){
            TelaMedInfoAdicionalAtualizar telaInfoAd = new TelaMedInfoAdicionalAtualizar(em, medicoLogado, pacienteAdicionais);
            telaInfoAd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "CPF incorreto/Paciente não existe.", "Credenciais não encontradas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotaoAtualizarInfoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAtualizarInfo;
    private javax.swing.JButton botaoCadastrarInfo;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
