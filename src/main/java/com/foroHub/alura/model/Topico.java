package com.foroHub.alura.model;

import com.foroHub.alura.dto.TopicoResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    @NotNull(message = "El autor no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @NotNull(message = "El curso no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDateTime fechaCreacion;

    public Topico() {
    }

    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.fechaCreacion = LocalDateTime.now();
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

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setCurso(TopicoResponse curso) {
    }
}
