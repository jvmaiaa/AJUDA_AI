package com.ajuda.ajuda_ai.api.domain.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ApoiadorRequestDTO {

    private String nome;

    @Email
    private String email;

    private String numeroDoWhats;
}
