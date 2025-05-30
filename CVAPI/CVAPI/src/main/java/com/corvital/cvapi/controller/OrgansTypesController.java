package com.corvital.cvapi.controller;

import com.corvital.cvapi.model.OrgansTypes;
import com.corvital.cvapi.service.OrgansTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrgansTypes")
public class OrgansTypesController {

    @Autowired
    private OrgansTypesService organsTypesService;

    @GetMapping()
    public ResponseEntity<List<OrgansTypes>> getOrgansTypes() {
        List<OrgansTypes> organsTypes = organsTypesService.findAll();
        return new ResponseEntity<>(organsTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgansTypes> getById(@PathVariable Long id) {
        OrgansTypes ot = organsTypesService.buscarOrgansType(id);
        return ot != null ? ResponseEntity.ok(ot) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrgansTypes> create(@RequestBody OrgansTypes ot) {
        OrgansTypes savedOT = organsTypesService.guardarOrgansType(ot);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = organsTypesService.borrarOrgansType(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
