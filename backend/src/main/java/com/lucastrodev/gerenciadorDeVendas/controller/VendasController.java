package com.lucastrodev.gerenciadorDeVendas.controller;

import com.lucastrodev.gerenciadorDeVendas.entidades.Venda;
import com.lucastrodev.gerenciadorDeVendas.servicos.Vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vendas")
public class VendasController {

    @Autowired
    private Vendas vendas;

    @GetMapping
    public Page<Venda> buscarVendas(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return vendas.buscarVenda(maxDate, minDate, pageable);
    }
}
