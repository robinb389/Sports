package dam.uf2.acess.view;

import java.util.List;

import dam.uf2.acess.model.Deporte;

public class DeporteView {

    public static void mostrarLista(List<Deporte> deportes) {
        System.out.println("\n--- LISTA DE DEPORTES ---");
        for (Deporte d : deportes) {
            System.out.println(d);
        }
    }
}