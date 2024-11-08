package javabd01.conexao;

import DAO.PessoaDAO;
import DAO.VeiculoDAO;
import beans.Pessoa;
import beans.Veiculo;
import javax.swing.JOptionPane;

public class EditarVeiculo extends javax.swing.JFrame {

    public EditarVeiculo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        txtIDCons = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblIdPessoa = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblID.setText("ID Veiculo:");

        jLabel1.setText("Placa:");

        lblModelo.setText("Modelo:");

        lblIdPessoa.setText("Nome:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(evt -> btnConsultarActionPerformed(evt));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(evt -> btnEditarActionPerformed(evt));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(evt -> btnExcluirActionPerformed(evt));

        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
        jLabel3.setText("EDIÇÃO VEICULOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblModelo)
                                .addComponent(lblIdPessoa)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(lblID))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIDCons)
                                .addComponent(txtID)
                                .addComponent(txtPlaca)
                                .addComponent(txtNome)
                                .addComponent(txtModelo)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnConsultar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEditar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnExcluir))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addGap(21, 21, 21)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblID)
                        .addComponent(txtIDCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lblModelo)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lblIdPessoa)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConsultar)
                        .addComponent(btnEditar)
                        .addComponent(btnExcluir))
                    .addGap(28, 28, 28))
        );

        pack();
    }

    private void limparFormulario() {
        txtID.setText("");
        txtNome.setText("");
        txtIDCons.setText("");
        txtModelo.setText("");
        txtPlaca.setText("");
    }

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        int idVeiculo = Integer.parseInt(txtIDCons.getText());
        VeiculoDAO vDAO = new VeiculoDAO();
        Veiculo veiculo = vDAO.getVeiculo(idVeiculo);

        if (veiculo == null) {
            limparFormulario();
            JOptionPane.showMessageDialog(this, "Veículo não encontrado!");
        } else {
            txtIDCons.setText(String.valueOf(veiculo.getId()));
            txtID.setText(String.valueOf(veiculo.getId()));
            txtModelo.setText(veiculo.getModelo());
            txtPlaca.setText(veiculo.getPlaca());

            if (veiculo.getPessoaid() != null) {
                PessoaDAO pDAO = new PessoaDAO();
                Pessoa p = pDAO.getPessoa(veiculo.getId());
                if (p != null) {
                    txtNome.setText(p.getNome());
                } else {
                    txtNome.setText("Pessoa não encontrada");
                }
            }
        }
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            VeiculoDAO vDAO = new VeiculoDAO();
            vDAO.excluir(Integer.parseInt(txtIDCons.getText()));
            limparFormulario();
        }
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(Integer.parseInt(txtIDCons.getText()));
        veiculo.setModelo(txtModelo.getText());
        veiculo.setPlaca(txtPlaca.getText());

        PessoaDAO pDAO = new PessoaDAO();
        Pessoa p = pDAO.getPessoa(veiculo.getId());

        if (p != null) {
            veiculo.setPessoaid(p);
        } else {
            System.out.println("Pessoa não encontrada");
        }

        VeiculoDAO vDAO = new VeiculoDAO();
        vDAO.editar(veiculo);
        limparFormulario();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EditarVeiculo().setVisible(true));
    }

    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIdPessoa;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDCons;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPlaca;
}
