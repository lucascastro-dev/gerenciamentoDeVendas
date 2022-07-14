package com.lucastrodev.gerenciadorDeVendas.repositorios;

import com.lucastrodev.gerenciadorDeVendas.entidades.Venda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {

    @Query("SELECT obj FROM Venda obj WHERE obj.dataDaVenda BETWEEN :min AND :max ORDER BY obj.dataDaVenda DESC")
    Page<Venda> filtarVendas(LocalDate min, LocalDate max, Pageable pageable);
}
