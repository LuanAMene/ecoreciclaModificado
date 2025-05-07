package com.tcc.ecoplus.ecorecicla.model.services;

import com.itb.mif3an.pizzariabomgosto.exceptions.BadRequest;
import com.itb.mif3an.pizzariabomgosto.exceptions.NotFound;
import com.tcc.ecoplus.ecorecicla.model.entity.Destinadora;
import com.tcc.ecoplus.ecorecicla.model.repository.DestinadoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinadoraServiceImp implements DestinadoraService{

    private final DestinadoraRepository destinadoraRepository;

    public DestinadoraServiceImp(DestinadoraRepository destinadoraRepository) { this.destinadoraRepository = destinadoraRepository; }

    @Override
    public Destinadora save(Destinadora destinadora) {
        destinadora.setCodstatus(true);
        if (!destinadora.validarDestinadora()){
            throw new BadRequest(destinadora.getMensagemErro());
        }
        return destinadoraRepository.save(destinadora);
    }

    @Override
    public List findAll() {
        return destinadoraRepository.findAll();
    }

    @Override
    public Destinadora findById(Long id) {
        try{
            Destinadora destinadora = destinadoraRepository.findById(id).get();
            return destinadora;
        } catch (Exception e){
            throw new NotFound("Destinadora não encontrada com o id " + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
