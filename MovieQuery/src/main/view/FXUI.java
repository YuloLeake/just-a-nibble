package main.view;

/**
 * Created by Yulo Leake on 1/21/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controller.MyController;
import main.model.MovieQuery;
import main.model.data_provider.DataProvider;
import main.model.data_provider.UrlDataProvider;

import java.io.IOException;

public class FXUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Starting...");

        DataProvider dataProvider = new UrlDataProvider();
        MovieQuery movieQuery = new MovieQuery(dataProvider);

        // Loading the GUI view
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("app_view.fxml"));

        // Setting up the controller for this app
        MyController controller = new MyController(movieQuery, getHostServices());
        fxmlLoader.setController(controller);

        // Initializing and running app
        Parent content = fxmlLoader.load();
        Scene scene = new Scene(content, 1280, 720);

        stage.setTitle("Movie Database");
        stage.setMaxHeight(720);
        stage.setMinHeight(720);
        stage.setMaxWidth(1280);
        stage.setMinWidth(1280);
        stage.setScene(scene);
        stage.show();
    }
}

