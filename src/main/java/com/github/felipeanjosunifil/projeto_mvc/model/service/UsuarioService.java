package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Usuario;
import com.github.felipeanjosunifil.projeto_mvc.model.repository.UsuarioRepository;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean criarUsuario(@RequestBody Usuario usuario) throws Exception {
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }

            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Usuario> getUsuarios() {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        return (List<Usuario>) usuarios;
    }

    public boolean deletarUsuarioPorId(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return true;
    }
}
