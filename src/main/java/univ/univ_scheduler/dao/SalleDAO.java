package univ.univ_scheduler.dao;

import univ.univ_scheduler.database.DatabaseConnection;
import univ.univ_scheduler.model.Salle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalleDAO {

    public void addSalle(Salle salle) {
        String sql = "INSERT INTO salles (numéro, capacité, type_salle) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, salle.getNumero());
            pstmt.setInt(2, salle.getCapacite());
            pstmt.setString(3, salle.getType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la salle.");
            e.printStackTrace();
        }
    }

    public List<Salle> getAllSalles() {
        List<Salle> salles = new ArrayList<>();
        String sql = "SELECT * FROM salles";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Salle salle = new Salle(
                        rs.getString("numéro"),
                        rs.getInt("capacité"),
                        rs.getString("type_salle")
                );
                salles.add(salle);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des salles.");
            e.printStackTrace();
        }
        return salles;
    }

    public Integer getSalleIdByNumero(String numero) {
        String sql = "SELECT id FROM salles WHERE numéro = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, numero);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de la salle.");
            e.printStackTrace();
        }
        return null;
    }
}
