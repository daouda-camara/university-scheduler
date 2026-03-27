package univ.univ_scheduler.dao;

import univ.univ_scheduler.database.DatabaseConnection;
import univ.univ_scheduler.model.Cours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursDAO {

    public void addCours(Cours cours) {
        String sql = "INSERT INTO cours (matière, enseignant_id, classe, groupe) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cours.getMatiere());
            if (cours.getEnseignantId() == null) {
                pstmt.setNull(2, Types.INTEGER);
            } else {
                pstmt.setInt(2, cours.getEnseignantId());
            }
            pstmt.setString(3, cours.getClasse());
            pstmt.setString(4, cours.getGroupe());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du cours.");
            e.printStackTrace();
        }
    }

    public List<Cours> getAllCours() {
        List<Cours> coursList = new ArrayList<>();
        String sql = "SELECT * FROM cours";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Integer enseignantId = rs.getObject("enseignant_id", Integer.class);
                Cours cours = new Cours(
                        rs.getInt("id"),
                        rs.getString("matière"),
                        enseignantId,
                        rs.getString("classe"),
                        rs.getString("groupe")
                );
                coursList.add(cours);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des cours.");
            e.printStackTrace();
        }
        return coursList;
    }
}
