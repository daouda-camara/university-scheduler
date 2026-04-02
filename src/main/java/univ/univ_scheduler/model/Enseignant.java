package univ.univ_scheduler.model;


public class Enseignant extends Utilisateur {
    public Enseignant(String nom, String email) {
        super(nom, email, "Enseignant");
    }

    public void consulterEmploiDuTemps() {
        System.out.println("Consultation de l'emploi du temps...");
    }

    // Autres méthodes spécifiques aux enseignants
}
