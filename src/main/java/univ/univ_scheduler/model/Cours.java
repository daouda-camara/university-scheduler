package univ.univ_scheduler.model;

public class Cours {
    private String matiere;
    private String enseignant;
    private String classe;
    private String groupe;
    private String jour;
    private String heureDebut;
    private int duree;  // Durée en minutes

    public Cours(String matiere, String enseignant, String classe, String groupe, String jour, String heureDebut, int duree) {
        this.matiere = matiere;
        this.enseignant = enseignant;
        this.classe = classe;
        this.groupe = groupe;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.duree = duree;
    }

    // Getters et Setters
    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Cours: " + matiere + ", Enseignant: " + enseignant + ", Classe: " + classe + ", Groupe: " + groupe +
                ", Jour: " + jour + ", Heure de début: " + heureDebut + ", Durée: " + duree + " minutes";
    }
}