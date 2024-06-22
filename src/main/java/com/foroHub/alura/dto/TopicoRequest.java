package com.foroHub.alura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TopicoRequest {

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    @NotNull(message = "El autor no puede ser nulo")
    private Long autorId;

    @NotNull(message = "El curso no puede ser nulo")
    private Long cursoId;

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

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
