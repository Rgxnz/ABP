package com.corvital.cvapi.controller;

import com.corvital.cvapi.model.BloodTypes;
import com.corvital.cvapi.service.BloodTypesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BloodTypes")
public class BloodTypesController {
    private BloodTypesService bloodTypesService;

    @GetMapping()
    public ResponseEntity<List<BloodTypes>> getBloodTypes() {
        List<BloodTypes> bloodTypes = bloodTypesService.findAll();
        return new ResponseEntity<>(bloodTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodTypes> getById(@PathVariable Long id) {
        BloodTypes type = bloodTypesService.buscarBloodType(id);
        return type != null ? ResponseEntity.ok(type) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BloodTypes> create(@RequestBody BloodTypes bloodType) {
        BloodTypes savedType = bloodTypesService.guardarBloodTypes(bloodType);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = bloodTypesService.borrarBloodType(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
