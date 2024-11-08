package javabd01.conexao;
import DAO.PessoaDAO;
import beans.Pessoa;
import java.util.HashSet;
import javax.swing.JOptionPane;

public class bd01Editar extends javax.swing.JFrame {

    public bd01Editar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btgSexo = new javax.swing.ButtonGroup();
        txtId = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblIdioma = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        lblIdATT = new javax.swing.JLabel();
        txtIDATT = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        cmbIdioma = new javax.swing.JComboBox<>();
        rdoMasc = new javax.swing.JRadioButton();
        rdoFem = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtId.setText("ID:");

        lblNome.setText("Nome:");

        lblSexo.setText("Sexo:");

        lblIdioma.setText("Idioma:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTitulo.setText("Editar e Excluir Pessoas:");

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        lblIdATT.setText("ID:");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        cmbIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alemão", "Árabe", "Bengal", "Chinês", "Coreano", "Espanhol", "Francês", "Grego", "Gujarati", "Hindi", "Húngaro", "Inglês", "Italiano", "Japonês", "Javanês", "Macedônio", "Malayalam", "Marathi", "Polonês", "Punjabi", "Russo", "Sueco", "Tamil", "Tailand", "Turco", "Ucraniano", "Urdu", "Vietnã", "Xhosa", "PORTUGUÊS", "Zulu" }));

        btgSexo.add(rdoMasc);
        rdoMasc.setText("Masculino");

        btgSexo.add(rdoFem);
        rdoFem.setText("Feminino");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblIdioma)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblIdATT)
                                        .addComponent(lblNome))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                        .addComponent(txtIDATT))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoMasc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoFem)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdATT)
                    .addComponent(txtIDATT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rdoMasc)
                    .addComponent(rdoFem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdioma)
                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        /*int idPessoa = Integer.parseInt(txtID.getText());
        PessoaDAO pDAO = new PessoaDAO();
        
        Pessoa p = pDAO.getPessoa (idPessoa);
        if(p == null){
            limparFormulario();
            JOptionPane.showMessageDialog(this, "Pessoa não encontrada!");
        }
        else{
            txtID.setText(String.valueOf(p.getId()));
            txtNome.setText(p.getNome());
            if(p.getSexo().equals("M")){
                rdoMasc.setSelected(true);
            }
            else {
                rdoFem.setSelected(true);
            }
            cmbIdioma.setSelectedItem(p.getIdioma());
        } */
    }

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
         String sexo = null;
         if (rdoMasc.isSelected()){
            sexo = "M";
        }
        else{
            sexo = "F";
        }
        Pessoa p = new Pessoa();
        
        p.setId(Integer.parseInt(txtIDATT.getText()));
        p.setNome(txtNome.getText());
        p.setSexo(sexo);
        p.setIdioma(cmbIdioma.getSelectedItem().toString());
        
        PessoaDAO pDAO = new PessoaDAO();
        pDAO.editar(p);
        limparFormulario();
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?","Exclusão", JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.YES_OPTION){
           PessoaDAO pDAO = new PessoaDAO();
           pDAO.excluir(Integer.parseInt(txtID.getText()));
           limparFormulario();
        }
    }
       private void limparFormulario(){
           txtNome.setText("");
           txtID.setText("");
           btgSexo.clearSelection();
           cmbIdioma.setSelectedIndex(0);
           txtIDATT.setText("");
           
       }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bd01Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bd01Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bd01Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bd01Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bd01Editar().setVisible(true);
            }
        });
    }

    private javax.swing.ButtonGroup btgSexo;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cmbIdioma;
    private javax.swing.JLabel lblIdATT;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdoFem;
    private javax.swing.JRadioButton rdoMasc;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDATT;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNome;
}
