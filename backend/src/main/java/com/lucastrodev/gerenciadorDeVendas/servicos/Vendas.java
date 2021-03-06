package com.lucastrodev.gerenciadorDeVendas.servicos;

import com.lucastrodev.gerenciadorDeVendas.entidades.Venda;
import com.lucastrodev.gerenciadorDeVendas.repositorios.VendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class Vendas {

    @Autowired
    private VendaRepositorio vendaRepositorio;

    public Page<Venda> buscarVenda(String maxDate, String minDate, Pageable pageable) {

        var dataAtual = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        var dataMinima = minDate.equals("") ? dataAtual.minusDays(90) : LocalDate.parse(minDate);
        var dataMaxima = maxDate.equals("") ? dataAtual : LocalDate.parse(maxDate);

        return vendaRepositorio.filtarVendas(dataMinima, dataMaxima, pageable);
    }
}