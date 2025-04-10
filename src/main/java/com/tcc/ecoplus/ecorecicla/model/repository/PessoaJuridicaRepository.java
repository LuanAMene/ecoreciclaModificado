package com.tcc.ecoplus.ecorecicla.model.repository;

import com.tcc.ecoplus.ecorecicla.model.entity.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

   @Query(value = "SELECT FROM PessoaJuridica P WHERE P.id ", nativeQuery = true)
    public List<PessoaJuridica> findByPessoaId();
}
