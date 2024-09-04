package br.com.fiap.dao;

import br.com.fiap.dto.Carro;

import java.rmi.UnexpectedException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO {

    private Connection con;

    public CarroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Carro carro) {
        String sql = "insert into ddd_carro(placa,cor,descricao) values(?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);)// try-with-resources
        {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());
            if (ps.executeUpdate() > 0) {
                return "Inseridoc com sucesso";
            } else {
                return "Falha ao conectar";
            }


        } catch (SQLException e) {
            return "Erro de sql" + e.getMessage();
        }
    }

        public String alterar(Carro carro) {
            String sql = "update ddd_carro set cor=?,descricao=? where placa=?";
            try (PreparedStatement ps = getCon().prepareStatement(sql);)// try-with-resources
            {
                ps.setString(3, carro.getPlaca());
                ps.setString(1, carro.getCor());
                ps.setString(2, carro.getDescricao());
                if (ps.executeUpdate() > 0) {
                    return "Inseridoc com sucesso";
                } else {
                    return "Falha ao conectar";
                }


            } catch (SQLException e) {
                return "Erro de sql" + e.getMessage();
            }

        }

    public String excluir(Carro carro) {
        String sql = "delete from ddd_carro where placa=?";
        try (PreparedStatement ps = getCon().prepareStatement(sql);)// try-with-resources
        {
            ps.setString(1, carro.getPlaca());

            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Falha ao Excluir";
            }


        } catch (SQLException e) {
            return "Erro de sql" + e.getMessage();
        }

    }


    public ArrayList<Carro> listarTodos() {
        String sql = "select * from ddd_carro order by placa";
        ArrayList<Carro> listaCarro = new ArrayList<Carro>();
        try (PreparedStatement ps = getCon().prepareStatement(sql);)// try-with-resources
        {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Carro carro = new Carro();
                    carro.setPlaca(rs.getString(1));
                    carro.setCor(rs.getString(2));
                    carro.setDescricao(rs.getString(3));
                    listaCarro.add(carro);
                }
                return listaCarro;
            } else {
                return null;
            }


        } catch (SQLException e) {
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
        public Carro listarEspecifico(Carro carro) {
            String sql = "select * from ddd_carro where placa=?";
            try (PreparedStatement ps = getCon().prepareStatement(sql);) {
                ps.setString(1, carro.getPlaca());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    carro.setPlaca(rs.getString(1));
                    carro.setCor(rs.getString(2));
                    carro.setDescricao(rs.getString(3));
                    return carro;
                } else {
                    return null;
                }

            } catch (SQLException e) {
                System.out.println("Erro de sql" + e.getMessage());
                return null;
            }


        }
}

