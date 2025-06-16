package com.tcc.ecoplus.ecorecicla.model.services;


import com.tcc.ecoplus.ecorecicla.exceptions.NotFound;
import com.tcc.ecoplus.ecorecicla.model.entity.RepresentanteColetora;
import com.tcc.ecoplus.ecorecicla.model.repository.RepresentanteColetoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentanteColetoraServiceImpl implements RepresentanteColetoraService {

    private final RepresentanteColetoraRepository representanteColetoraRepository;

    public RepresentanteColetoraServiceImpl (RepresentanteColetoraRepository representanteColetoraRepository) {
        this.representanteColetoraRepository = representanteColetoraRepository;
    }


    @Override
    public RepresentanteColetora save(RepresentanteColetora representanteColetora) {
        return null;
    }

    @Override
    public List<RepresentanteColetora> findAll() {
        return List.of();
    }

    @Override
    public RepresentanteColetora findById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public RepresentanteColetora updateGeradora(Long id, RepresentanteColetora representanteColetora) {

        if (!representanteColetoraRepository.existsById(id)) {
            throw new NotFound("Usuário não encontrado com o id " + id);
        }
        RepresentanteColetora representanteColetoraDb = representanteColetoraRepository.findById(id).get();
        representanteColetoraDb.setGeradora(representanteColetora.getGeradora());

        return representanteColetoraRepository.save(representanteColetoraDb);
    }
}
