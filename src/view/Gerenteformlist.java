package view;

import controller.GerenteController;
import model.Gerente;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Alunoformlist {
    private JButton salvarBtn;
    private JButton cancelarBtn;
    private JTextField cpfTxt;
    private JTextField telefoneTxt;
    private JTextField nomeTxt;
    private JPanel painelMain;
    private JButton BuscarBtn;
    private JTable gerenteTb;
    private JPanel panelTb;
    private JPanel panelBtn;
    private JTextField data_nascimentogTxt;
    private JTextField ruaTxt;
    private JTextField numeroTxt;
    private JTextField bairroTxt;
    private JTextField cidadeTxt;
    private JTextField nisTxt;
    private JButton deletarBtn;
    private Object MouseEvent;

    public Alunoformlist() {
        salvarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    GerenteController gerenteController = new GerenteController();
                    Gerente gerente = new Gerente();

                    gerente.setCpf(cpfTxt.getText());
                    gerente.setNome(nomeTxt.getText());
                    gerente.setTelefone(telefoneTxt.getText());
                    gerente.setData_nascimentog(data_nascimentogTxt.getText());
                    gerente.setRua(ruaTxt.getText());
                    gerente.setNumero(numeroTxt.getText());
                    gerente.setBairro(bairroTxt.getText());
                    gerente.setCidade(cidadeTxt.getText());
                    gerente.setNis(nisTxt.getText());

                    if (cpfTxt.getText().isEmpty()) {
                        gerenteController.salvar(gerente);
                    } else {
                        gerente.setCpf(cpfTxt.getText());
                        gerenteController.atualizar(gerente);

                    }
                    gerenteController.salvar(gerente);

                    System.out.println("Registro inserido com sucesso!");
                    limpar();
                    gerenteController.listar();
                    salvarBtn.setText("Salvar");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            private void limpar() {
            }
        });

        BuscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (!cpfTxt.getText().isEmpty()
                            || !nomeTxt.getText().isEmpty()
                            || telefoneTxt.getText().isEmpty()
                            || nisTxt.getText().isEmpty()
                            || data_nascimentogTxt.getText().isEmpty()
                            || ruaTxt.getText().isEmpty()
                            || numeroTxt.getText().isEmpty()
                            || bairroTxt.getText().isEmpty()
                            || cidadeTxt.getText().isEmpty()) {
                        GerenteController gerenteController = new GerenteController();
                        Gerente gerente = new Gerente();

                        gerente.setCpf(cpfTxt.getText());
                        gerente.setNome(nomeTxt.getText());
                        gerente.setTelefone(telefoneTxt.getText());
                        gerente.setData_nascimentog(data_nascimentogTxt.getText());
                        gerente.setRua(ruaTxt.getText());
                        gerente.setNumero(numeroTxt.getText());
                        gerente.setBairro(bairroTxt.getText());
                        gerente.setCidade(cidadeTxt.getText());
                        gerente.setNis(nisTxt.getText());

                        gerenteController.buscar(gerente);

                        ResultSet rs = gerenteController.buscar(gerente);

                        gerenteTb.setModel(DbUtils.resultSetToTableModel(rs));

                        setNomeColuna(new String[]{"CPF", "Nome", "Telefone", "Data de Nascimentog", "Rua", "Numero", "Bairro", "Cidade", "NIS"});
                    } else {
                        JOptionPane.showMessageDialog(null, "Informe algum regidtro no formulário!");
                    }
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }
                
            }

            private void setNomeColuna(String[] strings) {
            } catch (SQLException ex)
            { ex.printStackTrace();
            }
        });
    }

        gerenteTb.addMouseListener(new void MouseAdapter() {
        public void mouseClicked (MouseEvent e) {
            super.mouseClicked(e);
            System.out.println("Teste");

            cpfTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 0).toString());
            nomeTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 1).toString());
            telefoneTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 2).toString());
            data_nascimentogTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 3).toString());
            ruaTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 4).toString());
            numeroTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 5).toString());
            bairroTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 6).toString());
            cidadeTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 7).toString());
            nisTxt.setText(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 8).toString());

            salvarBtn.setText("Editar");


        }
    };
        cancelarBtn.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            limpar();
            listar();
            salvarBtn.setText("Salvar");
        }
    };


    public void limpar() {
        cpfTxt.setText("");
        nomeTxt.setText("");
        telefoneTxt.setText("");
        data_nascimentogTxt.setText("");
        ruaTxt.setText("");
        numeroTxt.setText("");
        bairroTxt.setText("");
        cidadeTxt.setText("");
        nisTxt.setText("");
    }

    public void listar() {
        GerenteController gerenteController = new GerenteController();
        gerenteController.listar();
        ResultSet rs = gerenteController.listar();
        //gerenteTb.setTableHeader (null);
        gerenteTb.setModel(DbUtils.resultSetToTableModel(rs));
        setNomeColuna(new String[]{"CPF", "Nome", "Telefone", "Data de Nascimentog", "Rua", "Numero", "Bairro", "Cidade", "NIS"});
    }

    public void setNomeColuna(String[] colunas) {
        for (int i = 0; i < colunas.lenght;
        i++){
            gerenteTb.getColumnModel().getColumn(i).setHeaderValue(colunas[i]);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaAlunoFormList");
        frame.setContentPane(new Alunoformlist().painelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
        deletarBtn.addActionListener(new

    ActionListener() {
        public void actionPerformed (ActionEvent e){
            int i = JOptionPane.showConfirmDialog(null, "Deseja conformar a remoção do registro?");
            if (i == JOptionPane.YES_OPTION && !cpfTxt.getText().isEmpty()) {
                try {

                    GerenteController gerenteController = new GerenteController();

                    int cpf = Integer.parseInt(gerenteTb.getValueAt(gerenteTb.getSelectedRow(), 0).toString());

                    gerenteController.deletar(cpf);
                    listar();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um registro para ser deletado!");
            }
        }
    };
}