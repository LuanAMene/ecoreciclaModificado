package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.RepresentanteDestinadora;

import java.util.List;

public interface RepresentanteDestinadoraService {
    RepresentanteDestinadora save(RepresentanteDestinadora representanteDestinadora);
    List<RepresentanteDestinadora> findAll();
    RepresentanteDestinadora findById(Long id);
    boolean delete(Long id);


}
