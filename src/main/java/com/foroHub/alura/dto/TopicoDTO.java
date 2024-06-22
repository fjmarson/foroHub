package com.foroHub.alura.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class TopicoDTO {

    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    private String autor;

    private String curso;

    private LocalDateTime fechaCreacion;

    public TopicoDTO() {
    }

    public TopicoDTO(Long id, String titulo, String mensaje, String autor, String curso, LocalDateTime fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
