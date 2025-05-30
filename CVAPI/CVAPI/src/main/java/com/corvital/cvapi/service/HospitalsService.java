package com.corvital.cvapi.service;

import com.corvital.cvapi.model.Hospitals;
import com.corvital.cvapi.repository.HospitalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalsService {

    @Autowired
    private HospitalsRepository repository;

    public List<Hospitals> findAll() {
        return repository.findAll();
    }
    public Hospitals buscarHospital(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Hospitals guardarHospital(Hospitals h) {
        return repository.save(h);
    }

    public boolean borrarHospital(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

