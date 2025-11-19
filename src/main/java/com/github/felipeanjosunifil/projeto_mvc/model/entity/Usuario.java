package com.github.felipeanjosunifil.projeto_mvc.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "O nome não pode ser vazio")
    private String nome;
    @Size(min = 6, max = 10, message = "A senha deve conter entre 6 e 10 dígitos")
    private String senha;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documento_id")
    private Documento documento;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private List<Contato> contatos;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "usuario_enderecos",
            joinColumns = @JoinColumn(name="usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> enderecos;

    public Usuario(String nome, String senha, Documento documento, List<Contato> contatos) {
        this.nome = nome;
        this.senha = senha;
        this.documento = documento;
        this.contatos = contatos;
    }

    public Usuario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
