package univ.univ_scheduler.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import univ.univ_scheduler.dao.CoursDAO;
import univ.univ_scheduler.model.Cours;

public class CoursFormUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField matiereField = new TextField();
        matiereField.setPromptText("Matière");

        TextField enseignantIdField = new TextField();
        enseignantIdField.setPromptText("ID Enseignant (optionnel)");

        TextField classeField = new TextField();
        classeField.setPromptText("Classe");

        TextField groupeField = new TextField();
        groupeField.setPromptText("Groupe");

        Button submitButton = new Button("Ajouter le Cours");
        submitButton.setOnAction(e -> addCours(matiereField, enseignantIdField, classeField, groupeField));

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Matière :"), 0, 0);
        gridPane.add(matiereField, 1, 0);
        gridPane.add(new Label("Enseignant ID :"), 0, 1);
        gridPane.add(enseignantIdField, 1, 1);
        gridPane.add(new Label("Classe :"), 0, 2);
        gridPane.add(classeField, 1, 2);
        gridPane.add(new Label("Groupe :"), 0, 3);
        gridPane.add(groupeField, 1, 3);
        gridPane.add(submitButton, 1, 4);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Ajouter un Cours");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addCours(TextField matiereField, TextField enseignantIdField, TextField classeField, TextField groupeField) {
        String matiere = matiereField.getText();
        String enseignantText = enseignantIdField.getText().trim();
        Integer enseignantId = null;
        if (!enseignantText.isEmpty()) {
            try {
                enseignantId = Integer.parseInt(enseignantText);
            } catch (NumberFormatException ex) {
                showError("L'ID enseignant doit être un nombre.");
                return;
            }
        }
        String classe = classeField.getText();
        String groupe = groupeField.getText();

        Cours cours = new Cours(0, matiere, enseignantId, classe, groupe);
        CoursDAO coursDAO = new CoursDAO();
        coursDAO.addCours(cours);
        System.out.println("Cours ajouté avec succès.");

        matiereField.clear();
        enseignantIdField.clear();
        classeField.clear();
        groupeField.clear();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
