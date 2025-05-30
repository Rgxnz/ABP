package com.corvital.cvapi.service;

import com.corvital.cvapi.model.BloodTypes;
import com.corvital.cvapi.repository.BloodTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodTypesService {

    @Autowired
    private BloodTypesRepository bloodTypesRepository;

    public List<BloodTypes> findAll() {
        return bloodTypesRepository.findAll();
    }
    public BloodTypes buscarBloodType(Long id) {
        return bloodTypesRepository.findById(id).orElse(null);
    }
    public BloodTypes guardarBloodTypes(BloodTypes b) {
        return bloodTypesRepository.save(b);
    }
    public boolean borrarBloodType(Long id) {
        if (bloodTypesRepository.existsById(id)) {
            bloodTypesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
