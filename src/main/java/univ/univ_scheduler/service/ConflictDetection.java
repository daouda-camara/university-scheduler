package univ.univ_scheduler.service;

import univ.univ_scheduler.model.Cours;
import java.util.List;

public class ConflictDetection {

    public static boolean detecterConflit(List<Cours> emploiDuTemps, Cours nouveauCours) {
        for (Cours cours : emploiDuTemps) {
            // Vérifier si le cours et le nouveau cours se chevauchent
            if (cours.getJour().equals(nouveauCours.getJour())) {
                int heureCours = Integer.parseInt(cours.getHeureDebut().split(":")[0]);
                int heureNouveauCours = Integer.parseInt(nouveauCours.getHeureDebut().split(":")[0]);

                // Vérifier les conflits d'horaires
                if (heureCours == heureNouveauCours) {
                    return true;  // Conflit trouvé
                }
            }
        }
        return false;  // Pas de conflit
    }
}
