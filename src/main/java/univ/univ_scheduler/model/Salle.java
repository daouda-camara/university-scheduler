package univ.univ_scheduler.model;

public class Salle {
    private String numero;
    private int capacite;
    private String type;  // (TD, TP, Amphi)
    private boolean equipement;  // Si la salle dispose d'un vidéoprojecteur par exemple

    public Salle(String numero, int capacite, String type, boolean equipement) {
        this.numero = numero;
        this.capacite = capacite;
        this.type = type;
        this.equipement = equipement;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEquipement() {
        return equipement;
    }

    public void setEquipement(boolean equipement) {
        this.equipement = equipement;
    }

    @Override
    public String toString() {
        return "Salle: " + numero + ", Capacité: " + capacite + ", Type: " + type + ", Equipée: " + (equipement ? "Oui" : "Non");
    }
}