package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.exceptions.NotFound;
import com.tcc.ecoplus.ecorecicla.model.entity.Residuo_Destinadora;
import com.tcc.ecoplus.ecorecicla.model.repository.ResiduoDestinadoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResiduoDestinadoraServiceImp implements ResiduoDestinadoraService{

    private final ResiduoDestinadoraRepository residuoDestinadoraRepository;

    public ResiduoDestinadoraServiceImp(ResiduoDestinadoraRepository residuoDestinadoraRepository) {
        this.residuoDestinadoraRepository = residuoDestinadoraRepository;
    }

    @Override
    public Residuo_Destinadora save(Residuo_Destinadora residuo_Destinadora) {
        residuo_Destinadora.setCodstatus(true);
        if (!residuo_Destinadora.validarResiduo_destinadora()) {
            throw new BadRequest(residuo_Destinadora.getMensagemErro());
        }
        return residuoDestinadoraRepository.save(residuo_Destinadora);
    };

    @Override
    public List<Residuo_Destinadora> findAll() {
        return residuoDestinadoraRepository.findAll();
    }

    @Override
    public Residuo_Destinadora findById(Long id) {
        return residuoDestinadoraRepository.findById(id)
                .orElseThrow(() -> new NotFound("Residuo não aceito pela destinadora com id " + id));
    }


    @Override
    public boolean delete(Long id) {
        return false;
    }
}
