package org.orenarounicesar.unicesarappnotas.controllers;

import java.util.logging.Logger;

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
        System.out.println("Entró al microservicio");
        Logger.getLogger("Entró al microservicio");
        return usuarioService.getUsuario(login, password);
    }
}
