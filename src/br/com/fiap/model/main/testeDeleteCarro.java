package br.com.fiap.model.main;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.factory.ConnectionFactory;
import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;

public class testeDeleteCarro {
    public static void main(String[] args) {


        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();

        cliente.setIdCliente(1);

        ClienteDAO dao = new ClienteDAO(con);

        System.out.println(dao.excluir(cliente));




        ConnectionFactory.fecharConexao(con);
    }
}
