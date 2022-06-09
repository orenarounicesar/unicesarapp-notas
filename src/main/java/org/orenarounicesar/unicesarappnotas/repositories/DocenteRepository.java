package org.orenarounicesar.unicesarappnotas.repositories;

import org.orenarounicesar.unicesarappnotas.models.ResponseString;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DocenteRepository {
    
    private JdbcTemplate plantilla;

    public DocenteRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }

    public ResponseString getNombreDocente(int codigoDocente) { 
        return new ResponseString(
            plantilla.queryForObject(
                "SELECT "
                    + "CONCAT_WS(' ',a.nombre1, a.nombre2, a.apellido1, a.apellido2) AS nombre_docente "
                + "FROM datos_personales a "
                + "INNER JOIN docentes b ON b.codigo_dato_personal = a.codigo_dato_personal AND b.codigo_docente = ?", 
                String.class,
                codigoDocente
            )
        );
    }
}
