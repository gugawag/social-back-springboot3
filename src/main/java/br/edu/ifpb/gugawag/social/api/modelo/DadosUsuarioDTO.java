package br.edu.ifpb.gugawag.social.api.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosUsuarioDTO(Long id, @NotBlank String nome, 
         @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", 
                message = "CPF Inválido! Deve ter 11 dígitos.") String cpf, Integer idade) {
}
