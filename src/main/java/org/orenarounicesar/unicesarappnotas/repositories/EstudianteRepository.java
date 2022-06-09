package org.orenarounicesar.unicesarappnotas.repositories;

import org.orenarounicesar.unicesarappnotas.models.Estudiante;
import org.orenarounicesar.unicesarappnotas.models.ResponseString;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EstudianteRepository {
    
    private JdbcTemplate plantilla;

    public EstudianteRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }
    
    public Estudiante getEstudiante(int codigoEstudiate) {
        try {
            return plantilla.queryForObject(
                "SELECT "
                    + "a.codigo_estudiante, "
                    + "a.codigo_estudiante, "
                    + "b.tipo_id, "
                    + "b.id, "
                    + "b.nombre1, "
                    + "b.nombre2, "
                    + "b.apellido1, "
                    + "b.apellido2, "
                    + "b.fecha_nacimiento, "
                    + "b.direccion, "
                    + "b.telefono, "
                    + "b.email "
                + "FROM estudiantes a " 
                + "INNER JOIN datos_personales b ON b.codigo_dato_personal = a.codigo_dato_personal " 
                + "WHERE a.codigo_estudiante = ? " 
                + "LIMIT 1", 
                (rs, rowNum) -> new Estudiante(
                    rs.getInt("codigo_estudiante"), 
                    rs.getString("codigo_estudiante"), 
                    rs.getString("tipo_id"), 
                    rs.getString("id"), 
                    rs.getString("nombre1"), 
                    rs.getString("nombre2"), 
                    rs.getString("apellido1"), 
                    rs.getString("apellido2"), 
                    rs.getDate("fecha_nacimiento"), 
                    rs.getString("direccion"), 
                    rs.getString("telefono"), 
                    rs.getString("email")
                ),
                codigoEstudiate
            );
        } catch (EmptyResultDataAccessException e) {
            return new Estudiante();
        }
    }

    public ResponseString getEmailEstudiante(int codigoEstudianteAsignatura) {
        return 
            plantilla.queryForObject(
                "SELECT a.email "
                + "FROM datos_personales a "
                + "INNER JOIN estudiantes b ON b.codigo_dato_personal = a.codigo_dato_personal "
                + "INNER JOIN estudiantes_asignaturas c ON c.codigo_estudiante = b.codigo_estudiante AND c.codigo_estudiante_asignatura = ? " 
                + "LIMIT 1", 
                (rs, rowNum) -> new ResponseString(rs.getString("email")),
                codigoEstudianteAsignatura
            );
    }
}
