package br.com.fiap.controller;

import br.com.fiap.model.dao.CarroDAO;
import br.com.fiap.model.dto.Carro;
import br.com.fiap.model.dto.Cliente;
import br.com.fiap.model.factory.ConnectionFactory;

import java.sql.Connection;

public class CarroController {
    public String inserirCarro(String cor, String placa,String desc){
        Carro carro = new Carro();
        carro.setCor(cor);
        carro.setPlaca(placa);
        carro.setDescricao(desc);
        Connection con = ConnectionFactory.abrirConexao();
        CarroDAO carroDao = new CarroDAO(con);
        String resultado = carroDao.inserir(carro);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    public String alterarCliente(String cor, String placa,String desc){
        Carro carro = new Carro();
        carro.setCor(cor);
        carro.setPlaca(placa);
        carro.setDescricao(desc);
        Connection con = ConnectionFactory.abrirConexao();
        CarroDAO carroDao = new CarroDAO(con);
        String resultado = carroDao.alterar(carro);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    public String excluirCliente(String placa){
        Carro carro = new Carro();
        carro.setPlaca(placa);
        Connection con = ConnectionFactory.abrirConexao();
        CarroDAO carroDao = new CarroDAO(con);
        String resultado = carroDao.excluir(carro);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    public String listarUm(String placa){
        Carro carro = new Carro();
        carro.setPlaca(placa);
        Connection con = ConnectionFactory.abrirConexao();
        CarroDAO carroDao = new CarroDAO(con);
        String resultado = carroDao.listarEspecifico(carro);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
