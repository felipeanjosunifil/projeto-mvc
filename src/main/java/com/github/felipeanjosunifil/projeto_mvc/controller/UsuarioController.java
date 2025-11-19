package com.github.felipeanjosunifil.projeto_mvc.controller;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Usuario;
import com.github.felipeanjosunifil.projeto_mvc.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/novo")
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.criarUsuario(usuario);
            return ResponseEntity.status(201).body(true);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getCause().getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.status(200).body(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarUsuarioPorId(@PathVariable("id") Long id) {

        try {
            usuarioService.deletarUsuarioPorId(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(false);
        }
    }


    @PutMapping
    public ResponseEntity<Boolean> atualizarUsuario(@RequestBody Usuario usuarioAtual) {

        try {
            usuarioService.atualizarUsuario(usuarioAtual);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
