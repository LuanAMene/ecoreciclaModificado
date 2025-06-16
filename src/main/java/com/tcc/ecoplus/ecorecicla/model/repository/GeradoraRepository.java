package com.tcc.ecoplus.ecorecicla.model.repository;


import com.tcc.ecoplus.ecorecicla.model.entity.Geradora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GeradoraRepository extends JpaRepository<Geradora, Long> {


    @Query(value = "SELECT * FROM geradora g WHERE g.cnpj=?1", nativeQuery = true)
    List<Geradora> findByCnpj(String cnpj);

}