package univ.univ_scheduler.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import univ.univ_scheduler.dao.SalleDAO;
import univ.univ_scheduler.model.Salle;

public class SalleFormUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création des champs de formulaire
        TextField numeroField = new TextField();
        numeroField.setPromptText("Numéro de la Salle");

        TextField capaciteField = new TextField();
        capaciteField.setPromptText("Capacité");

        ComboBox<String> typeSalleComboBox = new ComboBox<>();
        typeSalleComboBox.getItems().addAll("TD", "TP", "Amphi");
        typeSalleComboBox.setPromptText("Type de Salle");

        Button submitButton = new Button("Ajouter la Salle");
        submitButton.setOnAction(e -> addSalle(numeroField, capaciteField, typeSalleComboBox));

        // Créer un GridPane pour disposer les éléments du formulaire
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Numéro :"), 0, 0);
        gridPane.add(numeroField, 1, 0);
        gridPane.add(new Label("Capacité :"), 0, 1);
        gridPane.add(capaciteField, 1, 1);
        gridPane.add(new Label("Type de Salle :"), 0, 2);
        gridPane.add(typeSalleComboBox, 1, 2);
        gridPane.add(submitButton, 1, 3);

        // Création de la scène
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Ajouter une Salle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode pour ajouter une salle à la base de données
    private void addSalle(TextField numeroField, TextField capaciteField, ComboBox<String> typeSalleComboBox) {
        String numero = numeroField.getText();
        int capacite = Integer.parseInt(capaciteField.getText());
        String type = typeSalleComboBox.getValue();

        // Créer la salle et l'ajouter à la base de données
        Salle salle = new Salle(numero, capacite, type);
        SalleDAO salleDAO = new SalleDAO();
        salleDAO.addSalle(salle);
        System.out.println("Salle ajoutée avec succès.");

        // Reset des champs après ajout
        numeroField.clear();
        capaciteField.clear();
        typeSalleComboBox.setValue(null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
