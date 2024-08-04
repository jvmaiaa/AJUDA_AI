package com.ajuda.ajuda_ai.api.service.Impl;

import com.ajuda.ajuda_ai.api.domain.dto.request.ApoiadorRequestDTO;
import com.ajuda.ajuda_ai.api.domain.dto.response.ApoiadorResponseDTO;
import com.ajuda.ajuda_ai.api.domain.entity.ApoiadorEntity;
import com.ajuda.ajuda_ai.api.domain.repository.ApoiadorRepository;
import com.ajuda.ajuda_ai.api.exception.EntityNotFoundException;
import com.ajuda.ajuda_ai.api.mapper.ApoiadorMapper;
import com.ajuda.ajuda_ai.api.service.ApoiadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApoiadorServiceImpl implements ApoiadorService {

    private final ApoiadorRepository apoiadorRepository;

    @Override
    public ApoiadorResponseDTO cadastra(ApoiadorRequestDTO apoiadorRequestDTO) {
        ApoiadorEntity apoiadorEntity = ApoiadorMapper.requestToDTO(apoiadorRequestDTO);
        apoiadorRepository.save(apoiadorEntity);
        return ApoiadorMapper.entityToResponse(apoiadorEntity);
    }

    @Override
    public List<ApoiadorResponseDTO> lista() {
        return apoiadorRepository.findAll()
                .stream()
                .map(ApoiadorMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ApoiadorResponseDTO buscaPorId(Long id) {
        ApoiadorEntity entity = apoiadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apoiador com Id %d não encontrado" + id));
        return ApoiadorMapper.entityToResponse(entity);
    }

    @Override
    public ApoiadorResponseDTO atualiza(Long id, ApoiadorRequestDTO apoiadorRequestDTO) {
        ApoiadorEntity entity = apoiadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apoiador com Id %d não encontrado" + id));
        atualizaCampos(entity, apoiadorRequestDTO);
        apoiadorRepository.save(entity);
        return ApoiadorMapper.entityToResponse(entity);
    }

    @Override
    public void deleta(Long id) {
        ApoiadorEntity entity = apoiadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apoiador com Id %d não encontrado" + id));
        apoiadorRepository.delete(entity);
    }

    private void atualizaCampos(ApoiadorEntity entity, ApoiadorRequestDTO dto){
        entity.setNome(dto.getNome() != null ? dto.getNome() : entity.getNome());
        entity.setEmail(dto.getEmail() != null ? dto.getEmail() : entity.getEmail());
        entity.setNumeroDoWhatsapp(dto.getNumeroDoWhats() != null ? dto.getNumeroDoWhats() : entity.getNumeroDoWhatsapp());
    }
}
