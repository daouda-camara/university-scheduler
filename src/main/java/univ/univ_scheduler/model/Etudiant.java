package univ.univ_scheduler.model;


public class Etudiant extends Utilisateur {
    public Etudiant(String nom, String email) {
        super(nom, email, "Étudiant");
    }

    public void consulterEmploiDuTemps() {
        System.out.println("Consultation de l'emploi du temps de ma classe...");
    }

    public void rechercherSalleLibre() {
        System.out.println("Recherche d'une salle libre...");
    }
}
