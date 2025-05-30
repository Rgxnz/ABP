package com.corvital.cvapi.controller;

import com.corvital.cvapi.model.Patients;
import com.corvital.cvapi.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patients")
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @GetMapping()
    public ResponseEntity<List<Patients>> getPatients() {
        List<Patients> patients = patientsService.findAll();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patients> getById(@PathVariable Long id) {
        Patients patient = patientsService.buscarPatient(id);
        return patient != null ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Patients> create(@RequestBody Patients patient) {
        Patients savedPatient = patientsService.guardarPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = patientsService.borrarPatient(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
