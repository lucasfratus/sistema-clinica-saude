package Menu;

import EmpregadosClinica.Secretaria;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class TelaSecGerenciarConsulta extends javax.swing.JFrame {
    EntityManager em;
    Secretaria secretariaLogada;

    public TelaSecGerenciarConsulta(Secretaria secretariaLogada, EntityManager em) {
        initComponents();
        this.secretariaLogada = secretariaLogada;
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

        jLabel1 = new javax.swing.JLabel();
        BotaoMarcarConsulta = new javax.swing.JButton();
        BotaoDesmarcarConsulta = new javax.swing.JButton();
        BotaoAlterarConsulta = new javax.swing.JButton();
        BotaoVoltar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Consultas");

        BotaoMarcarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotaoMarcarConsulta.setText("Marcar Consulta");
        BotaoMarcarConsulta.setActionCommand("BotaoMarcarConsulta");
        BotaoMarcarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoMarcarConsultaActionPerformed(evt);
            }
        });

        BotaoDesmarcarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotaoDesmarcarConsulta.setText("Desmarcar Consulta");
        BotaoDesmarcarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDesmarcarConsultaActionPerformed(evt);
            }
        });

        BotaoAlterarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotaoAlterarConsulta.setText("Alterar Consulta");
        BotaoAlterarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlterarConsultaActionPerformed(evt);
            }
        });

        BotaoVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotaoVoltar.setText("Voltar");
        BotaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarActionPerformed(evt);
            }
        });

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
                .addGap(247, 247, 247)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotaoDesmarcarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoMarcarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoAlterarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(BotaoMarcarConsulta)
                .addGap(33, 33, 33)
                .addComponent(BotaoDesmarcarConsulta)
                .addGap(33, 33, 33)
                .addComponent(BotaoAlterarConsulta)
                .addGap(61, 61, 61)
                .addComponent(BotaoVoltar)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void BotaoMarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoMarcarConsultaActionPerformed
        TelaSecMarcarConsulta marcarTela = new TelaSecMarcarConsulta();
        marcarTela.setVisible(true);
    }//GEN-LAST:event_BotaoMarcarConsultaActionPerformed

    private void BotaoDesmarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDesmarcarConsultaActionPerformed
        String medicoConsulta = JOptionPane.showInputDialog(null, "Insira o CRM do médico da consulta: ");
        String diaConsulta = JOptionPane.showInputDialog(null, "Insira a data da consulta:(FORMATO: dd/mm/aaaa)");
        String horaConsulta = JOptionPane.showInputDialog(null, "Insira o horário da consulta:(FORMATO: hh:mm");
        JOptionPane.showMessageDialog(null,"Consulta desmarcada com Sucesso");
    }//GEN-LAST:event_BotaoDesmarcarConsultaActionPerformed

    private void BotaoAlterarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlterarConsultaActionPerformed
        String medicoConsulta = JOptionPane.showInputDialog(null, "Insira o CRM do médico da consulta: ");
        String diaConsulta = JOptionPane.showInputDialog(null, "Insira a data da consulta:(FORMATO: dd/mm/aaaa)");
        String horaConsulta = JOptionPane.showInputDialog(null, "Insira o horário da consulta:(FORMATO: hh:mm");
        
        TelaSecAlterarConsulta telaAlterar = new TelaSecAlterarConsulta();
        telaAlterar.setVisible(true);
    }//GEN-LAST:event_BotaoAlterarConsultaActionPerformed

    private void BotaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarActionPerformed
        TelaPrincipalSecretaria TelaAnterior = new TelaPrincipalSecretaria(secretariaLogada, em);
        TelaAnterior.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_BotaoVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAlterarConsulta;
    private javax.swing.JButton BotaoDesmarcarConsulta;
    private javax.swing.JButton BotaoMarcarConsulta;
    private javax.swing.JButton BotaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
