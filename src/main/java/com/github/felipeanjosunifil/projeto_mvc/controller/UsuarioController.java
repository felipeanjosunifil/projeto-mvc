package com.github.felipeanjosunifil.projeto_mvc.controller;

import com.github.felipeanjosunifil.projeto_mvc.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private int ID = 0;
    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/novo")
    public ResponseEntity<Boolean> criarUsuario(@RequestBody Usuario usuario) {
        usuario.setId(++ID);
        usuarios.add(usuario);
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.status(200).body(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarUsuarioPorId(@PathVariable("id") int id) {
        Usuario usuarioDelecao = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarioDelecao = usuario;
            }
        }

        if (usuarioDelecao != null) {
            usuarios.remove(usuarioDelecao);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(404).body(false);
        }
    }

    public ResponseEntity<Boolean> deletarUsuarioPor(@PathVariable("id") int id) {

        boolean deletou = usuarios.removeIf(usuario -> usuario.getId() == id);

        if(deletou) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(404).body(false);
        }
    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarUsuarioPorId(@RequestBody Usuario usuarioAtual) {
//        boolean atualizado = false;
        Usuario usuarioAtualiacao = null;
        int index = 0;

        for (Usuario usuario : usuarios) {
            if (usuarioAtualiacao == null) {
                index++;
            }
            if (usuario.getId() == usuarioAtual.getId()) {
                usuarioAtualiacao = usuario;
            }
        }

        if (usuarioAtualiacao != null) {
            usuarios.set(index-1, usuarioAtual);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }
}
