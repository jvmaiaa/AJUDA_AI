package com.ajuda.ajuda_ai.api.mapper;

import com.ajuda.ajuda_ai.api.domain.dto.request.ApoiadorRequestDTO;
import com.ajuda.ajuda_ai.api.domain.dto.response.ApoiadorResponseDTO;
import com.ajuda.ajuda_ai.api.domain.entity.ApoiadorEntity;

public class ApoiadorMapper {

    public static ApoiadorEntity requestToDTO(ApoiadorRequestDTO dto){
        if (dto == null){
            return null;
        }
        ApoiadorEntity entity = new ApoiadorEntity();
        entity.setNome(dto.getNome() != null ? dto.getNome() : entity.getNome());
        entity.setEmail(dto.getEmail() != null ? dto.getEmail() : entity.getEmail());
        entity.setNumeroDoWhatsapp(dto.getNumeroDoWhats() != null ? dto.getNumeroDoWhats() : entity.getNumeroDoWhatsapp());
        return entity;
    }

    public static ApoiadorResponseDTO entityToResponse(ApoiadorEntity entity){
        if (entity == null) {
            return null;
        }
        ApoiadorResponseDTO responseDTO = new ApoiadorResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setNome(entity.getNome());
        responseDTO.setEmail(entity.getEmail());
        responseDTO.setNumeroDoWhats(entity.getNumeroDoWhatsapp());
        return responseDTO;
    }
}
