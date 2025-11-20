package dam.uf2.acess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dam.uf2.acess.db.ConnectionManager;
import dam.uf2.acess.model.Deporte;

public class DeporteDAO {

    public List<Deporte> getAll() {
        List<Deporte> lista = new ArrayList<>();
        String sql = "SELECT * FROM DEPORTES";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Deporte(rs.getInt("COD"), rs.getString("NOMBRE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(String nombre) {
        String sql = "INSERT INTO DEPORTES (NOMBRE) VALUES (?)";
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
