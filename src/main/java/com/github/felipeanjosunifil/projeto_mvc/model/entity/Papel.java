package com.github.felipeanjosunifil.projeto_mvc.model.entity;

import jakarta.persistence.*;

@Entity(name = "papeis")
public class Papel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //role
    @Column(unique = true)
    private String papel;

    public Papel() {
    }


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

    public Papel(Long id, String papel) {
        this.id = id;
        this.papel = papel;
    }
}
