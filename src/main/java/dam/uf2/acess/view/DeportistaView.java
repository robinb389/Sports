package dam.uf2.acess.view;


import java.util.List;

import dam.uf2.acess.model.Deportista;

public class DeportistaView {

    public static void mostrarLista(List<Deportista> deportistas) {
        System.out.println("\n--- LISTA DE DEPORTISTAS ---");
        for (Deportista d : deportistas) {
            System.out.println(d);
        }
    }
}

