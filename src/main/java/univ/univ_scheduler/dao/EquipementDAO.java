package univ.univ_scheduler.dao;

import univ.univ_scheduler.database.DatabaseConnection;
import univ.univ_scheduler.model.Equipement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipementDAO {
    private Connection connection;

    public EquipementDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    // Méthode pour récupérer tous les équipements
    public List<Equipement> getAllEquipements() throws SQLException {
        List<Equipement> equipements = new ArrayList<>();
        String query = "SELECT * FROM equipements";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Equipement equipement = new Equipement(resultSet.getString("type"),
                    resultSet.getBoolean("disponible"));
            equipements.add(equipement);
        }
        return equipements;
    }

    // Méthode pour ajouter un équipement
    public void create(Equipement equipement) throws SQLException {
        String query = "INSERT INTO equipements (type, disponible) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, equipement.getType());
        preparedStatement.setBoolean(2, equipement.isDisponible());
        preparedStatement.executeUpdate();
    }
}