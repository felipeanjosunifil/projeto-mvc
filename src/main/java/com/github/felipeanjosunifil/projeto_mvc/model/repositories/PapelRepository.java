package com.github.felipeanjosunifil.projeto_mvc.model.repositories;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {
}
