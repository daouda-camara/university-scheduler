package univ.univ_scheduler.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UniversitySchedulerUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("University Scheduler");

        VBox vbox = new VBox();
        Button btnAddRoom = new Button("Ajouter une salle");
        Button btnAddCourse = new Button("Ajouter un cours");

        btnAddRoom.setOnAction(e -> System.out.println("Ajout d'une salle..."));
        btnAddCourse.setOnAction(e -> System.out.println("Ajout d'un cours..."));

        vbox.getChildren().addAll(btnAddRoom, btnAddCourse);

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
