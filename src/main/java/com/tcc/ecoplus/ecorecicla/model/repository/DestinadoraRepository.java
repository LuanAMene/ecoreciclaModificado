package com.tcc.ecoplus.ecorecicla.model.repository;

import com.tcc.ecoplus.ecorecicla.model.entity.Destinadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DestinadoraRepository extends JpaRepository<Destinadora, Long> {

    @Query("SELECT DISTINCT d FROM Destinadora d " +
            "JOIN d.residuo_destinadoras rd " +
            "JOIN rd.residuo r " +
            "WHERE (:tipo IS NULL OR r.tipo = :tipo) " +
            "AND (:classe IS NULL OR r.classe = :classe)")
    List<Destinadora> findByTipoAndClasse(@Param("tipo") String tipo, @Param("classe") String classe);
}