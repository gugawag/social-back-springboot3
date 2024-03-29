package br.edu.ifpb.gugawag.social.api.repositorio;


import br.edu.ifpb.gugawag.social.api.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepositorioIF extends JpaRepository<Usuario, Long> {

    public List<Usuario> findByNomeAndIdade(String nome, Integer idade);

    @Query("SELECT u from Usuario u where u.idade>=60")
    public List<Usuario> getIdosos();

}
