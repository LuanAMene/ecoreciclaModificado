package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.RepresentanteColetora;

import java.util.List;

public interface RepresentanteColetoraService {

    RepresentanteColetora save(RepresentanteColetora representanteColetora);
    List<RepresentanteColetora> findAll();
    RepresentanteColetora findById(Long id);
    boolean delete(Long id);
    RepresentanteColetora updateGeradora(Long id, RepresentanteColetora representanteColetora);
}
