package com.smarttask.service;

import com.smarttask.model.Tarea;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas implements Accionable {
    private List<Tarea> tareas;
    private int siguienteId;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.siguienteId = 1;
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        tarea.setId(siguienteId);
        siguienteId++;
        tareas.add(tarea);
    }

    @Override
    public void listarTareas() {
        System.out.println("\nTAREAS ACTIVAS");
        for (Tarea t : tareas) {
            if (!t.isCompletado()) {
                System.out.println(t.toString());
            }
        }

        System.out.println("\nTAREAS COMPLETADAS");
        for (Tarea t : tareas) {
            if (t.isCompletado()) {
                System.out.println(t.toString());
            }
        }
    }

    @Override
    public void marcarComoCompletada(int id) {
        Tarea tareaEncontrada = buscarPorId(id);
        if (tareaEncontrada != null) {
            tareaEncontrada.setCompletado(true);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    @Override
    public void eliminarTarea(int id) {
        Tarea tareaEncontrada = buscarPorId(id);
        if (tareaEncontrada != null) {
            tareas.remove(tareaEncontrada);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    private Tarea buscarPorId(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }
}