package com.ajuda.ajuda_ai.api.service;

import com.ajuda.ajuda_ai.api.domain.dto.request.ApoiadorRequestDTO;
import com.ajuda.ajuda_ai.api.domain.dto.response.ApoiadorResponseDTO;

import java.util.List;

public interface ApoiadorService {

    ApoiadorResponseDTO cadastra(ApoiadorRequestDTO apoiadorRequestDTO);

    List<ApoiadorResponseDTO> lista();

    ApoiadorResponseDTO buscaPorId(Long id);

    ApoiadorResponseDTO atualiza(Long id, ApoiadorRequestDTO apoiadorRequestDTO);

    void deleta(Long id);

}
