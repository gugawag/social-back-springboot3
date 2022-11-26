package com.example.socialbackspring.servico;

import com.example.socialbackspring.modelo.Usuario;
import com.example.socialbackspring.repositorio.UsuarioRepositorioIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorioIF usuarioRepositorio;

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario getUsuarioPorId(Long idUsuario) {
        return this.usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    public Usuario inserirOuAtualizar(Usuario usuarioAInserir) {
        return this.usuarioRepositorio.save(usuarioAInserir);
    }

    public void apagar(Long id) {
        this.usuarioRepositorio.deleteById(id);
    }
}
