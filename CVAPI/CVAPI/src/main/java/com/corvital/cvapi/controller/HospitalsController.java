package com.corvital.cvapi.controller;

import com.corvital.cvapi.model.Hospitals;
import com.corvital.cvapi.service.HospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hospitals")
public class HospitalsController {

    @Autowired
    private HospitalsService hospitalsService;

    @GetMapping()
    public ResponseEntity<List<Hospitals>> getHospitals() {
        List<Hospitals> hospitals = hospitalsService.findAll();
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospitals> getById(@PathVariable Long id) {
        Hospitals hospital = hospitalsService.buscarHospital(id);
        return hospital != null ? ResponseEntity.ok(hospital) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Hospitals> create(@RequestBody Hospitals hospital) {
        Hospitals savedHospital = hospitalsService.guardarHospital(hospital);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHospital);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = hospitalsService.borrarHospital(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
