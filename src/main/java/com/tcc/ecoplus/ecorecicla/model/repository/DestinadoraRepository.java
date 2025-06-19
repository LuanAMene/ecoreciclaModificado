package com.tcc.ecoplus.ecorecicla.model.repository;

import com.tcc.ecoplus.ecorecicla.model.entity.Destinadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DestinadoraRepository extends JpaRepository<Destinadora, Long> {

    @Query(value = "SELECT d.nome, r.tipo, r.classe FROM Destinadora d " +
           "JOIN Residuo_Destinadora rd ON d.id = rd.destinadora.id " +
           "JOIN Residuo r ON rd.residuo.id = r.id")
   public List<Destinadora> findByResiduo();
}