package com.tcc.ecoplus.ecorecicla.model.services;

import com.itb.mif3an.pizzariabomgosto.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.exceptions.NotFound;
import com.tcc.ecoplus.ecorecicla.model.entity.Residuo;
import com.tcc.ecoplus.ecorecicla.model.repository.ResiduoRepository;

import java.util.List;

public class ResiduoServiceImp implements ResiduoService {

    private final ResiduoRepository residuoRepository;

    public ResiduoServiceImp(ResiduoRepository residuoRepository) {
        this.residuoRepository = residuoRepository;
    }

    @Override
    public Residuo save(Residuo residuo) {
        residuo.setCodstatus(true);
        if(!residuo.validarResiduo()) {
            throw new BadRequest(residuo.getMensagemErro());
        }
        return residuoRepository.save(residuo);
    }

    @Override
    public List<Residuo> findAll() {
        return residuoRepository.findAll();
    }

    @Override
    public Residuo findById(Long id) {
        try{
            Residuo residuo = residuoRepository.findById(id).get();
            return residuo;
        } catch (Exception e) {
            throw new NotFound("Residuo não encontrado pelo id " + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
