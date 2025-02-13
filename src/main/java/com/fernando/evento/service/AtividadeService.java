package com.fernando.evento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.evento.dto.AtividadeDTO;
import com.fernando.evento.entity.Atividade;
import com.fernando.evento.repository.AtividadeRepository;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<AtividadeDTO> listarAtividades() {
        List<Atividade> atividades = atividadeRepository.findAll();
        return atividades.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public AtividadeDTO obterAtividadePorId(Long id) {
        Optional<Atividade> atividade = atividadeRepository.findById(id);
        return atividade.map(this::converterParaDTO).orElse(null);
    }

    public AtividadeDTO salvarAtividade(AtividadeDTO atividadeDTO) {
        Atividade atividade = new Atividade();
        atividade.setNome(atividadeDTO.getNome());
        atividade.setDescricao(atividadeDTO.getDescricao());
        atividade.setPreco(atividadeDTO.getPreco());

        Atividade savedAtividade = atividadeRepository.save(atividade);
        return converterParaDTO(savedAtividade);
    }

    private AtividadeDTO converterParaDTO(Atividade atividade) {
        AtividadeDTO atividadeDTO = new AtividadeDTO();
        atividadeDTO.setId(atividade.getId());
        atividadeDTO.setNome(atividade.getNome());
        atividadeDTO.setDescricao(atividade.getDescricao());
        atividadeDTO.setPreco(atividade.getPreco());
        return atividadeDTO;
    }
}
