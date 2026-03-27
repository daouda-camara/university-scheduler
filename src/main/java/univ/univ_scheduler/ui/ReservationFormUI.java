package univ.univ_scheduler.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import univ.univ_scheduler.dao.CoursDAO;
import univ.univ_scheduler.dao.ReservationDAO;
import univ.univ_scheduler.dao.SalleDAO;
import univ.univ_scheduler.model.Cours;
import univ.univ_scheduler.model.Reservation;
import univ.univ_scheduler.model.Salle;

public class ReservationFormUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        ComboBox<Salle> salleComboBox = new ComboBox<>();
        ComboBox<Cours> coursComboBox = new ComboBox<>();
        DatePicker datePicker = new DatePicker();
        TextField heureField = new TextField();
        TextField dureeField = new TextField();

        Button submitButton = new Button("Réserver la Salle");
        submitButton.setOnAction(e -> reserverSalle(salleComboBox, coursComboBox, datePicker, heureField, dureeField));

        SalleDAO salleDAO = new SalleDAO();
        salleComboBox.getItems().addAll(salleDAO.getAllSalles());

        CoursDAO coursDAO = new CoursDAO();
        coursComboBox.getItems().addAll(coursDAO.getAllCours());

        salleComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Salle salle) {
                if (salle == null) {
                    return "";
                }
                return salle.getNumero() + " - Capacité: " + salle.getCapacite();
            }

            @Override
            public Salle fromString(String string) {
                return null;
            }
        });

        coursComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Cours cours) {
                if (cours == null) {
                    return "";
                }
                return cours.getMatiere() + " - " + cours.getClasse() + " (" + cours.getGroupe() + ")";
            }

            @Override
            public Cours fromString(String string) {
                return null;
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Salle :"), 0, 0);
        gridPane.add(salleComboBox, 1, 0);
        gridPane.add(new Label("Cours :"), 0, 1);
        gridPane.add(coursComboBox, 1, 1);
        gridPane.add(new Label("Date :"), 0, 2);
        gridPane.add(datePicker, 1, 2);
        gridPane.add(new Label("Heure (HH:MM) :"), 0, 3);
        gridPane.add(heureField, 1, 3);
        gridPane.add(new Label("Durée (en minutes) :"), 0, 4);
        gridPane.add(dureeField, 1, 4);
        gridPane.add(submitButton, 1, 5);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Réservation de Salle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void reserverSalle(ComboBox<Salle> salleComboBox, ComboBox<Cours> coursComboBox, DatePicker datePicker, TextField heureField, TextField dureeField) {
        Salle salle = salleComboBox.getValue();
        Cours cours = coursComboBox.getValue();
        if (salle == null || cours == null) {
            showError("Veuillez sélectionner une salle et un cours.");
            return;
        }
        if (datePicker.getValue() == null) {
            showError("Veuillez sélectionner une date.");
            return;
        }
        String heure = heureField.getText().trim();
        if (heure.isEmpty()) {
            showError("Veuillez saisir une heure (HH:MM).");
            return;
        }
        int duree;
        try {
            duree = Integer.parseInt(dureeField.getText().trim());
        } catch (NumberFormatException ex) {
            showError("La durée doit être un nombre.");
            return;
        }

        String dateHeure = datePicker.getValue() + " " + heure;

        SalleDAO salleDAO = new SalleDAO();
        Integer salleId = salleDAO.getSalleIdByNumero(salle.getNumero());
        if (salleId == null) {
            showError("Salle introuvable.");
            return;
        }

        ReservationDAO reservationDAO = new ReservationDAO();
        Reservation reservation = new Reservation(0, salleId, cours.getId(), dateHeure, duree);
        reservationDAO.addReservation(reservation);
        showAlert("Réservation réussie", "La salle a été réservée avec succès.");

        salleComboBox.setValue(null);
        coursComboBox.setValue(null);
        datePicker.setValue(null);
        heureField.clear();
        dureeField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
