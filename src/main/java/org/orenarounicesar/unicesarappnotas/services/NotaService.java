package org.orenarounicesar.unicesarappnotas.services;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.repositories.NotaRepository;
import org.orenarounicesar.unicesarappnotas.models.Nota;
import org.orenarounicesar.unicesarappnotas.models.NotaDatos;
import org.orenarounicesar.unicesarappnotas.models.ResponseBoolean;
import org.orenarounicesar.unicesarappnotas.models.ResponseInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotaService {
    
    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getNotasAsignatura(int codigoAsignatura, int codigoCorte) {
        return notaRepository.getNotasAsignatura(codigoAsignatura, codigoCorte);
    }
    
    public ResponseInt borrarNota(int codigoEstudianteAsignatura, int codigoCorte) {
        return notaRepository.borrarNota(codigoEstudianteAsignatura, codigoCorte);
    }

    public ResponseInt agregarNota(NotaDatos notaDatos) {
        return notaRepository.agregarNota(notaDatos);
    }

    public ResponseBoolean isNotaAlmacenada(int codigoEstudianteAsignatura, int codigoCorte) {
        return notaRepository.isNotaAlmacenada(codigoEstudianteAsignatura, codigoCorte);
    }

    public ResponseBoolean isNotaPublicada(int codigoEstudianteAsignatura, int codigoCorte) {
        return notaRepository.isNotaPublicada(codigoEstudianteAsignatura, codigoCorte);
    }

    public ResponseInt publicarNota(NotaDatos notaDatos) {
        return notaRepository.publicarNota(notaDatos);
    }
}
