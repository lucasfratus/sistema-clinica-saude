package Menu;

import Atendimento.Paciente;
import EmpregadosClinica.Secretaria;
import Sistema.PacienteCadastrado;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class TelaPrincipalSecretaria extends javax.swing.JFrame {
    Secretaria secretariaLogada;
    EntityManager em;
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipalSecretaria(Secretaria secretariaLogada, EntityManager em) {
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

        jPanel1 = new javax.swing.JPanel();
        BotaoGerenciarPacientes = new javax.swing.JButton();
        BotaoGerenciarConsultas = new javax.swing.JButton();
        BotaoGerarRelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        BotaoGerenciarPacientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoGerenciarPacientes.setText("Gerenciar Pacientes");
        BotaoGerenciarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGerenciarPacientesActionPerformed(evt);
            }
        });

        BotaoGerenciarConsultas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoGerenciarConsultas.setText("Gerenciar Consultas");
        BotaoGerenciarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGerenciarConsultasActionPerformed(evt);
            }
        });

        BotaoGerarRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoGerarRelatorio.setText("Gerar Relatório");
        BotaoGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGerarRelatorioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bem vindo(a)!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BotaoGerarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotaoGerenciarConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(BotaoGerenciarPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(225, 225, 225))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addComponent(BotaoGerenciarPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(BotaoGerenciarConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(BotaoGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void BotaoGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGerarRelatorioActionPerformed
        StringBuilder relatorio = new StringBuilder();
        //relatorio.append("Nome do paciente: ").append(nome).append("\n");
        //relatorio.append("CPF do paciente: ").append(cpf).append("\n");
        //relatorio.append("Data: ").append(data).append("\n");
        //relatorio.append("Receita: ").append(receita).append("\n");
        //relatorio.append("Atestado: (*Documento em pdf*)").append("\n");
        //relatorio.append("Declaração de acompanhamento: (*Documento em pdf*)").append("\n");
        JOptionPane.showMessageDialog(null,relatorio);
    }//GEN-LAST:event_BotaoGerarRelatorioActionPerformed

    private void BotaoGerenciarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGerenciarPacientesActionPerformed
        
            TelaSecGerenciarPaciente NovaTela = new TelaSecGerenciarPaciente();
            NovaTela.setVisible(true);
            this.dispose();
        
    }//GEN-LAST:event_BotaoGerenciarPacientesActionPerformed

    private void BotaoGerenciarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGerenciarConsultasActionPerformed
        TelaSecGerenciarConsulta TelaConsulta = new TelaSecGerenciarConsulta(secretariaLogada, em);
        TelaConsulta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotaoGerenciarConsultasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoGerarRelatorio;
    private javax.swing.JButton BotaoGerenciarConsultas;
    private javax.swing.JButton BotaoGerenciarPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
