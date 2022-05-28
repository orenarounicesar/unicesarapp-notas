package org.orenarounicesar.unicesarappnotas.controllers;

import org.orenarounicesar.unicesarappnotas.models.Usuario;
import org.orenarounicesar.unicesarappnotas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public Usuario getUsuario(@RequestParam("login") String login, @RequestParam("password") String password) {
        return usuarioService.getUsuario(login, password);
    }
}
