package univ.univ_scheduler.database;


import univ.univ_scheduler.model.Salle;
import java.sql.*;

public class SalleRepository {

    public void ajouterSalle(Salle salle) {
        String sql = "INSERT INTO salles (numero, capacite, type, equipement) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, salle.getNumero());
            stmt.setInt(2, salle.getCapacite());
            stmt.setString(3, salle.getType());
            stmt.setBoolean(4, salle.isEquipement());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Autres méthodes pour récupérer, modifier ou supprimer des salles
}
