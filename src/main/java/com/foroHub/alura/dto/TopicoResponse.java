package com.foroHub.alura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class TopicoResponse {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    private String categoria;

    private Set<TopicoDTO> topicos = new HashSet<>();

    public TopicoResponse() {
    }

    public TopicoResponse(Long id, String nombre, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<TopicoDTO> getTopicos() {
        return topicos;
    }

    public void setTopicos(Set<TopicoDTO> topicos) {
        this.topicos = topicos;
    }
}
