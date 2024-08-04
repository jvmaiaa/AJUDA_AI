package com.ajuda.ajuda_ai.api.domain.entity;

import com.ajuda.ajuda_ai.api.domain.enums.TipoDeAjuda;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Data
public class ApoiadorEntity extends UsuarioEntity {

    @Enumerated(EnumType.STRING)
    private List<TipoDeAjuda> ajudaPedida;
}
