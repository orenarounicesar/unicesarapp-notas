package org.orenarounicesar.unicesarappnotas.controllers;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.models.Nota;
import org.orenarounicesar.unicesarappnotas.models.NotaDatos;
import org.orenarounicesar.unicesarappnotas.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notas")
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @GetMapping()
    public List<Nota> getNotasAsignatura(@RequestParam("codigoAsignatura") int codigoAsignatura, @RequestParam("codigoCorte") int codigoCorte) {
        return notaService.getNotasAsignatura(codigoAsignatura, codigoCorte);
    }

    @GetMapping("/almacenada")
    public boolean isNotaAlmacenada(@RequestParam("codigoEstudianteAsignatura") int codigoEstudianteAsignatura, @RequestParam("codigoCorte") int codigoCorte) {
        return notaService.isNotaAlmacenada(codigoEstudianteAsignatura, codigoCorte);
    }

    @GetMapping("/publicada")
    public boolean isNotaPublicada(@RequestParam("codigoEstudianteAsignatura") int codigoEstudianteAsignatura, @RequestParam("codigoCorte") int codigoCorte) {
        return notaService.isNotaPublicada(codigoEstudianteAsignatura, codigoCorte);
    }

    @DeleteMapping
    public int borrarNota(@RequestParam("codigoEstudianteAsignatura") int codigoEstudianteAsignatura, @RequestParam("codigoCorte") int codigoCorte) {
        return notaService.borrarNota(codigoEstudianteAsignatura, codigoCorte);
    }

    @PostMapping
    public int agregarNota(@RequestBody NotaDatos notaDatos) {
        return notaService.agregarNota(notaDatos);
    }

    @PostMapping("/publicar")
    public int publicarNota(@RequestParam("codigoEstudianteAsignatura") int codigoEstudianteAsignatura, @RequestParam("codigoCorte") int codigoCorte) {
        return notaService.publicarNota(codigoEstudianteAsignatura, codigoCorte);
    }
}
