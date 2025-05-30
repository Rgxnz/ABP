package com.corvital.cvapi.service;

import com.corvital.cvapi.model.Donors;
import com.corvital.cvapi.repository.DonorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorsService {

    @Autowired
    private DonorsRepository donorsRepository;

    public List<Donors> findAll() {
        return donorsRepository.findAll();
    }
    public Donors buscarDonor(Long id) {
        return donorsRepository.findById(id).orElse(null);
    }

    public Donors guardarDonor(Donors d) {
        return donorsRepository.save(d);
    }

    public boolean borrarDonor(Long id) {
        if (donorsRepository.existsById(id)) {
            donorsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
