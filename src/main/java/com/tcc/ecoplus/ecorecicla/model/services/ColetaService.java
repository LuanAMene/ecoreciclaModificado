package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Coleta;

import java.util.List;

public interface ColetaService {

    public Coleta save(Coleta coleta);
    public List<Coleta> findAll();
    public Coleta findById(Long id);
    public boolean delete(Long id);


}
