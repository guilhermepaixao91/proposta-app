package com.paixao.proposta_app.controller;

import com.paixao.proposta_app.dto.PropostaRequestDTO;
import com.paixao.proposta_app.dto.PropostaResponseDTO;
import com.paixao.proposta_app.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> criar(@RequestBody PropostaRequestDTO requestDTO) {
        PropostaResponseDTO response = propostaService.criar(requestDTO);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri()).body(response);

    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDTO>> obterProposta(){
        return ResponseEntity.ok(propostaService.obterProposta());
    }
}
