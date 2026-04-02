package univ.univ_scheduler.model;


public class Utilisateur {
    private String nom;
    private String email;
    private String role;  // "Administrateur", "Gestionnaire", "Enseignant", "Étudiant"

    public Utilisateur(String nom, String email, String role) {
        this.nom = nom;
        this.email = email;
        this.role = role;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur [nom=" + nom + ", email=" + email + ", role=" + role + "]";
    }
}
