package br.edu.ifpb.gugawag.social.api.controlador;

import br.edu.ifpb.gugawag.social.api.modelo.DadosListagemUsuarioDTO;
import br.edu.ifpb.gugawag.social.api.modelo.DadosUsuarioDTO;
import br.edu.ifpb.gugawag.social.api.modelo.Usuario;
import br.edu.ifpb.gugawag.social.api.servico.UsuarioServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping
    public List<DadosListagemUsuarioDTO> listarUsuarios() {
        return this.usuarioServico.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioPorId(@PathVariable("id") Long idUsuario) {
        return this.usuarioServico.getUsuarioPorId(idUsuario);
    }

    @PostMapping
    public Usuario inserir(@RequestBody @Valid DadosUsuarioDTO usuarioAInserir) {
        return this.usuarioServico.inserirOuAtualizar(usuarioAInserir);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody @Valid DadosUsuarioDTO dadosUsuarioAAlterar) {
        return this.usuarioServico.inserirOuAtualizar(dadosUsuarioAAlterar);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id) {
        this.usuarioServico.apagar(id);
    }

    @GetMapping("/idosos")
    public List<Usuario> getIdosos() {
        return this.usuarioServico.getIdosos();
    }
}
