package com.fernando.evento.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Atividade {

    @Id
    private Integer id;

    private String nome;

    @ManyToMany
    @JoinTable(
        name = "atividade_bloco_horario",
        joinColumns = @JoinColumn(name = "atividade_id"),
        inverseJoinColumns = @JoinColumn(name = "bloco_horario_id")
    )
    private List<BlocoHorario> blocos;
    
    public Atividade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<BlocoHorario> getBlocos() {
        return blocos;
    }

    public void setBlocos(List<BlocoHorario> blocos) {
        this.blocos = blocos;
    }

}
