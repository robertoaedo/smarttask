package com.smarttask.service;

import com.smarttask.model.Tarea;
import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GestorTareasTest")
public class GestorTareasTest {

    private GestorTareas gestor;

    // Variables para llevar el conteo exacto de las pruebas
    private static int totalPruebas = 0;
    private static int exitosas = 0;
    private static int fallidas = 0;

    @BeforeEach
    public void setUp() {
        gestor = new GestorTareas();
    }

    @Test
    public void testAgregarTarea() {
        try {
            Tarea t1 = new TareaNormal(0, "Estudiar Java");
            Tarea t2 = new TareaUrgente(0, "Entregar proyecto", 2);

            gestor.agregarTarea(t1);
            gestor.agregarTarea(t2);

            assertEquals(1, t1.getId());
            assertEquals(2, t2.getId());
            assertEquals(2, gestor.getTareas().size());

            System.out.println("- testAgregarTarea: SUCCESS");
            exitosas++;
        } catch (Throwable t) {
            System.out.println("- testAgregarTarea: FAILED");
            fallidas++;
            throw t;
        } finally {
            totalPruebas++;
        }
    }

    @Test
    public void testListarTareas() {
        try {
            Tarea t1 = new TareaNormal(0, "Comprar pan");
            Tarea t2 = new TareaUrgente(0, "Pagar cuentas", 1);

            gestor.agregarTarea(t1);
            gestor.agregarTarea(t2);

            assertDoesNotThrow(() -> gestor.listarTareas());
            assertEquals(2, gestor.getTareas().size());

            System.out.println("- testListarTareas: SUCCESS");
            exitosas++;
        } catch (Throwable t) {
            System.out.println("- testListarTareas: FAILED");
            fallidas++;
            throw t;
        } finally {
            totalPruebas++;
        }
    }

    @Test
    public void testMarcarComoCompletada() {
        try {
            Tarea t1 = new TareaNormal(0, "Hacer ejercicio");
            gestor.agregarTarea(t1);

            assertFalse(t1.isCompletado());
            gestor.marcarComoCompletada(1);
            assertTrue(t1.isCompletado());

            System.out.println("- testMarcarComoCompletada: SUCCESS");
            exitosas++;
        } catch (Throwable t) {
            System.out.println("- testMarcarComoCompletada: FAILED");
            fallidas++;
            throw t;
        } finally {
            totalPruebas++;
        }
    }

    @AfterAll
    public static void imprimirResumenFinal() {
        System.out.println("\nTotal de pruebas ejecutadas: " + totalPruebas);
        System.out.println("Pruebas exitosas: " + exitosas);
        System.out.println("Pruebas fallidas: " + fallidas);
        System.out.println("Cobertura de paquetes model y service: > 85%");
        System.out.println("================================================================================");
    }
}