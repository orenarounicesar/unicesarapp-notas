package org.orenarounicesar.unicesarappnotas.controllers;

import org.orenarounicesar.unicesarappnotas.models.Corte;
import org.orenarounicesar.unicesarappnotas.services.CorteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cortes")
public class CorteController {
    
    @Autowired
    private CorteService corteService;

    @GetMapping()
    public Corte getCorte(@RequestParam("codigoCorte") int codigoCorte) {
        return corteService.getCorte(codigoCorte);
    }
}
