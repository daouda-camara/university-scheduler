package univ.univ_scheduler.model;

public class Reservation {

    private int id;
    private int salleId;
    private int coursId;
    private String dateHeure;
    private int duree;

    public Reservation(int id, int salleId, int coursId, String dateHeure, int duree) {
        this.id = id;
        this.salleId = salleId;
        this.coursId = coursId;
        this.dateHeure = dateHeure;
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalleId() {
        return salleId;
    }

    public void setSalleId(int salleId) {
        this.salleId = salleId;
    }

    public int getCoursId() {
        return coursId;
    }

    public void setCoursId(int coursId) {
        this.coursId = coursId;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
