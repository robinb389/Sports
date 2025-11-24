package dam.uf2.acess.model;

public class Deportista {
    private int cod;
    private String nombre;
    private Integer codDeporte;
    private String nombreDeporte;

    public Deportista() {}

    public Deportista(String nombre, Integer codDeporte) {
        this.nombre = nombre;
        this.codDeporte = codDeporte;
    }

    public Deportista(int cod, String nombre, Integer codDeporte, String nombreDeporte) {
        this.cod = cod;
        this.nombre = nombre;
        this.codDeporte = codDeporte;
        this.nombreDeporte = nombreDeporte;
    }

    public int getCod() { return cod; }
    public String getNombre() { return nombre; }
    public Integer getCodDeporte() { return codDeporte; }
    public String getNombreDeporte() { return nombreDeporte; }

    public void setCod(int cod) { this.cod = cod; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCodDeporte(Integer codDeporte) { this.codDeporte = codDeporte; }
    public void setNombreDeporte(String nombreDeporte) { this.nombreDeporte = nombreDeporte; }

    @Override
    public String toString() {
        return cod + " - " + nombre +
            (nombreDeporte != null ? " (Deporte: " + nombreDeporte + ")" : " (Sin deporte)");
    }
}
