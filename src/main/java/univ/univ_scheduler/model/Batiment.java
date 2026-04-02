package univ.univ_scheduler.model;

public class Batiment {
    private String nom;
    private String localisation;
    private int etages;

    public Batiment(String nom, String localisation, int etages) {
        this.nom = nom;
        this.localisation = localisation;
        this.etages = etages;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getEtages() {
        return etages;
    }

    public void setEtages(int etages) {
        this.etages = etages;
    }

    @Override
    public String toString() {
        return "Bâtiment: " + nom + ", Localisation: " + localisation + ", Nombre d'étages: " + etages;
    }
}
