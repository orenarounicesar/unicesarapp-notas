package org.orenarounicesar.unicesarappnotas.models;

import java.util.Date;

public class Corte {
    
    private String nombreCorte;
    private Date fecha;
    
    public Corte() {
    }

    public Corte(String nombreCorte, Date fecha) {
        this.nombreCorte = nombreCorte;
        this.fecha = fecha;
    }

    public String getNombreCorte() {
        return nombreCorte;
    }

    public void setNombreCorte(String nombreCorte) {
        this.nombreCorte = nombreCorte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Corte [fecha=" + fecha + ", nombreCorte=" + nombreCorte + "]";
    }

}
