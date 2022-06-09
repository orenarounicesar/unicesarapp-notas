package org.orenarounicesar.unicesarappnotas.controllers;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.models.Nota;
import org.orenarounicesar.unicesarappnotas.models.NotaDatos;
import org.orenarounicesar.unicesarappnotas.models.ResponseBoolean;
import org.orenarounicesar.unicesarappnotas.models.ResponseInt;
import org.orenarounicesar.unicesarappnotas.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseBoolean isNotaAlmacenada(@RequestParam("codigoEstudianteAsignatura") int codigoEstudianteAsignatura, @RequestParam("codigoCorte") int codigoCorte) {
        return notaService.isNotaAlmacenada(codigoEstudianteAsignatura, codigoCorte);
    }

    @GetMapping("/publicada")
    public ResponseBoolean isNotaPublicada(@RequestParam("codigoEstudianteAsignatura") int codigoEstudianteAsignatura, @RequestParam("codigoCorte") int codigoCorte) {
        return notaService.isNotaPublicada(codigoEstudianteAsignatura, codigoCorte);
    }

    @DeleteMapping
    public ResponseInt borrarNota(@RequestParam("codigoEstudianteAsignatura") int codigoEstudianteAsignatura, @RequestParam("codigoCorte") int codigoCorte) {
        return notaService.borrarNota(codigoEstudianteAsignatura, codigoCorte);
    }

    @PostMapping
    public ResponseInt agregarNota(@RequestBody NotaDatos notaDatos) {
        return notaService.agregarNota(notaDatos);
    }

    @PutMapping("/publicar")
    public ResponseInt publicarNota(@RequestBody NotaDatos notaDatos) {
        return notaService.publicarNota(notaDatos);
    }
}
