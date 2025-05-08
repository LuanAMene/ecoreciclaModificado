package com.tcc.ecoplus.ecorecicla.model.services;

import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.exceptions.NotFound;
import com.tcc.ecoplus.ecorecicla.model.entity.Usuario;
import com.tcc.ecoplus.ecorecicla.model.repository.UsuarioRepository;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public class UsuarioServiceimpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceimpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setCodstatus(true);
        if(!usuario.validarUsuario()) {
            throw new BadRequest(usuario.getMensagemErro());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        try {
            Usuario usuario = usuarioRepository.findById(id).get();
            return usuario;
        } catch (Exception e) {
            throw new NotFound("Usuario não encotrado pelo id "+ id);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
