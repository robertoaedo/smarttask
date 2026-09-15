package com.smarttask;

import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;
import com.smarttask.service.GestorTareas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("\n1. Agregar tarea");
                System.out.println("2. Listar tareas");
                System.out.println("3. Marcar tarea como completada");
                System.out.println("4. Eliminar tarea");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la tarea: ");
                        String nombre = scanner.nextLine();

                        System.out.println("Tipo de tarea:");
                        System.out.println("1. Normal");
                        System.out.println("2. Urgente");
                        System.out.print("Seleccione tipo: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        if (tipo == 1) {
                            gestor.agregarTarea(new TareaNormal(0, nombre));
                        } else if (tipo == 2) {
                            System.out.print("Días límite: ");
                            int diasLimite = scanner.nextInt();
                            scanner.nextLine();
                            gestor.agregarTarea(new TareaUrgente(0, nombre, diasLimite));
                        } else {
                            System.out.println("Entrada inválida. Intente nuevamente.");
                        }
                        break;

                    case 2:
                        gestor.listarTareas();
                        break;

                    case 3:
                        System.out.print("Ingrese ID: ");
                        int idCompletar = scanner.nextInt();
                        scanner.nextLine();
                        gestor.marcarComoCompletada(idCompletar);
                        break;

                    case 4:
                        System.out.print("Ingrese ID: ");
                        int idEliminar = scanner.nextInt();
                        scanner.nextLine();
                        gestor.eliminarTarea(idEliminar);
                        break;

                    case 5:
                        salir = true;
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Entrada inválida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}