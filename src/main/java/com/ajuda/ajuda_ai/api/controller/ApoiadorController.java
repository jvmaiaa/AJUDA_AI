package com.ajuda.ajuda_ai.api.controller;

import com.ajuda.ajuda_ai.api.domain.dto.request.ApoiadorRequestDTO;
import com.ajuda.ajuda_ai.api.domain.dto.response.ApoiadorResponseDTO;
import com.ajuda.ajuda_ai.api.service.ApoiadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/apoiador")
public class ApoiadorController {

    private final ApoiadorService apoiadorService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ApoiadorResponseDTO cadastra(@RequestBody ApoiadorRequestDTO requestDTO){
        return apoiadorService.cadastra(requestDTO);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ApoiadorResponseDTO> lista(){
        return apoiadorService.lista();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ApoiadorResponseDTO buscaPorId(@PathVariable Long id){
        return apoiadorService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public ApoiadorResponseDTO Atualiza(@PathVariable Long id,
                                          @RequestBody ApoiadorRequestDTO dto){
        return apoiadorService.atualiza(id, dto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void cadastra(@PathVariable Long id){
        apoiadorService.deleta(id);
    }

}
