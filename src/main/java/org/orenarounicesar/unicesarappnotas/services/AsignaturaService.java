package org.orenarounicesar.unicesarappnotas.services;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.models.Asignatura;
import org.orenarounicesar.unicesarappnotas.repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {
    
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> getAsignaturasDocente(int codigoDocente) {
        return asignaturaRepository.getAsignaturasDocente(codigoDocente);
    }

}
