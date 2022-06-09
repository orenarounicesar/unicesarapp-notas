package org.orenarounicesar.unicesarappnotas.controllers;

import org.orenarounicesar.unicesarappnotas.models.ResponseString;
import org.orenarounicesar.unicesarappnotas.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docentes")
public class DocenteController {
    
    @Autowired
    private DocenteService docenteService;

    @GetMapping()
    public ResponseString getDocente(@RequestParam("codigoDocente") int codigoDocente) {
        return docenteService.getNombreDocente(codigoDocente);
    }

}
