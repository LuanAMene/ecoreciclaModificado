package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Destinadora;

import java.util.List;

public interface DestinadoraService {
    Destinadora save(Destinadora destinadora);
    List<Destinadora> findAll();
    Destinadora findById(Long id);
    List<Destinadora> findByResiduo();
    boolean delete(Long id);
}
