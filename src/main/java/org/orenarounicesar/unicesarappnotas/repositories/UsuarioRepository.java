package org.orenarounicesar.unicesarappnotas.repositories;

import org.orenarounicesar.unicesarappnotas.models.Usuario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    private JdbcTemplate plantilla;

    public UsuarioRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }
    
    public Usuario getUsuario(String login, String password) {
        try {
            return plantilla.queryForObject(
                "SELECT "
                    + "a.codigo_usuario, "
                    + "a.login, "
                    + "a.nombre_usuario, "
                    + "a.codigo_docente, "
                    + "a.codigo_estudiante "
                + "FROM usuarios a " 
                + "WHERE BINARY a.login = ? AND a.password = md5(?) AND a.activo = 1  " 
                + "LIMIT 1", 
                (rs, rowNum) -> new Usuario(
                    rs.getInt("codigo_usuario"), 
                    rs.getString("login"), 
                    rs.getString("nombre_usuario"), 
                    rs.getInt("codigo_docente"), 
                    rs.getInt("codigo_estudiante")
                ),
                new Object[]{login, password}
            );
        } catch (EmptyResultDataAccessException e) {
            return new Usuario();
        }
    }
}
