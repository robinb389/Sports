package dam.uf2.acess.model;

public class Deporte {
    private int cod;
    private String nombre;

    public Deporte() {}

    public Deporte(String nombre) {
        this.nombre = nombre;
    }

    public Deporte(int cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public int getCod() { return cod; }
    public String getNombre() { return nombre; }

    public void setCod(int cod) { this.cod = cod; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return cod + " - " + nombre;
    }

}
