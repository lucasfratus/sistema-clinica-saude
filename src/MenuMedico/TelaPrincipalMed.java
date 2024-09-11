package MenuMedico;

import MenuMedico.TelaMedGerenciarPaciente;
import EmpregadosClinica.Medico;
import Fichas.Prontuario;
import MenuLogin.Login;
import Sistema.PacienteCadastrado;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;


public class TelaPrincipalMed extends javax.swing.JFrame {
    private Medico medicoLogado;
    private EntityManager em;

    public TelaPrincipalMed(Medico medicoLogado, EntityManager em) {
        initComponents();
        this.medicoLogado = medicoLogado;
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botaoGerenciarP = new javax.swing.JButton();
        botaoGerenciarProntuarios = new javax.swing.JButton();
        botaoGerarRelatorios = new javax.swing.JButton();
        botaoLogout = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal - Usuario: Medico");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bem vindo(a)!");

        botaoGerenciarP.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoGerenciarP.setText("Gerenciar Pacientes");
        botaoGerenciarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerenciarPActionPerformed(evt);
            }
        });

        botaoGerenciarProntuarios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoGerenciarProntuarios.setText("Gerenciar Prontuarios");
        botaoGerenciarProntuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerenciarProntuariosActionPerformed(evt);
            }
        });

        botaoGerarRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoGerarRelatorios.setText("Gerar Relatórios Médicos");
        botaoGerarRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatoriosActionPerformed(evt);
            }
        });

        botaoLogout.setText("Logout");
        botaoLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLogoutActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoGerenciarP, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoGerenciarProntuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoGerarRelatorios))
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoLogout)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(botaoGerenciarP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(botaoGerenciarProntuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(botaoGerarRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(botaoLogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botaoGerenciarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerenciarPActionPerformed
        TelaMedGerenciarPaciente telaGerenciar = new TelaMedGerenciarPaciente(medicoLogado, em);
        telaGerenciar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoGerenciarPActionPerformed

    private void botaoGerarRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatoriosActionPerformed
        String cpfPaciente = JOptionPane.showInputDialog(null, "Insira o CPF do paciente que deseja gerar um relatório médico:");
        PacienteCadastrado pacienteRelatorio = em.find(PacienteCadastrado.class, cpfPaciente);
        Prontuario prontuarioPaciente = em.find(Prontuario.class, cpfPaciente);
        
        if(pacienteRelatorio != null && prontuarioPaciente != null){
            TelaMedRelatorio telaRelatorio = new TelaMedRelatorio(pacienteRelatorio, medicoLogado, em);
            telaRelatorio.setVisible(true);
            
        } if(pacienteRelatorio == null) {
            JOptionPane.showMessageDialog(null, "CPF incorreto/Paciente não existe.", "Credenciais não encontradas", JOptionPane.ERROR_MESSAGE);
        
        } if(prontuarioPaciente == null){
            JOptionPane.showMessageDialog(null, "Para gerar relatórios médicos, é necessário que o paciente tenha um prontuario", "Prontuario não encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoGerarRelatoriosActionPerformed

    private void botaoGerenciarProntuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerenciarProntuariosActionPerformed
        TelaMedGerenciarProntuarios telaGPront = new TelaMedGerenciarProntuarios(medicoLogado, em);
        telaGPront.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoGerenciarProntuariosActionPerformed

    private void botaoLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLogoutActionPerformed
        Login telaLogin = new Login(em);
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGerarRelatorios;
    private javax.swing.JButton botaoGerenciarP;
    private javax.swing.JButton botaoGerenciarProntuarios;
    private javax.swing.JButton botaoLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
