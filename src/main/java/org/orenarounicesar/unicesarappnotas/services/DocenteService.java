package org.orenarounicesar.unicesarappnotas.services;

import org.orenarounicesar.unicesarappnotas.models.ResponseString;
import org.orenarounicesar.unicesarappnotas.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteService {
    
    @Autowired
    private DocenteRepository docenteRepository;

    public ResponseString getNombreDocente(int codigoDocente) {
        return docenteRepository.getNombreDocente(codigoDocente);
    }
}
