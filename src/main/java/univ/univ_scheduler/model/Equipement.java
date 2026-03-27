package univ.univ_scheduler.model;

public class Equipement {
    private String type;
    private boolean disponible; // Si l'équipement est disponible ou non

    // Constructeur
    public Equipement(String type, boolean disponible) {
        this.type = type;
        this.disponible = disponible;
    }

    // Getters et Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}