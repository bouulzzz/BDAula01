package javabd01.conexao;
import DAO.PessoaDAO;
import beans.Pessoa;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RelatorioPessoas extends javax.swing.JFrame {

    public RelatorioPessoas() {
        initComponents();
        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPessoa = new javax.swing.JTable();
        lblRelatorio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "Sexo", "Idioma"}
        ));
        jScrollPane1.setViewportView(tblPessoa);

        lblRelatorio.setFont(new java.awt.Font("Segoe UI", 1, 36));
        lblRelatorio.setText("Relatório das Pessoas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblRelatorio)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }

    public void preencherTabela() {
        PessoaDAO pDAO = new PessoaDAO();
        List<Pessoa> lp = pDAO.getPessoas();
        DefaultTableModel tabelaPessoas = (DefaultTableModel) tblPessoa.getModel();

        for (Pessoa p : lp) {
            Object[] o = new Object[]{
                p.getId(),
                p.getNome(),
                p.getSexo(),
                p.getIdioma(),
            };
            tabelaPessoas.addRow(o);
        }
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
            java.util.logging.Logger.getLogger(RelatorioPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioPessoas().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRelatorio;
    private javax.swing.JTable tblPessoa;
}
