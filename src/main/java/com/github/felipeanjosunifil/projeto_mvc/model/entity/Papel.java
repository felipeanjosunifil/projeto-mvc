package com.github.felipeanjosunifil.projeto_mvc.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "papeis")
public class Papel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //role
    private String papel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
}
