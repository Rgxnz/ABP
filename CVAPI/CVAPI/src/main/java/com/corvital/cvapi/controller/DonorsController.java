package com.corvital.cvapi.controller;

import com.corvital.cvapi.model.Donors;
import com.corvital.cvapi.service.DonorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Donors")
public class DonorsController {
    private DonorsService donorsService;

    @GetMapping()
    public ResponseEntity<List<Donors>> getDonors() {
        List<Donors> Donors = donorsService.findAll();
        return new ResponseEntity<>(Donors, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Donors> getById(@PathVariable Long id) {
        Donors donor = donorsService.buscarDonor(id);
        return donor != null ?
                ResponseEntity.ok(donor) :
                ResponseEntity.notFound().build();
    }

    // Crear nuevo
    @PostMapping()
    public ResponseEntity<Donors> create(@RequestBody Donors donor) {
        Donors savedDonor = donorsService.guardarDonor(donor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDonor);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = donorsService.borrarDonor(id);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
