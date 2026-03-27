package univ.univ_scheduler.service;



import univ.univ_scheduler.dao.CoursDAO;
import univ.univ_scheduler.model.Cours;
import java.sql.SQLException;
import java.util.List;

public class EmploiDuTempsService {

    private CoursDAO coursDAO;

    public EmploiDuTempsService() {
        this.coursDAO = new CoursDAO();
    }

    // Méthode pour récupérer tous les cours et générer un emploi du temps global
    public List<Cours> genererEmploiDuTemps() throws SQLException {
        return coursDAO.getAllCours();
    }
}
