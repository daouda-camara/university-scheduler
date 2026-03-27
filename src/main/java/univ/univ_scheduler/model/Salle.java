package univ.univ_scheduler.model;

public class Salle {

    private String numero;
    private int capacite;
    private String type;

    public Salle(String numero, int capacite, String type) {
        this.numero = numero;
        this.capacite = capacite;
        this.type = type;
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
}
