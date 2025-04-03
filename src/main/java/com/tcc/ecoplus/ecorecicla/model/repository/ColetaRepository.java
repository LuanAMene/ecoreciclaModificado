package com.tcc.ecoplus.ecorecicla.model.repository;

import com.tcc.ecoplus.ecorecicla.model.entity.Coleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Long> {

    @Query(value = "SELECT * FROM Usuario u WHERE u.cod_status='1'", nativeQuery = true)
    public List<Coleta> findByAllActive();

    @Query(value = "SELECT * FROM Usuario u WHERE u.id=?1 AND u.cod_status='1'", nativeQuery = true)
    public List<Coleta> findByIdActive(Long id);

}
