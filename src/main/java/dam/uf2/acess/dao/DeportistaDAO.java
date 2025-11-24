package dam.uf2.acess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dam.uf2.acess.db.ConnectionManager;
import dam.uf2.acess.model.Deportista;

public class DeportistaDAO {

    public List<Deportista> getAll() {
        List<Deportista> lista = new ArrayList<>();
        String sql = "SELECT d.COD, d.NOMBRE, d.COD_DEPORTE, dep.NOMBRE AS DEPORTE_NOMBRE " +
                     "FROM DEPORTISTAS d LEFT JOIN DEPORTES dep ON d.COD_DEPORTE = dep.COD";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Deportista(
                    rs.getInt("COD"),
                    rs.getString("NOMBRE"),
                    (Integer) rs.getObject("COD_DEPORTE"),
                    rs.getString("DEPORTE_NOMBRE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(String nombre, Integer codDeporte) {
        String sql = "INSERT INTO DEPORTISTAS (NOMBRE, COD_DEPORTE) VALUES (?, ?)";
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            if (codDeporte == null) {
                stmt.setNull(2, Types.INTEGER);
            } else {
                stmt.setInt(2, codDeporte);
            }

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Deportista> searchByName(String name) {
        List<Deportista> lista = new ArrayList<>();
        String sql = "SELECT d.COD, d.NOMBRE, d.COD_DEPORTE, dep.NOMBRE AS DEPORTE_NOMBRE " +
                     "FROM DEPORTISTAS d LEFT JOIN DEPORTES dep ON d.COD_DEPORTE = dep.COD " +
                     "WHERE LOWER(d.NOMBRE) LIKE LOWER(?)";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Deportista(
                    rs.getInt("COD"),
                    rs.getString("NOMBRE"),
                    (Integer) rs.getObject("COD_DEPORTE"),
                    rs.getString("DEPORTE_NOMBRE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
