package com.corvital.cvapi.controller;

import com.corvital.cvapi.model.Genders;
import com.corvital.cvapi.service.GendersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Genders")
public class GendersController {

    @Autowired
    private GendersService genderService;

    @GetMapping()
    public ResponseEntity<List<Genders>> getGenders() {
        List<Genders> genders = genderService.findAll();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genders> getById(@PathVariable Long id) {
        Genders gender = genderService.buscarGender(id);
        return gender != null ? ResponseEntity.ok(gender) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Genders> create(@RequestBody Genders gender) {
        Genders savedGender = genderService.guardarGender(gender);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGender);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = genderService.borrarGender(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
