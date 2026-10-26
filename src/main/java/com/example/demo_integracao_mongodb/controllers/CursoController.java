package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Curso;
import com.example.demo_integracao_mongodb.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @GetMapping
    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> buscarPorId(@PathVariable String id) {
        return cursoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable String id, @RequestBody Curso curso) {
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        cursoRepository.deleteById(id);
    }
}