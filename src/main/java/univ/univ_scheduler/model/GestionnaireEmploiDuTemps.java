package univ.univ_scheduler.model;


public class GestionnaireEmploiDuTemps extends Utilisateur {
    public GestionnaireEmploiDuTemps(String nom, String email) {
        super(nom, email, "Gestionnaire d'emploi du temps");
    }

    public void creerEmploiDuTemps() {
        System.out.println("Création de l'emploi du temps...");
    }

    // Autres méthodes spécifiques aux gestionnaires
}
