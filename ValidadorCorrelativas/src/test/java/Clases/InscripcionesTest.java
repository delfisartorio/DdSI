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
        Materia programacion = new Materia("Programación",Collections.emptyList());

        Alumno alumno = new Alumno("Juan",Collections.emptyList());

        Assertions.assertTrue(alumno.puedeCursar(programacion));
    }

    @Test
    public void testAlumnoNoPuedeCursarMateriaPorFaltaDeCorrelativas() {
        Materia algoritmos = new Materia("Algoritmos",Collections.emptyList());

        Materia estructuras = new Materia("Estructuras de Datos",Collections.singletonList(algoritmos));


        Alumno alumno = new Alumno("María",Collections.emptyList());

        Assertions.assertFalse(alumno.puedeCursar(estructuras));
    }

    @Test
    public void testAlumnoPuedeCursarMateriaSiCumpleCorrelativas() {
        Materia algoritmos = new Materia("Algoritmos",Collections.emptyList());

        Materia estructuras = new Materia("Estructuras de Datos",Collections.singletonList(algoritmos));

        Alumno alumno = new Alumno("Carlos",Collections.singletonList(algoritmos));

        Assertions.assertTrue(alumno.puedeCursar(estructuras));
    }

    @Test
    public void testInscripcionAprobadaSiTodasLasMateriasCumplenCorrelativas() {
        Materia algoritmos = new Materia("Algoritmos",Collections.emptyList());

        Materia estructuras = new Materia("Estructuras de Datos",Collections.singletonList(algoritmos));

        Alumno alumno = new Alumno("Ana",Collections.singletonList(algoritmos));

        Inscripcion inscripcion = new Inscripcion(alumno,Collections.singletonList(estructuras));

        Assertions.assertTrue(inscripcion.inscripcionAprobada());
    }

    @Test
    public void testInscripcionRechazadaSiAlMenosUnaMateriaNoCumpleCorrelativas() {
        Materia algoritmos = new Materia("Algoritmos",Collections.emptyList());

        Materia estructuras = new Materia("Estructuras de Datos",Collections.singletonList(algoritmos));

        Materia basesDeDatos = new Materia("Bases de Datos",Collections.singletonList(estructuras));

        Alumno alumno = new Alumno("Sofía",Collections.singletonList(algoritmos));

        Inscripcion inscripcion = new Inscripcion(alumno,Arrays.asList(basesDeDatos, estructuras));

        Assertions.assertFalse(inscripcion.inscripcionAprobada());
    }
}
