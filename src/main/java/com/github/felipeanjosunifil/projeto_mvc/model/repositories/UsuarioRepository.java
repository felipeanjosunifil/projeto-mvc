package com.github.felipeanjosunifil.projeto_mvc.model.repositories;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
}
