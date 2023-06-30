package br.edu.ifpb.gugawag.social.api.modelo;

public record DadosListagemUsuarioDTO(Long id, String nome, String cpf) {

    public DadosListagemUsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf());
    }
}
