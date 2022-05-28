package org.orenarounicesar.unicesarappnotas.services;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.repositories.NotaRepository;
import org.orenarounicesar.unicesarappnotas.models.Nota;
import org.orenarounicesar.unicesarappnotas.models.NotaDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotaService {
    
    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getNotasAsignatura(int codigoAsignatura, int codigoCorte) {
        return notaRepository.getNotasAsignatura(codigoAsignatura, codigoCorte);
    }
    
    public int borrarNota(int codigoEstudianteAsignatura, int codigoCorte) {
        return notaRepository.borrarNota(codigoEstudianteAsignatura, codigoCorte);
    }

    public int agregarNota(NotaDatos notaDatos) {
        return notaRepository.agregarNota(notaDatos);
    }
}
