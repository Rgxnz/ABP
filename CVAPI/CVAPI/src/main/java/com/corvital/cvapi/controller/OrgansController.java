package com.corvital.cvapi.controller;

import com.corvital.cvapi.model.Organs;
import com.corvital.cvapi.service.OrgansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Organs")
public class OrgansController {

    @Autowired
    private OrgansService organsService;

    @GetMapping()
    public ResponseEntity<List<Organs>> getOrgans() {
        List<Organs> organs = organsService.findAll();
        return new ResponseEntity<>(organs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organs> getById(@PathVariable Long id) {
        Organs organ = organsService.buscarOrgan(id);
        return organ != null ? ResponseEntity.ok(organ) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Organs> create(@RequestBody Organs organ) {
        Organs savedOrgan = organsService.guardarOrgan(organ);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrgan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = organsService.borrarOrgan(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
