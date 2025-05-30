package com.corvital.cvapi.service;

import com.corvital.cvapi.model.Humans;
import com.corvital.cvapi.repository.HumansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumansService {

    @Autowired
    private HumansRepository humansRepository;

    public List<Humans> findAll() {
        return humansRepository.findAll();
    }
    public Humans buscarHuman(Long id) {
        return humansRepository.findById(id).orElse(null);
    }

    public Humans guardarHuman(Humans h) {
        return humansRepository.save(h);
    }

    public boolean borrarHuman(Long id) {
        if (humansRepository.existsById(id)) {
            humansRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
