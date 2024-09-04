package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;

import java.sql.Connection;
import java.util.ArrayList;

public class TesteRead {
    public static void main(String[] args) {

        Connection con = ConnectionFactory.abrirConexao();

        CarroDAO carroDAO = new CarroDAO(con);

        Carro pesquisa = new Carro();
        pesquisa.setPlaca("JKK1900");

        Carro resultado = carroDAO.listarEspecifico(pesquisa);

        if (resultado !=null){
            System.out.println(resultado.getPlaca());
            System.out.println(resultado.getCor());
            System.out.println(resultado.getDescricao());
            System.out.println("--------------------");
        }

        ConnectionFactory.fecharConexao(con);


    }
}
