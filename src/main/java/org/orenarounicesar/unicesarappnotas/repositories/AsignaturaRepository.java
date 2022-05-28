package org.orenarounicesar.unicesarappnotas.repositories;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.models.Asignatura;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AsignaturaRepository {
    
    private JdbcTemplate plantilla;

    public AsignaturaRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }

    public List<Asignatura> getAsignaturasDocente(int codigoDocente) {
        return plantilla.query(
            "SELECT "
                + "a.codigo_asignatura, a.nombre_asignatura "
            + "FROM asignaturas a "
            + "INNER JOIN docentes_asignaturas b ON b.codigo_asignatura = a.codigo_asignatura AND b.codigo_docente = ?", 
            (rs, rowNum) -> new Asignatura(rs.getInt("codigo_asignatura"), rs.getString("nombre_asignatura")),
            codigoDocente
        );
    }
}
