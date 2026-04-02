package univ.univ_scheduler.model;


public class Administrateur extends Utilisateur {
    public Administrateur(String nom, String email) {
        super(nom, email, "Administrateur");
    }

    public void gererUtilisateurs() {
        System.out.println("Gestion des utilisateurs...");
    }

    // Autres méthodes spécifiques à l'administrateur
}
