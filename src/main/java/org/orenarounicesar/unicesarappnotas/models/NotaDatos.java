package org.orenarounicesar.unicesarappnotas.models;

public class NotaDatos {
    
    private int codigoNota;
    private int codigoEstudianteAsignatura;
    private int codigoCorte;
    private float nota;
    private boolean publicada;

    public NotaDatos() {
    }

    public NotaDatos(int codigoNota, int codigoEstudianteAsignatura, int codigoCorte, float nota, boolean publicada) {
        this.codigoNota = codigoNota;
        this.codigoEstudianteAsignatura = codigoEstudianteAsignatura;
        this.codigoCorte = codigoCorte;
        this.nota = nota;
        this.publicada = publicada;
    }

    public int getCodigoNota() {
        return codigoNota;
    }

    public void setCodigoNota(int codigoNota) {
        this.codigoNota = codigoNota;
    }

    public int getCodigoEstudianteAsignatura() {
        return codigoEstudianteAsignatura;
    }

    public void setCodigoEstudianteAsignatura(int codigoEstudianteAsignatura) {
        this.codigoEstudianteAsignatura = codigoEstudianteAsignatura;
    }

    public int getCodigoCorte() {
        return codigoCorte;
    }

    public void setCodigoCorte(int codigoCorte) {
        this.codigoCorte = codigoCorte;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean isPublicada() {
        return publicada;
    }

    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }

    @Override
    public String toString() {
        return "NotaDatos [codigoCorte=" + codigoCorte + ", codigoEstudianteAsignatura=" + codigoEstudianteAsignatura
                + ", codigoNota=" + codigoNota + ", nota=" + nota + ", publicada=" + publicada + "]";
    }
    
}
