package com.tcc.ecoplus.ecorecicla.model.repository;

import com.tcc.ecoplus.ecorecicla.model.entity.Coleta;
import com.tcc.ecoplus.ecorecicla.model.entity.RepresentanteDestinadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepresentanteDestinadoraRepository extends JpaRepository<RepresentanteDestinadora, Long> {
}