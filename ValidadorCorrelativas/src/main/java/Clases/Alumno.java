package Clases;

import java.util.List;

public class Alumno {
    public Alumno(String nombre, List<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.materiasAprobadas = materiasAprobadas;
    }

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
