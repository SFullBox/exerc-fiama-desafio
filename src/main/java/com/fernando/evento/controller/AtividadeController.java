package com.fernando.evento.controller;

import com.fernando.evento.dto.AtividadeDTO;
import com.fernando.evento.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<AtividadeDTO> listarAtividades() {
        return atividadeService.listarAtividades();
    }

    @GetMapping("/{id}")
    public AtividadeDTO obterAtividade(@PathVariable Long id) {
        return atividadeService.obterAtividadePorId(id);
    }

    @PostMapping
    public AtividadeDTO salvarAtividade(@RequestBody AtividadeDTO atividadeDTO) {
        return atividadeService.salvarAtividade(atividadeDTO);
    }
}
