package com.corvital.cvapi.service;

import com.corvital.cvapi.model.Genders;
import com.corvital.cvapi.repository.GendersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GendersService {

    @Autowired
    private GendersRepository gendersRepository;

    public List<Genders> findAll() {
        return gendersRepository.findAll();
    }
    public Genders buscarGender(Long id) {
        return gendersRepository.findById(id).orElse(null);
    }

    public Genders guardarGender(Genders g) {
        return gendersRepository.save(g);
    }

    public boolean borrarGender(Long id) {
        if (gendersRepository.existsById(id)) {
            gendersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
