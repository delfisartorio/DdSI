package Clases;

import java.util.List;

public class Materia {
    private String nombre;

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    private List<Materia> correlativas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public boolean cumpleCorrelativas(List<Materia> listaMateriasAprobadas){
        return listaMateriasAprobadas.containsAll(this.correlativas);
    }
}
