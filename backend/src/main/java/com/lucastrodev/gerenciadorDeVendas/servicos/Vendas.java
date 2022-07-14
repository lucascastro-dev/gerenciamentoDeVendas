package com.lucastrodev.gerenciadorDeVendas.servicos;

import com.lucastrodev.gerenciadorDeVendas.entidades.Venda;
import com.lucastrodev.gerenciadorDeVendas.repositorios.VendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vendas {

    @Autowired
    private VendaRepositorio vendaRepositorio;

    public List<Venda> buscarVenda() {
        return vendaRepositorio.findAll();
    }
}