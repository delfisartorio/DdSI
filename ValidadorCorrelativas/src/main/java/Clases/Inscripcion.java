package Clases;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;

    public Inscripcion(Alumno alumno, List<Materia> materiasSolicitadas) {
        this.alumno = alumno;
        this.materiasSolicitadas = materiasSolicitadas;
    }

    public void setMateriasSolicitadas(List<Materia> materiasSolicitadas) {
        this.materiasSolicitadas = materiasSolicitadas;
    }

    private List<Materia> materiasSolicitadas;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public boolean inscripcionAprobada(){
        return this.materiasSolicitadas.stream().allMatch(m-> this.alumno.puedeCursar(m));
    }
}
