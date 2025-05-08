package com.tcc.ecoplus.ecorecicla.model.repository;

import com.tcc.ecoplus.ecorecicla.model.entity.Coleta;
import com.tcc.ecoplus.ecorecicla.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
