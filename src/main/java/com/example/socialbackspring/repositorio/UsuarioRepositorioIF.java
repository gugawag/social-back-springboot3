package com.example.socialbackspring.repositorio;


import com.example.socialbackspring.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorioIF extends JpaRepository<Usuario, Long> {
}
