package univ.univ_scheduler.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import univ.univ_scheduler.dao.SalleDAO;

public class SalleUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer une ListView pour afficher les salles
        ListView<String> listView = new ListView<>();

        // Charger les salles depuis la base de données
        SalleDAO salleDAO = new SalleDAO();
        salleDAO.getAllSalles().forEach(salle -> {
            listView.getItems().add(salle.getNumero() + " - Capacité: " + salle.getCapacite());
        });

        // Créer le layout
        StackPane root = new StackPane();
        root.getChildren().add(listView);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Gestion des Salles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
