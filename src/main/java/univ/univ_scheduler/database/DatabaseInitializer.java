package univ.univ_scheduler.database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        String[] statements = {
                """
                CREATE TABLE IF NOT EXISTS bâtiments (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  nom VARCHAR(255),
                  localisation VARCHAR(255),
                  étage INTEGER
                );
                """,
                """
                CREATE TABLE IF NOT EXISTS salles (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  numéro VARCHAR(10),
                  capacité INTEGER,
                  type_salle VARCHAR(50),  -- TD, TP, Amphi
                  bâtiment_id INTEGER,
                  FOREIGN KEY (bâtiment_id) REFERENCES bâtiments(id) ON DELETE CASCADE
                );
                """,
                """
                CREATE TABLE IF NOT EXISTS équipements (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  nom VARCHAR(255),
                  type VARCHAR(100) -- ex: vidéoprojecteur, tableau interactif
                );
                """,
                """
                CREATE TABLE IF NOT EXISTS utilisateurs (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  nom VARCHAR(255),
                  rôle VARCHAR(50),  -- ex: admin, enseignant, étudiant
                  email VARCHAR(255),
                  mot_de_passe VARCHAR(255)  -- Mot de passe (sécurisé)
                );
                """,
                """
                CREATE TABLE IF NOT EXISTS cours (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  matière VARCHAR(255),
                  enseignant_id INTEGER,  -- Clé étrangère vers la table utilisateurs (enseignant)
                  classe VARCHAR(50),
                  groupe VARCHAR(50),
                  FOREIGN KEY (enseignant_id) REFERENCES utilisateurs(id) ON DELETE SET NULL
                );
                """,
                """
                CREATE TABLE IF NOT EXISTS réservations (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  salle_id INTEGER,
                  cours_id INTEGER,
                  date_heure TEXT,  -- Format 'YYYY-MM-DD HH:MM:SS'
                  durée INTEGER,  -- Durée en minutes
                  FOREIGN KEY (salle_id) REFERENCES salles(id) ON DELETE CASCADE,
                  FOREIGN KEY (cours_id) REFERENCES cours(id) ON DELETE CASCADE
                );
                """,
                """
                CREATE TABLE IF NOT EXISTS équipements_salle (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  salle_id INTEGER,
                  équipement_id INTEGER,
                  FOREIGN KEY (salle_id) REFERENCES salles(id) ON DELETE CASCADE,
                  FOREIGN KEY (équipement_id) REFERENCES équipements(id) ON DELETE CASCADE
                );
                """,
                """
                CREATE TABLE IF NOT EXISTS étudiants (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  nom VARCHAR(255),
                  email VARCHAR(255),
                  groupe VARCHAR(50),
                  cours_id INTEGER,  -- Cours auquel l'étudiant est inscrit
                  FOREIGN KEY (cours_id) REFERENCES cours(id) ON DELETE SET NULL
                );
                """,
                """
                CREATE TABLE IF NOT EXISTS notifications (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  utilisateur_id INTEGER,  -- Id de l'utilisateur pour lequel la notification est liée
                  message VARCHAR(255),
                  date_heure TEXT,  -- Format 'YYYY-MM-DD HH:MM:SS'
                  lue BOOLEAN DEFAULT 0,  -- Indicateur de notification lue (0 = non lue, 1 = lue)
                  FOREIGN KEY (utilisateur_id) REFERENCES utilisateurs(id) ON DELETE CASCADE
                );
                """
        };

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement()) {

            // Créer les tables de la base de données
            for (String sql : statements) {
                stmt.executeUpdate(sql);
            }

            // Ajouter des index pour améliorer la recherche
            stmt.executeUpdate("CREATE INDEX IF NOT EXISTS idx_salle_batiment ON salles(bâtiment_id);");
            stmt.executeUpdate("CREATE INDEX IF NOT EXISTS idx_reservation_salle ON réservations(salle_id);");
            stmt.executeUpdate("CREATE INDEX IF NOT EXISTS idx_reservation_cours ON réservations(cours_id);");
            stmt.executeUpdate("CREATE INDEX IF NOT EXISTS idx_utilisateur_email ON utilisateurs(email);");

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'initialisation de la base de données.");
            e.printStackTrace();
        }
    }
}