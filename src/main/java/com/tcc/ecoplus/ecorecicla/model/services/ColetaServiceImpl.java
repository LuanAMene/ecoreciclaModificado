package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.exceptions.NotFound;
import com.tcc.ecoplus.ecorecicla.model.entity.Coleta;
import com.tcc.ecoplus.ecorecicla.model.repository.ColetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColetaServiceImpl implements ColetaService {

    private final ColetaRepository coletaRepository;

    public ColetaServiceImpl(ColetaRepository coletaRepository) {
        this.coletaRepository = coletaRepository;
    }

    @Override
    public Coleta save(Coleta coleta) {
        coleta.setCodstatus(true);
        if(!coleta.validarColeta()) {
            throw new BadRequest(coleta.getMensagemErro());
        }
        if(coleta.getGeradora() == null) {
            throw new BadRequest(coleta.getMensagemErro());
        }
        return coletaRepository.save(coleta);
    }

    @Override
    public List findAll() {
        return coletaRepository.findAll();
    }

    @Override
    public Coleta findById(Long id) {
        try {
            Coleta coleta = coletaRepository.findById(id).get();
            return coleta;
        } catch (Exception e) {
            throw new NotFound("Coleta não encontrada com o id " + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
