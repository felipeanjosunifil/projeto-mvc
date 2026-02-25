package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.UsuarioRepository;
import com.github.felipeanjosunifil.projeto_mvc.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository repository;
    private PasswordEncoder encoder;

    @Autowired
    public UsuarioService(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Boolean criarUsuario(Usuario usuario) {
        try {
            usuario.setSenha(encoder.encode(usuario.getSenha()));
            repository.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }

    public Boolean deletarUsuarioPorId(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Usuario getUsuarioPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public Boolean atualizarUsuarioPorId(Usuario usuarioAtual) {
        return false;
    }
}
