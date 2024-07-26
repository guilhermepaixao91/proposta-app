package com.paixao.proposta_app.service;

import com.paixao.proposta_app.dto.PropostaRequestDTO;
import com.paixao.proposta_app.dto.PropostaResponseDTO;
import com.paixao.proposta_app.entity.Proposta;
import com.paixao.proposta_app.mapper.PropostaMapper;
import com.paixao.proposta_app.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PropostaService {

    private PropostaRepository propostaRepository;

    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDTO);
        propostaRepository.save(proposta);
        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    public List<PropostaResponseDTO> obterProposta() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}
