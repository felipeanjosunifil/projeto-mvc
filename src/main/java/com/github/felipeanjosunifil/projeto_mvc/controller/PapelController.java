package com.github.felipeanjosunifil.projeto_mvc.controller;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Papel;
import com.github.felipeanjosunifil.projeto_mvc.model.repositories.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PapelController {

    @Autowired
    private PapelRepository papelRepository;

    @PostMapping("/papel/novo")
    public ResponseEntity<Boolean> save(@RequestBody Papel papel) {
        try {
            papelRepository.save(papel);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
