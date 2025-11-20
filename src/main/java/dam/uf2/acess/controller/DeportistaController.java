package dam.uf2.acess.controller;


import java.util.List;

import dam.uf2.acess.dao.DeportistaDAO;
import dam.uf2.acess.model.Deportista;
import dam.uf2.acess.view.DeportistaView;

public class DeportistaController {

    private final DeportistaDAO dao = new DeportistaDAO();

    public void listar() {
        List<Deportista> deportistas = dao.getAll();
        DeportistaView.mostrarLista(deportistas);
    }

    public void agregar(String nombre, Integer codDeporte) {
        if (dao.insert(nombre, codDeporte)) {
            System.out.println("Deportista agregado correctamente.");
        } else {
            System.out.println("Error agregando deportista.");
        }
    }
}

