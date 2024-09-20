package br.com.fiap.model.main;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.factory.ConnectionFactory;
import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;

public class TesteUpdateCarro {
    public static void main(String[] args) {

        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setPlaca("JKK1900");
        cliente.setNomeCliente("Jorge");
        cliente.setIdCliente(1);

        ClienteDAO dao = new ClienteDAO(con);

        System.out.println(dao.alterar(cliente));

        ConnectionFactory.fecharConexao(con);
    }
}
