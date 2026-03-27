package univ.univ_scheduler.app;

import univ.univ_scheduler.dao.SalleDAO;
import univ.univ_scheduler.model.Salle;

public class TestDAO {
    public static void main(String[] args) {
        // Tester SalleDAO
        SalleDAO salleDAO = new SalleDAO();

        // Ajouter une salle
        Salle salle = new Salle("101", 50, "TD");
        salleDAO.addSalle(salle);
        System.out.println("Salle ajoutée avec succès.");

        // Récupérer toutes les salles
        System.out.println("Liste des salles:");
        salleDAO.getAllSalles().forEach(s -> {
            System.out.println("Salle: " + s.getNumero() + " - Capacité: " + s.getCapacite());
        });
    }
}
