package br.edu.ifpb.gugawag.social.api.servico;

import br.edu.ifpb.gugawag.social.api.repositorio.UsuarioRepositorioIF;
import br.edu.ifpb.gugawag.social.api.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorioIF usuarioRepositorio;

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepositorio.findAll();
    }

    public Usuario getUsuarioPorId(Long idUsuario) {
        return this.usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    @Transactional
    public Usuario inserirOuAtualizar(Usuario usuarioAInserir) {
        Usuario usuarioInserido = this.usuarioRepositorio.save(usuarioAInserir);
        if (usuarioAInserir.getIdade() < 18) {
            throw new RuntimeException("Menor de idade");
        }

        usuarioInserido.setNome(usuarioInserido.getNome() + " - alterado");
        return usuarioInserido;
    }

    public void apagar(Long id) {
        this.usuarioRepositorio.deleteById(id);
    }

    public List<Usuario> getIdosos(){
        return this.usuarioRepositorio.getIdosos();
    }
}
