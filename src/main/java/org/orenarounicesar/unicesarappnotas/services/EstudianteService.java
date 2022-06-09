package org.orenarounicesar.unicesarappnotas.services;

import org.orenarounicesar.unicesarappnotas.models.Estudiante;
import org.orenarounicesar.unicesarappnotas.models.ResponseString;
import org.orenarounicesar.unicesarappnotas.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
    
    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante getEstudiante(int codigoEstudiate) {
        return estudianteRepository.getEstudiante(codigoEstudiate);
    }

    public ResponseString getEmailEstudiante(int codigoEstudianteAsignatura) {
        return estudianteRepository.getEmailEstudiante(codigoEstudianteAsignatura);
    }
}
