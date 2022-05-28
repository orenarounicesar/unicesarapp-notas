package org.orenarounicesar.unicesarappnotas.services;

import org.orenarounicesar.unicesarappnotas.models.Corte;
import org.orenarounicesar.unicesarappnotas.repositories.CorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorteService {
    
    @Autowired
    private CorteRepository corteRepository;

    public Corte getCorte(int codigoCorte) {
        return corteRepository.getCorte(codigoCorte);
    }
}
