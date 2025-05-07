package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Residuo;

import java.util.List;

public interface ResiduoService {

        Residuo save(Residuo residuo);
        List<Residuo> findAll();
        Residuo findById(Long id);
        boolean delete(Long id);
    }

