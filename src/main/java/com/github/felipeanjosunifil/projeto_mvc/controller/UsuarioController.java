package com.github.felipeanjosunifil.projeto_mvc.controller;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Usuario;
import com.github.felipeanjosunifil.projeto_mvc.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/novo")
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        Boolean criou = false;
        try {
            criou = usuarioService.criarUsuario(usuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        if (criou) {
            return ResponseEntity.status(201).body(true);
        } else {
            return ResponseEntity.status(400).body(false);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.status(200).body(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarUsuarioPorId(@PathVariable("id") Long id) {
        Boolean deletou = usuarioService.deletarUsuarioPorId(id);

        if (deletou) {
            return ResponseEntity.status(200).body(true);
        } else {
            return ResponseEntity.status(404).body(false);
        }
    }


    @PutMapping
    public ResponseEntity<Boolean> atualizarUsuarioPorId(@RequestBody Usuario usuarioAtual) {
            return ResponseEntity.status(400).body(false);
    }
}
