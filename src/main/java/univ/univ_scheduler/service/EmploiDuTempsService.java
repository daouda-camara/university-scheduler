package univ.univ_scheduler.service;

import univ.univ_scheduler.model.Cours;
import univ.univ_scheduler.model.Salle;
import java.util.ArrayList;
import java.util.List;

public class EmploiDuTempsService {
    private List<Cours> emploiDuTemps = new ArrayList<>();
    private List<Salle> salles = new ArrayList<>();

    // Ajouter un cours à un créneau horaire
    public boolean ajouterCours(Cours cours, Salle salle) {
        if (detecterConflit(cours)) {
            // Si un conflit est détecté, envoyer une alerte
            NotificationService.alerterConflit("Conflit détecté ! Impossible d'ajouter ce cours : " + cours.getMatiere());
            return false;  // Conflit détecté
        }

        emploiDuTemps.add(cours);
        NotificationService.envoyerNotification("Le cours " + cours.getMatiere() + " a été ajouté avec succès à l'emploi du temps.", "Administrateur");
        System.out.println("Cours ajouté : " + cours);
        return true;
    }

    // Détection des conflits de planning
    private boolean detecterConflit(Cours nouveauCours) {
        for (Cours cours : emploiDuTemps) {
            // Comparer les jours et les heures pour détecter un conflit
            if (cours.getJour().equals(nouveauCours.getJour()) && cours.getHeureDebut().equals(nouveauCours.getHeureDebut())) {
                return true;  // Conflit de créneau horaire
            }
        }
        return false;  // Aucun conflit
    }

    // Méthode pour obtenir toutes les salles disponibles
    public List<Salle> getSallesDisponibles(String jour, String heure) {
        List<Salle> sallesDisponibles = new ArrayList<>();
        for (Salle salle : salles) {
            // Vérifier si la salle est disponible à ce jour et cette heure
            boolean disponible = true;  // Ici tu pourrais vérifier les disponibilités
            if (disponible) {
                sallesDisponibles.add(salle);
            }
        }
        return sallesDisponibles;
    }
}