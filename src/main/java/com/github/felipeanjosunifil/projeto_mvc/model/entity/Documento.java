package com.github.felipeanjosunifil.projeto_mvc.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String documento;

    public Documento(Long id, String tipo, String documento) {
        this.id = id;
        this.tipo = tipo;
        this.documento = documento;
    }

    public Documento(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
