package univ.univ_scheduler.service;


public class NotificationService {

    public static void envoyerNotification(String message, String destinataire) {
        // Logique pour envoyer une notification
        System.out.println("Notification envoyée à " + destinataire + ": " + message);
    }

    public static void alerterConflit(String message) {
        // Logique pour alerter de conflits
        System.out.println("Alerte de conflit: " + message);
    }

    // Autres méthodes pour les alertes et notifications
}
