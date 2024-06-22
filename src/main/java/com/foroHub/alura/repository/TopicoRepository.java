package com.foroHub.alura.repository;

import com.foroHub.alura.model.Curso;
import com.foroHub.alura.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findByCurso(Curso curso);

    @Query("SELECT t FROM Topico t WHERE t.curso = ?1 AND YEAR(t.fechaCreacion) = ?2")
    List<Topico> findByCursoAndAnio(String curso, Integer anio);

    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
