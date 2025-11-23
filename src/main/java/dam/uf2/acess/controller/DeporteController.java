package dam.uf2.acess.controller;

import java.util.List;

import dam.uf2.acess.dao.DeporteDAO;
import dam.uf2.acess.model.Deporte;

public class DeporteController {

    private final DeporteDAO dao = new DeporteDAO();

    public void listar() {
        List<Deporte> deportes = dao.getAll();
        deportes.forEach(System.out::println);
    }

    public void agregar(String nombre) {
        if (dao.insert(nombre)) {
            System.out.println("Deporte añadido correctamente.");
        } else {
            System.out.println("Error añadiendo deporte.");
        }
    }

    public void listarSinDeportistas() {
        List<Deporte> deportes = dao.getDeportesSinDeportistas();
        System.out.println("\n--- DEPORTES SIN DEPORTISTAS ---");
        deportes.forEach(System.out::println);
    }
}
