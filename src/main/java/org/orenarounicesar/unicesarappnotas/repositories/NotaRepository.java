package org.orenarounicesar.unicesarappnotas.repositories;

import java.util.List;

import org.orenarounicesar.unicesarappnotas.models.Nota;
import org.orenarounicesar.unicesarappnotas.models.NotaDatos;
import org.orenarounicesar.unicesarappnotas.models.NotaEstudiante;
import org.orenarounicesar.unicesarappnotas.models.ResponseBoolean;
import org.orenarounicesar.unicesarappnotas.models.ResponseInt;
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

    public ResponseInt borrarNota(int codigoEstudianteAsignatura, int codigoCorte) {
        return new ResponseInt(
            plantilla.update(
                "DELETE FROM notas "
                + "WHERE codigo_estudiante_asignatura = ? AND codigo_corte = ?", 
                codigoEstudianteAsignatura,
                codigoCorte
            )
        );
    }

    public ResponseInt agregarNota(NotaDatos notaDatos) {
        return new ResponseInt(
            plantilla.update(
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
            )
        );
    }

    public ResponseBoolean isNotaAlmacenada(int codigoEstudianteAsignatura, int codigoCorte) {
        return new ResponseBoolean(
            plantilla.queryForObject(
                "SELECT COUNT(*) AS cantidad "
                    + "FROM notas a "
                    + "WHERE a.codigo_estudiante_asignatura = ? AND a.codigo_corte = ?", 
                Boolean.class,
                new Object[]{codigoEstudianteAsignatura, codigoCorte}
            )
        );
    }

    public ResponseBoolean isNotaPublicada(int codigoEstudianteAsignatura, int codigoCorte) {
        return new ResponseBoolean(
            plantilla.queryForObject(
                "SELECT a.publicada "
                    + "FROM notas a "
                    + "WHERE a.codigo_estudiante_asignatura = ? AND a.codigo_corte = ?", 
                Boolean.class,
                new Object[]{codigoEstudianteAsignatura, codigoCorte}
            )
        );
    }

    // public int publicarNota(int codigoEstudianteAsignatura, int codigoCorte) {
    //     return plantilla.update(
    //         "UPDATE notas a "
    //             + "SET a.publicada = 1 "
    //             + "WHERE a.codigo_estudiante_asignatura = ? AND a.codigo_corte = ?", 
    //         codigoEstudianteAsignatura,
    //         codigoCorte
    //     );
    // }


    public ResponseInt publicarNota(NotaDatos notaDatos) {
        return new ResponseInt(
            plantilla.update(
                "UPDATE notas a "
                    + "SET a.publicada = 1 "
                    + "WHERE a.codigo_estudiante_asignatura = ? AND a.codigo_corte = ?", 
                notaDatos.getCodigoEstudianteAsignatura(),
                notaDatos.getCodigoCorte()
            )
        );
    }

    public List<NotaEstudiante> getNotaEstudiante(int codigoEstudiante) {
        return plantilla.query(
            "SELECT "
                + "c.codigo_estudiante_asignatura, e.nombre_corte, a.codigo_asignatura, a.nombre_asignatura, d.nota "
            + "FROM asignaturas a "
            + "INNER JOIN docentes_asignaturas b ON b.codigo_asignatura = a.codigo_asignatura "
            + "INNER JOIN estudiantes_asignaturas c ON c.codigo_asignatura = a.codigo_asignatura AND c.codigo_estudiante = ? "
            + "INNER JOIN notas d ON d.codigo_estudiante_asignatura = c.codigo_estudiante_asignatura AND d.publicada = 1 "
            + "INNER JOIN cortes e ON e.codigo_corte = d.codigo_corte", 
            (rs, rowNum) -> new NotaEstudiante(
                rs.getInt("codigo_estudiante_asignatura"), 
                rs.getString("nombre_corte"), 
                rs.getInt("codigo_asignatura"), 
                rs.getString("nombre_asignatura"), 
                rs.getFloat("nota")
            ),
            codigoEstudiante
        );
    }
}
