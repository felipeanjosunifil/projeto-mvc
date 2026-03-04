package com.github.felipeanjosunifil.projeto_mvc.controller;

import com.github.felipeanjosunifil.projeto_mvc.controller.dto.DadosTokenJWT;
import com.github.felipeanjosunifil.projeto_mvc.model.entity.Usuario;
import com.github.felipeanjosunifil.projeto_mvc.model.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody Usuario usuario) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha());

        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((UserDetails) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}