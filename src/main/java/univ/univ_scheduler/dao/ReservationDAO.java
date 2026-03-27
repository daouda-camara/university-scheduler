package univ.univ_scheduler.dao;

import univ.univ_scheduler.database.DatabaseConnection;
import univ.univ_scheduler.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public void addReservation(Reservation reservation) {
        String sql = "INSERT INTO réservations (salle_id, cours_id, date_heure, durée) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, reservation.getSalleId());
            pstmt.setInt(2, reservation.getCoursId());
            pstmt.setString(3, reservation.getDateHeure());
            pstmt.setInt(4, reservation.getDuree());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la réservation.");
            e.printStackTrace();
        }
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM réservations";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reservation reservation = new Reservation(
                        rs.getInt("id"),
                        rs.getInt("salle_id"),
                        rs.getInt("cours_id"),
                        rs.getString("date_heure"),
                        rs.getInt("durée")
                );
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des réservations.");
            e.printStackTrace();
        }
        return reservations;
    }
}
