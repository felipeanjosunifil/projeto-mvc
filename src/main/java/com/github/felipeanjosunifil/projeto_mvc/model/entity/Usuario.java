package com.github.felipeanjosunifil.projeto_mvc.model.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    @ManyToMany
    @JoinTable(
            name = "papeis_usuario",
            joinColumns = @JoinColumn(name= "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "papel_id")
    )
    private List<Papel> papeis;

    public Usuario(Long id, String nome, String email, String senha, List<Papel> papeis) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.papeis = papeis;
    }

    public Usuario() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public List<String> getPapeisString() {
        return this.papeis.stream().map(p -> p.getPapel()).toList();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
