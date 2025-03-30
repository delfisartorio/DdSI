package Clases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InscripcionesTest {

    @Test
    public void testAlumnoPuedeCursarMateriaSinCorrelativas() {
        Materia programacion = new Materia();
        programacion.setNombre("Programación");
        programacion.setCorrelativas(Collections.emptyList()); // No tiene correlativas

        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setMateriasAprobadas(Collections.emptyList());; // No tiene materias aprobadas

        Assertions.assertTrue(alumno.puedeCursar(programacion));
    }

    @Test
    public void testAlumnoNoPuedeCursarMateriaPorFaltaDeCorrelativas() {
        Materia algoritmos = new Materia();
        algoritmos.setNombre("Algoritmos");
        algoritmos.setCorrelativas(Collections.emptyList());

        Materia estructuras = new Materia();
        estructuras.setNombre("Estructuras de Datos");
        estructuras.setCorrelativas(Collections.singletonList(algoritmos)); //X q no puedo poner list solo?

        Alumno alumno = new Alumno();
        alumno.setNombre("María");
        alumno.setMateriasAprobadas(Collections.emptyList()); // No aprobó "Algoritmos"

        Assertions.assertFalse(alumno.puedeCursar(estructuras));
    }

    @Test
    public void testAlumnoPuedeCursarMateriaSiCumpleCorrelativas() {
        Materia algoritmos = new Materia();
        algoritmos.setNombre("Algoritmos");
        algoritmos.setCorrelativas(Collections.emptyList());

        Materia estructuras = new Materia();
        estructuras.setNombre("Estructuras de Datos");
        estructuras.setCorrelativas(Collections.singletonList(algoritmos));

        Alumno alumno = new Alumno();
        alumno.setNombre("Carlos");
        alumno.setMateriasAprobadas(Collections.singletonList(algoritmos)); // Aprobó "Algoritmos"

        Assertions.assertTrue(alumno.puedeCursar(estructuras));
    }

    @Test
    public void testInscripcionAprobadaSiTodasLasMateriasCumplenCorrelativas() {
        Materia algoritmos = new Materia();
        algoritmos.setNombre("Algoritmos");
        algoritmos.setCorrelativas(Collections.emptyList());

        Materia estructuras = new Materia();
        estructuras.setNombre("Estructuras de Datos");
        estructuras.setCorrelativas(Collections.singletonList(algoritmos));

        Alumno alumno = new Alumno();
        alumno.setNombre("Ana");
        alumno.setMateriasAprobadas(Collections.singletonList(algoritmos));

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasSolicitadas(Collections.singletonList(estructuras));

        Assertions.assertTrue(inscripcion.inscripcionAprobada());
    }

    @Test
    public void testInscripcionRechazadaSiAlMenosUnaMateriaNoCumpleCorrelativas() {
        Materia algoritmos = new Materia();
        algoritmos.setNombre("Algoritmos");
        algoritmos.setCorrelativas(Collections.emptyList());

        Materia estructuras = new Materia();
        estructuras.setNombre("Estructuras de Datos");
        estructuras.setCorrelativas(Collections.singletonList(algoritmos));

        Materia basesDeDatos = new Materia();
        basesDeDatos.setNombre("Bases de Datos");
        basesDeDatos.setCorrelativas(Collections.singletonList(estructuras));

        Alumno alumno = new Alumno();
        alumno.setNombre("Sofía");
        alumno.setMateriasAprobadas(Collections.singletonList(algoritmos)); // Solo aprobó "Algoritmos"

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasSolicitadas(Arrays.asList(estructuras, basesDeDatos));

        Assertions.assertFalse(inscripcion.inscripcionAprobada());
    }
}
