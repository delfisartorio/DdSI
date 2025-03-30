package Clases;

import java.util.List;

public class Alumno {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    private List<Materia> materiasAprobadas;

    public boolean puedeCursar(Materia materia){
        return materia.cumpleCorrelativas(this.materiasAprobadas);
    }
}
