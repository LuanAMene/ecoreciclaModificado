package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Usuario findByEmail(String email);
    List<Usuario> findAll();
    Usuario findById(Long id);
    boolean delete(Long id);
    Usuario update(Long id, Usuario usuario);

}
