package com.corvital.cvapi.service;

import com.corvital.cvapi.model.OrgansTypes;
import com.corvital.cvapi.repository.OrgansTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgansTypesService {

    @Autowired
    private OrgansTypesRepository organsTypesRepository;

    public List<OrgansTypes> findAll() {
        return organsTypesRepository.findAll();
    }
    public OrgansTypes buscarOrgansType(Long id) {
        return organsTypesRepository.findById(id).orElse(null);
    }

    public OrgansTypes guardarOrgansType(OrgansTypes ot) {
        return organsTypesRepository.save(ot);
    }

    public boolean borrarOrgansType(Long id) {
        if (organsTypesRepository.existsById(id)) {
            organsTypesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
