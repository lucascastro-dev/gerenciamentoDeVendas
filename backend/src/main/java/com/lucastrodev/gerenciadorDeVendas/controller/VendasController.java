package com.lucastrodev.gerenciadorDeVendas.controller;

import com.lucastrodev.gerenciadorDeVendas.entidades.Venda;
import com.lucastrodev.gerenciadorDeVendas.servicos.Vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public class VendasController {

    @Autowired
    private Vendas vendas;

    @GetMapping
    public List<Venda> buscarVendas() {
        return vendas.buscarVenda();
    }
}
