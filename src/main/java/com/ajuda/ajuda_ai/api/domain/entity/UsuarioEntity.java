package com.ajuda.ajuda_ai.api.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String numeroDoWhatsapp;

    @OneToMany
    @JoinColumn(name = "seguidor_id")
    private List<UsuarioEntity> seguidores;

    @OneToMany
    @JoinColumn(name = "seguido_id")
    private List<UsuarioEntity> seguidos;
}
