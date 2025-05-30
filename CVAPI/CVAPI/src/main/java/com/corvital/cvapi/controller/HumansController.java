package com.corvital.cvapi.controller;

import com.corvital.cvapi.model.Humans;
import com.corvital.cvapi.service.HumansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Humans")
public class HumansController {

    @Autowired
    private HumansService humansService;

    @GetMapping()
    public ResponseEntity<List<Humans>> getHumans() {
        List<Humans> humans = humansService.findAll();
        return new ResponseEntity<>(humans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Humans> getById(Long id) {
        Humans human = humansService.buscarHuman(id);
        return human != null ? ResponseEntity.ok(human) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Humans> create(Humans human) {
        Humans savedHuman = humansService.guardarHuman(human);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHuman);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        boolean deleted = humansService.borrarHuman(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
