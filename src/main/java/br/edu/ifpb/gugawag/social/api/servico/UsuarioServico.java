package br.edu.ifpb.gugawag.social.api.servico;

import br.edu.ifpb.gugawag.social.api.modelo.DadosListagemUsuarioDTO;
import br.edu.ifpb.gugawag.social.api.modelo.DadosUsuarioDTO;
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

    public List<DadosListagemUsuarioDTO> listarUsuarios(){
        return this.usuarioRepositorio.findAll().stream().map(DadosListagemUsuarioDTO::new).toList();
    }


    public Usuario getUsuarioPorId(Long idUsuario) {
        return this.usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    @Transactional
    public Usuario inserirOuAtualizar(DadosUsuarioDTO dadosUsuarioAInserir) {
        Usuario usuarioAInserir = new Usuario(dadosUsuarioAInserir);
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
