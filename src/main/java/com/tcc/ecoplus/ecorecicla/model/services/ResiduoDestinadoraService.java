package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Residuo_Destinadora;

import java.util.List;

public interface ResiduoDestinadoraService {
    Residuo_Destinadora save(Residuo_Destinadora residuo_Destinadora);
    List<Residuo_Destinadora> findAll();
    Residuo_Destinadora findById(Long id);
    boolean delete(Long id);
}
