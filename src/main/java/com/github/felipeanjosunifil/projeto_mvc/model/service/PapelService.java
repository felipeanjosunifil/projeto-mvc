package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Papel;
import com.github.felipeanjosunifil.projeto_mvc.model.repositories.PapelRepository;
import com.github.felipeanjosunifil.projeto_mvc.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PapelService {

    private PapelRepository papelRepository;

    @Autowired
    public PapelService(PapelRepository papelRepository) {
        this.papelRepository = papelRepository;
    }

    public void save(Papel papel) {
        papelRepository.save(papel);
    }
}
