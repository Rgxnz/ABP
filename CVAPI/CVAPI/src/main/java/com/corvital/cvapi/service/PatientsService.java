package com.corvital.cvapi.service;

import com.corvital.cvapi.model.Patients;
import com.corvital.cvapi.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsService {

    @Autowired
    private PatientsRepository patientsRepository;

    public List<Patients> findAll() {
        return patientsRepository.findAll();
    }
    public Patients buscarPatient(Long id) {
        return patientsRepository.findById(id).orElse(null);
    }

    public Patients guardarPatient(Patients p) {
        return patientsRepository.save(p);
    }

    public boolean borrarPatient(Long id) {
        if (patientsRepository.existsById(id)) {
            patientsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
