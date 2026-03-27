package univ.univ_scheduler.ui;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import univ.univ_scheduler.service.EmploiDuTempsService;
import univ.univ_scheduler.model.Cours;

import java.sql.SQLException;
import java.util.List;

public class EmploiDuTempsUI extends Application {

    @Override
    public void start(Stage stage) {
        EmploiDuTempsService emploiDuTempsService = new EmploiDuTempsService();
        TableView<Cours> tableView = new TableView<>();

        // Définition des colonnes
        TableColumn<Cours, String> matiereColumn = new TableColumn<>("Matière");
        matiereColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMatiere()));

        TableColumn<Cours, String> classeColumn = new TableColumn<>("Classe");
        classeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClasse()));

        TableColumn<Cours, String> groupeColumn = new TableColumn<>("Groupe");
        groupeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGroupe()));

        tableView.getColumns().addAll(matiereColumn, classeColumn, groupeColumn);

        // Charger l'emploi du temps
        try {
            List<Cours> emploiDuTemps = emploiDuTempsService.genererEmploiDuTemps();
            tableView.getItems().setAll(emploiDuTemps);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Emploi du Temps");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
