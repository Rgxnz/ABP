package com.corvital.cvapi.service;

import com.corvital.cvapi.model.Organs;
import com.corvital.cvapi.repository.OrgansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgansService {
    @Autowired
    private OrgansRepository organsRepository;

    public List<Organs> findAll() {
        return organsRepository.findAll();
    }
    public Organs buscarOrgan(Long id) {
        return organsRepository.findById(id).orElse(null);
    }

    public Organs guardarOrgan(Organs o) {
        return organsRepository.save(o);
    }

    public boolean borrarOrgan(Long id) {
        if (organsRepository.existsById(id)) {
            organsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
