package univ.univ_scheduler.app;

import univ.univ_scheduler.database.DatabaseInitializer;

public class AppMain {
    public static void main(String[] args) {
        // Initialisation de la base de données
        DatabaseInitializer.initializeDatabase();
    }
}
