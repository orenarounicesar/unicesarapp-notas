package org.orenarounicesar.unicesarappnotas.controllers;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.models.Asignatura;
import org.orenarounicesar.unicesarappnotas.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    
    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping()
    public List<Asignatura> getAsignaturasDocente(@RequestParam("codigoDocente") int codigoDocente) {
        return asignaturaService.getAsignaturasDocente(codigoDocente);
    }
}
