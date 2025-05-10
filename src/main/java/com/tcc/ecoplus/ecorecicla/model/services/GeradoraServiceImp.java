package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.exceptions.NotFound;
import com.tcc.ecoplus.ecorecicla.model.entity.Geradora;
import com.tcc.ecoplus.ecorecicla.model.repository.GeradoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeradoraServiceImp implements GeradoraService{

    private final GeradoraRepository geradoraRepository;

    public GeradoraServiceImp(GeradoraRepository geradoraRepository) {
        this.geradoraRepository = geradoraRepository;
    }

    @Override
    public Geradora save(Geradora geradora) {
        geradora.setCodstatus(true);
        if (!geradora.validarGeradora()) {
            throw new BadRequest(geradora.getMensagemErro());
        }
        return geradoraRepository.save(geradora);
    };

    @Override
    public List<Geradora> findAll() {
        return List.of();
    }

    @Override
    public Geradora findById(Long id) {
        try{
            return geradoraRepository.findById(id).get();
        } catch (Exception e){
            throw new NotFound("Geradora não encontrada com o id " + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
