package javabd01.conexao;
import beans.Pessoa;
import DAO.PessoaDAO;

public class bd01 extends javax.swing.JFrame {
    String sexo;

    public bd01() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btgSexo = new javax.swing.ButtonGroup();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rdoMasc = new javax.swing.JRadioButton();
        rdoFem = new javax.swing.JRadioButton();
        lblIdioma = new javax.swing.JLabel();
        cmbIdioma = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("Nome:");

        lblSexo.setText("Sexo:");

        btgSexo.add(rdoMasc);
        rdoMasc.setText("Masculino");

        btgSexo.add(rdoFem);
        rdoFem.setText("Feminino");

        lblIdioma.setText("Idioma:");

        cmbIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alemão", "Árabe", "Bengal", "Chinês", "Coreano", "Espanhol", "Francês", "Grego", "Gujarati", "Hindi", "Húngaro", "Inglês", "Italiano", "Japonês", "Javanês", "Macedônio", "Malayalam", "Marathi", "Polonês", "Punjabi", "Russo", "Sueco", "Tamil", "Tailand", "Turco", "Ucraniano", "Urdu", "Vietnã", "Xhosa", "Zulu" }));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIdioma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addGap(18, 18, 18)
                        .addComponent(rdoMasc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoFem))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(488, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rdoMasc)
                    .addComponent(rdoFem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdioma)
                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addContainerGap(308, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        if(rdoMasc.isSelected()){
            sexo = "M";
        }
        else if (rdoFem.isSelected()){
            sexo = "F";
        }
        Pessoa p = new Pessoa();
        p.setNome(txtNome.getText());
        p.setSexo(sexo);
        p.setIdioma(cmbIdioma.getSelectedItem().toString());

        PessoaDAO pDAO = new PessoaDAO();
        pDAO.inserir(p);
        limparFormulario();
    }

    private void limparFormulario(){
        txtNome.setText("");
        btgSexo.clearSelection();
        cmbIdioma.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(bd01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bd01().setVisible(true);
            }
        });
    }

    private javax.swing.ButtonGroup btgSexo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbIdioma;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rdoFem;
    private javax.swing.JRadioButton rdoMasc;
    private javax.swing.JTextField txtNome;
}
