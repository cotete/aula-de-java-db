package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;

public class TesteCreateCarro {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setPlaca("JKK1903");
        cliente.setNomeCliente("Gerson");

        ClienteDAO clienteDAO = new ClienteDAO(con);
        System.out.println(clienteDAO.inserir(cliente));






        ConnectionFactory.fecharConexao(con);
    }
}
