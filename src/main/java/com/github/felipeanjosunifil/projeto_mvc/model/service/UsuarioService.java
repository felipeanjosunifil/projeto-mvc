package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Usuario;
import com.github.felipeanjosunifil.projeto_mvc.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Boolean criarUsuario(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Boolean deletarUsuarioPorId(Long id) {

        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
