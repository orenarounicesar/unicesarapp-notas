package org.orenarounicesar.unicesarappnotas.repositories;

import org.orenarounicesar.unicesarappnotas.models.Corte;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CorteRepository {
    
    private JdbcTemplate plantilla;

    public CorteRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }

    public Corte getCorte(int codigoCorte) {
        return plantilla.queryForObject(
            "SELECT "
                + "a.nombre_corte, "
                + "b.fecha "
            + "FROM cortes a "
            + "INNER JOIN cortes_fechas b ON b.codigo_corte = a.codigo_corte AND b.actual = 1 "
            + "WHERE a.codigo_corte = ?", 
            (rs, rowNum) -> new Corte(rs.getString("nombre_corte"), rs.getTimestamp("fecha")),
            codigoCorte
        );
    }
}
