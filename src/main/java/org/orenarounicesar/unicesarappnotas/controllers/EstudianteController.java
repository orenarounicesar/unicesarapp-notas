package org.orenarounicesar.unicesarappnotas.controllers;

import org.orenarounicesar.unicesarappnotas.models.Estudiante;
import org.orenarounicesar.unicesarappnotas.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping()
    public Estudiante getEstudiante(@RequestParam("codigoEstudiante") int codigoEstudiante) {
        return estudianteService.getEstudiante(codigoEstudiante);
    }
}
