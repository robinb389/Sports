package dam.uf2.acess.model;

public class Deportista {
    private int cod;
    private String nombre;
    private Integer codDeporte; // puede ser null

    public Deportista() {}

    public Deportista(String nombre, Integer codDeporte) {
        this.nombre = nombre;
        this.codDeporte = codDeporte;
    }

    public Deportista(int cod, String nombre, Integer codDeporte) {
        this.cod = cod;
        this.nombre = nombre;
        this.codDeporte = codDeporte;
    }

    public int getCod() { return cod; }
    public String getNombre() { return nombre; }
    public Integer getCodDeporte() { return codDeporte; }

    public void setCod(int cod) { this.cod = cod; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCodDeporte(Integer codDeporte) { this.codDeporte = codDeporte; }

    @Override
    public String toString() {
        return cod + " - " + nombre + 
            (codDeporte != null ? " (Deporte: " + codDeporte + ")" : "");
    }

}
