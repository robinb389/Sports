package dam.uf2.acess;

import java.util.Scanner;

import dam.uf2.acess.controller.DeporteController;
import dam.uf2.acess.controller.DeportistaController;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeporteController deporteCtrl = new DeporteController();
        DeportistaController deportistaCtrl = new DeportistaController();

        int op = -1;
        while (op != 0) {
            System.out.println("\n=== MENU SPORTS ===");
            System.out.println("1. Listar deportes");
            System.out.println("2. Agregar deporte");
            System.out.println("3. Listar deportistas");
            System.out.println("4. Agregar deportista");
            System.out.println("5. Deportes sin deportistas");
            System.out.println("6. Listar deportistas por deporte");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                deporteCtrl.listar();
            } else if (op == 2) {
                System.out.print("Nombre del deporte: ");
                String nombre = sc.nextLine();
                deporteCtrl.agregar(nombre);
            } else if (op == 3) {
                deportistaCtrl.listar();
            } else if (op == 4) {
                System.out.print("Nombre del deportista: ");
                String nombre = sc.nextLine();
                System.out.print("Codigo de deporte (vacío si ninguno): ");
                String cod = sc.nextLine();
                Integer codDeporte = cod.trim().isEmpty() ? null : Integer.parseInt(cod);
                deportistaCtrl.agregar(nombre, codDeporte);
            } else if (op == 5) {
                deporteCtrl.listarSinDeportistas();
            } else if (op == 6) {
                System.out.print("Código de deporte: ");
                int codDep = sc.nextInt();
                deportistaCtrl.listarPorDeporte(codDep);
            } else if (op == 0) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion no valida.");
            }
        }

        sc.close();
    }
}
