package com.fernando.evento.dto;

import lombok.Data;

@Data
public class AtividadeDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
}
