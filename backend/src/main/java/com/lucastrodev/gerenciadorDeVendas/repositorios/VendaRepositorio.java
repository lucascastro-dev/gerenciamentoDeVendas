package com.lucastrodev.gerenciadorDeVendas.repositorios;

import com.lucastrodev.gerenciadorDeVendas.entidades.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {
}
