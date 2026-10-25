package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Estudante;
import com.example.demo_integracao_mongodb.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteRepository estudanteRepository;

    @PostMapping
    public void gravar(Estudante estudante) {
        this.estudanteRepository.save(estudante);
    }
}
