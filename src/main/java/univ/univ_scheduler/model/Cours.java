package univ.univ_scheduler.model;

public class Cours {
    private int id;
    private String matiere;
    private Integer enseignantId;
    private String classe;
    private String groupe;

    public Cours(int id, String matiere, Integer enseignantId, String classe, String groupe) {
        this.id = id;
        this.matiere = matiere;
        this.enseignantId = enseignantId;
        this.classe = classe;
        this.groupe = groupe;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Integer getEnseignantId() {
        return enseignantId;
    }

    public void setEnseignantId(Integer enseignantId) {
        this.enseignantId = enseignantId;
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
}
