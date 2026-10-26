package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Estudante;
import com.example.demo_integracao_mongodb.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @PostMapping
    public Estudante cadastrar(@RequestBody Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    @GetMapping
    public List<Estudante> buscarTodos() {
        return estudanteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudante> buscarPorId(@PathVariable String id) {
        return estudanteRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Estudante atualizar(@PathVariable String id, @RequestBody Estudante estudante) {
        estudante.setId(id);
        return estudanteRepository.save(estudante);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        estudanteRepository.deleteById(id);
    }
}