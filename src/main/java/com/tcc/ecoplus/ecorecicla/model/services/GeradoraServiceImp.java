package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.exceptions.NotFound;
import com.tcc.ecoplus.ecorecicla.model.entity.Geradora;
import com.tcc.ecoplus.ecorecicla.model.entity.RepresentanteColetora;
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
        geradora.setCodStatus(true);
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

    @Override
    public Geradora update(Long id, Geradora geradora) {
        if (!geradoraRepository.existsById(id)) {
            throw new NotFound("Geradora não encontrada com o id " + id);
        }
        Geradora geradoraDb = geradoraRepository.findById(id).get();
        geradoraDb.setLogradouro(geradora.getLogradouro());
        geradoraDb.setCep(geradora.getCep());
        geradoraDb.setCidade(geradora.getCidade());
        geradoraDb.setCep(geradora.getCep());
        geradoraDb.setBairro(geradora.getBairro());
        geradoraDb.setUf(geradora.getUf());
        geradoraDb.setNum(geradora.getNum());
        geradoraDb.setTelefone(geradora.getTelefone());

        return geradoraRepository.save(geradoraDb);
    }

    @Override
    public List<Geradora> findByCnpj(String cnpj) {
        return geradoraRepository.findByCnpj(cnpj);
    }
}
