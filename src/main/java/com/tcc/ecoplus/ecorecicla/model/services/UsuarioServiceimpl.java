package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.model.entity.Usuario;

import java.util.List;

public class UsuarioServiceimpl implements UsuarioService{

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
