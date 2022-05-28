package org.orenarounicesar.unicesarappnotas.repositories;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.models.Nota;
import org.orenarounicesar.unicesarappnotas.models.NotaDatos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NotaRepository {
    
    private JdbcTemplate plantilla;

    public NotaRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }

    public List<Nota> getNotasAsignatura(int codigoAsignatura, int codigoCorte) {
        return plantilla.query(
            "SELECT "
                + "c.codigo_estudiante_asignatura, "
                + "b.codigo_universitario, "
                + "CONCAT_WS(' ',a.apellido1,a.apellido2,a.nombre1,a.nombre2) AS nombre_estudiante, "
                + "CONCAT_WS(' - ',a.tipo_id, id) AS identificacion, "
                + "d.nota, "
                + "d.publicada "
            + "FROM datos_personales a "
            + "INNER JOIN estudiantes b ON b.codigo_dato_personal = a.codigo_dato_personal "
            + "INNER JOIN estudiantes_asignaturas c ON c.codigo_estudiante = b.codigo_estudiante AND c.codigo_asignatura = ? "
            + "LEFT JOIN notas d ON d.codigo_estudiante_asignatura = c.codigo_estudiante_asignatura AND d.codigo_corte = ? "
            + "ORDER BY nombre_estudiante", 
            (rs, rowNum) -> new Nota(
                rs.getInt("codigo_estudiante_asignatura"), 
                rs.getString("codigo_universitario"), 
                rs.getString("nombre_estudiante"), 
                rs.getString("identificacion"), 
                rs.getFloat("nota"), 
                rs.getBoolean("publicada")
            ),
            new Object[]{codigoAsignatura, codigoCorte}
        );
    }

    public int borrarNota(int codigoEstudianteAsignatura, int codigoCorte) {
        return plantilla.update(
            "DELETE FROM notas "
            + "WHERE codigo_estudiante_asignatura = ? AND codigo_corte = ?", 
            codigoEstudianteAsignatura,
            codigoCorte
        );
    }

    public int agregarNota(NotaDatos notaDatos) {
        return plantilla.update(
            "INSERT INTO notas ("
                + "codigo_estudiante_asignatura, "
                + "codigo_corte, "
                + "nota"
            + ") VALUES (?, ?, ?) " 
            + "ON DUPLICATE KEY UPDATE "
                + "nota = ?", 
            notaDatos.getCodigoEstudianteAsignatura(),
            notaDatos.getCodigoCorte(),
            notaDatos.getNota(),
            notaDatos.getNota()
        );
    }
}
