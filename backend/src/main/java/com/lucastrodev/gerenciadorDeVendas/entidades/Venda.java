package com.lucastrodev.gerenciadorDeVendas.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_sales")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeVendedor;
    private Integer numeroDeVisitas;
    private Integer numeroDeVendas;
    private Double totalDaVenda;
    private LocalDate dataDaVenda;
}
