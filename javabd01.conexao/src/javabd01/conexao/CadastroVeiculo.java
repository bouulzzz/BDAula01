package javabd01.conexao;
import DAO.PessoaDAO;
import beans.Pessoa;
import java.util.List;
import beans.Veiculo;
import DAO.VeiculoDAO;
import javax.swing.JOptionPane;

public class CadastroVeiculo extends javax.swing.JFrame {
    
    public CadastroVeiculo() {
        initComponents();
        preencherComboPessoas();
    }
    public void preencherComboPessoas(){
        PessoaDAO pDAO = new PessoaDAO();
        List<Pessoa> listaP = pDAO.getPessoas();
        for(Pessoa p : listaP){
            cmbPessoa.addItem(p);
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        lblModelo = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblPessoa = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        cmbPessoa = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblModelo.setText("Modelo");

        lblPlaca.setText("Placa");

        lblPessoa.setText("Pessoa");

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
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalvar)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblPlaca)
                            .addGap(18, 18, 18)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPessoa)
                    .addComponent(cmbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        String modelo = txtModelo.getText();
        String placa = txtPlaca.getText();
        Pessoa pessoaSelecionada = (Pessoa) cmbPessoa.getSelectedItem();
        
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(modelo);
        veiculo.setPlaca(placa);
        veiculo.setPessoaid(pessoaSelecionada); 
        
        VeiculoDAO vDAO = new VeiculoDAO();
        vDAO.inserir(veiculo);
        
        JOptionPane.showMessageDialog(null, "VEÍCULO ADICIONADO!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVeiculo().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbPessoa;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPessoa;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
}
