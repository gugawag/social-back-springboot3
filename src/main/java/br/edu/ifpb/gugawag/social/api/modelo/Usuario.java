package br.edu.ifpb.gugawag.social.api.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String cpf;
    private String nome;
    private Integer idade;

    public Usuario() {
    }

    public Usuario(DadosUsuarioDTO dadosUsuario) {
        this.id = dadosUsuario.id();
        this.cpf = dadosUsuario.cpf();
        this.nome = dadosUsuario.nome();
        this.idade = dadosUsuario.idade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
