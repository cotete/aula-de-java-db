package br.com.fiap.dao;

import br.com.fiap.dto.Carro;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Cliente cliente) {
        String sql = "insert into ddd_cliente(id_cliente,nome_cliente,placa) values(?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);)// try-with-resources
        {
            ps.setString(1, String.valueOf(cliente.getIdCliente()));
            ps.setString(2, cliente.getNomeCliente());
            ps.setString(3, cliente.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Inseridoc com sucesso";
            } else {
                return "Falha ao conectar";
            }


        } catch (SQLException e) {
            return "Erro de sql" + e.getMessage();
        }
    }

        public String alterar(Cliente cliente) {
            String sql = "update ddd_cliente set placa=?,nome_cliente=? where id_cliente=?";
            try (PreparedStatement ps = getCon().prepareStatement(sql);)// try-with-resources
            {
                ps.setString(1, cliente.getPlaca());
                ps.setString(3, String.valueOf(cliente.getIdCliente()));
                ps.setString(2, cliente.getNomeCliente());
                if (ps.executeUpdate() > 0) {
                    return "Inseridoc com sucesso";
                } else {
                    return "Falha ao conectar";
                }


            } catch (SQLException e) {
                return "Erro de sql" + e.getMessage();
            }

        }

    public String excluir(Cliente cliente) {
        String sql = "delete from ddd_cliente where id_cliente=?";
        try (PreparedStatement ps = getCon().prepareStatement(sql);)// try-with-resources
        {
            ps.setString(1, String.valueOf(cliente.getIdCliente()));

            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Falha ao Excluir";
            }


        } catch (SQLException e) {
            return "Erro de sql" + e.getMessage();
        }

    }


    public ArrayList<Cliente> listarTodos() {
        String sql = "select * from ddd_carro order by id_cliente";
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        try (PreparedStatement ps = getCon().prepareStatement(sql);)// try-with-resources
        {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(Integer.parseInt(rs.getString(1)));
                    cliente.setNomeCliente(rs.getString(2));
                    cliente.setPlaca(rs.getString(3));
                    listaCliente.add(cliente);
                }
                return listaCliente;
            } else {
                return null;
            }


        } catch (SQLException e) {
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
    public Cliente listarEspecifico(Cliente cliente) {
        String sql = "select * from ddd_carro where id_cliente=?";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, String.valueOf(cliente.getIdCliente()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setIdCliente(Integer.parseInt(rs.getString(1)));
                cliente.setNomeCliente(rs.getString(2));
                cliente.setPlaca(rs.getString(3));
                return cliente;
            } else {
                return null;
            }

            } catch (SQLException e) {
                System.out.println("Erro de sql" + e.getMessage());
                return null;
            }


        }
}

