package javabd01.conexao;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        sair = new javax.swing.JCheckBoxMenuItem();
        menu_cadPessoa = new javax.swing.JMenu();
        menuCadPessoa = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        RelatorioPessoa = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jMenu1.setText("Arquivo");

        sair.setSelected(true);
        sair.setText("Sair");
        sair.addActionListener(evt -> sairActionPerformed(evt));
        jMenu1.add(sair);

        jMenuBar1.add(jMenu1);

        menu_cadPessoa.setText("Cadastro");
        menu_cadPessoa.addActionListener(evt -> menu_cadPessoaActionPerformed(evt));

        menuCadPessoa.setText("Cadastro de Pessoas");
        menuCadPessoa.addActionListener(evt -> menuCadPessoaActionPerformed(evt));
        menu_cadPessoa.add(menuCadPessoa);

        jMenuItem2.setText("Editar e excluir Pessoas");
        jMenuItem2.addActionListener(evt -> jMenuItem2ActionPerformed(evt));
        menu_cadPessoa.add(jMenuItem2);

        jMenuBar1.add(menu_cadPessoa);

        jMenu3.setText("Relatórios");
        jMenu3.addActionListener(evt -> jMenu3ActionPerformed(evt));

        RelatorioPessoa.setSelected(true);
        RelatorioPessoa.setText("Relatório de Pessoas");
        RelatorioPessoa.addActionListener(evt -> RelatorioPessoaActionPerformed(evt));
        jMenu3.add(RelatorioPessoa);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }

    private void menuCadPessoaActionPerformed(java.awt.event.ActionEvent evt) {
        bd01Editar cadPessoa = new bd01Editar();
        cadPessoa.setVisible(true);
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Implementação para editar e excluir pessoas
    }

    private void menu_cadPessoaActionPerformed(java.awt.event.ActionEvent evt) {
        // Implementação adicional, se necessário
    }

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Implementação adicional para relatórios, se necessário
    }

    private void RelatorioPessoaActionPerformed(java.awt.event.ActionEvent evt) {
        RelatorioPessoas rp = new RelatorioPessoas();
        rp.setVisible(true);
    }

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }

    private javax.swing.JCheckBoxMenuItem RelatorioPessoa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menuCadPessoa;
    private javax.swing.JMenu menu_cadPessoa;
    private javax.swing.JCheckBoxMenuItem sair;
}
