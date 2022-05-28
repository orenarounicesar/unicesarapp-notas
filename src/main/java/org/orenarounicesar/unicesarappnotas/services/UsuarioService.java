package org.orenarounicesar.unicesarappnotas.services;

import org.orenarounicesar.unicesarappnotas.models.Usuario;
import org.orenarounicesar.unicesarappnotas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuario(String login, String password) {
        return usuarioRepository.getUsuario(login, password);
    }
}
