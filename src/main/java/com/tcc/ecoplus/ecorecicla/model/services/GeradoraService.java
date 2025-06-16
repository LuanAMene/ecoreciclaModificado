package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Geradora;

import java.util.List;

public interface GeradoraService {
    Geradora save(Geradora geradora);
    List<Geradora> findAll();
    Geradora findById(Long id);
    boolean delete(Long id);
    Geradora update(Long id, Geradora geradora);
    List<Geradora> findByCnpj(String cnpj);
}
