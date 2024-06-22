package com.foroHub.alura.controller;


import com.foroHub.alura.model.Topico;
import com.foroHub.alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@Valid @RequestBody Topico topico) {
        if (topicoRepository.existsByTituloAndMensaje(topico.getTitulo(), topico.getMensaje())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Topico nuevoTopico = topicoRepository.save(topico);
        return new ResponseEntity<>(nuevoTopico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos(
            @RequestParam(required = false) String curso,
            @RequestParam(required = false) Integer anio) {
        if (curso != null && anio != null) {
            List<Topico> topicos = topicoRepository.findByCursoAndAnio(curso, anio);
            if (topicos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(topicos, HttpStatus.OK);
        }
        List<Topico> topicos = topicoRepository.findAll();
        if (topicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(topicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (!topicoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(topicoOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico topicoActualizado) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (!topicoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        topicoActualizado.setId(id);
        Topico topicoGuardado = topicoRepository.save(topicoActualizado);
        return new ResponseEntity<>(topicoGuardado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        topicoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
