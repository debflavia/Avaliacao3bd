package controller;

import database.Conexao;
import model.Gerente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GerenteController {
    private Conexao bd;

    public GerenteController() {
        this.bd = new Conexao();
    }

    public void testarConexao() {
        this.bd.getConexao();
        System.out.println("Conectou");

    }

    public void salvar(Gerente gerente) throws SQLException {
        String sql;
        try {
            sql = "INSERT INTO gerente (cpf, nome, telefone, data_nascimentog, rua, numero, bairro, cidade, nis) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = this.bd.getConexao().prepareStatement(sql);

            stmt.setString(1, gerente.getCpf());
            stmt.setString(2, gerente.getNome());
            stmt.setString(3, gerente.getTelefone());
            stmt.setString(4, gerente.getData_nascimentog());
            stmt.setString(5, gerente.getRua());
            stmt.setString(6, gerente.getNumero());
            stmt.setString(7, gerente.getBairro());
            stmt.setString(8, gerente.getCidade());
            stmt.setString(9, gerente.getNis());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    public ResultSet listar() {
        String sql;
        try {
            sql = "SELECT * FROM gerente";
            PreparedStatement stmt = this.bd.getConexao().prepareStatement(sql);

            ResultSet rs = ((PreparedStatement) stmt).executeQuery();


            return rs;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    public void atualizar(Gerente gerente) { throws SQLException {
        String sql;
        try {
            sql = "UPDATE gerente SET nome=?, telefone=?, data_nascimentog=?, rua=?, numero=?, bairro=?, cidade=?, nis=? WHERE cpf=?";
            PreparedStatement stmt = this.bd.getConexao().prepareStatement(sql);

            stmt.setInt(9, Integer.parseInt(gerente.getCpf()));
            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getTelefone());
            stmt.setString(3, gerente.getData_nascimentog());
            stmt.setString(4, gerente.getRua());
            stmt.setString(5, gerente.getNumero());
            stmt.setString(6, gerente.getBairro());
            stmt.setString(7, gerente.getCidade());
            stmt.setString(8, gerente.getNis());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    }

    public void deletar(int cpf) {
        throws SQLException {
            String sql;
            try {
                sql = "DELETE FROM gerente WHERE cpf=?";
                PreparedStatement stmt = this.bd.getConexao().prepareStatement(sql);

                stmt.setInt(1, cpf);

                stmt.execute();
                stmt.close();

            } catch (SQLException ex) {
                throw new RuntimeException();
            }
        }
    }

    public ResultSet buscar(Gerente gerente) {
        throws SQLException) {
            String sql= "";
            try {
                if (!gerente.getCpf().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE cpf LIKE '%" + gerente.getCpf() + "%'";

                } else if (!gerente.getNome().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE nome LIKE '%" + gerente.getNome() + "%'";

                } else if (!gerente.getTelefone().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE telefone LIKE '%" + gerente.getTelefone() + "%'";

                } else if (!gerente.getData_nascimentog().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE data_nascimentog LIKE '%" + gerente.getData_nascimentog() + "%'";

                } else if (!gerente.getRua().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE rua LIKE '%" + gerente.getRua() + "%'";

                } else if (!gerente.getNumero().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE numero LIKE '%" + gerente.getNumero() + "%'";

                } else if (!gerente.getBairro().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE bairro LIKE '%" + gerente.getBairro() + "%'";

                } else if (!gerente.getCidade().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE cidade LIKE '%" + gerente.getCidade() + "%'";

                } else if (!gerente.getNis().isEmpty()) {
                    sql = "SELECT * FROM gerente WHERE nis LIKE '%" + gerente.getNis() + "%'";

                }

                System.out.println(sql);


                PreparedStatement stmt = this.bd.getConexao().prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                return rs;
            } catch (SQLException ex) {
                throw new RuntimeException();
            }
        }
    }
}
