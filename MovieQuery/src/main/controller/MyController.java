package main.controller;

import javafx.application.HostServices;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.model.MovieQuery;
import main.model.MovieData;

/**
 * Created by Yulo Leake on 1/23/2017.
 */
public class MyController {

    // View components, initialized auto-magically (ugh) by JavaFX
    @FXML
    private TextField searchBar;
    @FXML
    private Button searchButton;
    @FXML
    private Label metascore;
    @FXML
    private Label imdb;
    @FXML
    private Label tomatoMeter;
    @FXML
    private Label tomatoRating;
    @FXML
    private ImageView moviePoster;
    @FXML
    private Label movieTitle;
    @FXML
    private Label releaseDate;
    @FXML
    private Label directedBy;
    @FXML
    private Label writtenBy;
    @FXML
    private Label staring;
    @FXML
    private Label plot;

    private MovieQuery movieQuery;
    private HostServices hostServices;

    public MyController(MovieQuery movieQuery, HostServices hostServices){
        this.movieQuery = movieQuery;
        this.hostServices = hostServices;
    }

    // This is called when the search button is clicked
    // Again, connecting the logic to gui component happens auto-magically (eww)
    @FXML
    private void onSearchButtonClicked(){
        // Get user input
        String searchQuery = searchBar.getText();
        System.out.println("User typed: " + searchQuery);
        searchBar.clear();

        // Get movie data
        final MovieData data = movieQuery.getMovieData(searchQuery);
        if(data != null){
            // If we actually got the data
            movieTitle.setText(data.getTitle());
            releaseDate.setText(data.getReleaseDate());
            directedBy.setText(data.getDirector());
            writtenBy.setText(data.getWriter());
            staring.setText(data.getActors());
            plot.setText(data.getPlot());

            metascore.setText(data.getMetascore());
            imdb.setText(data.getImdbRating());
            tomatoMeter.setText(data.getTomatoMeter());
            tomatoRating.setText(data.getTomatoRating());

            moviePoster.setImage(new Image(data.getPosterURL()));
            moviePoster.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    // open website
                    hostServices.showDocument(data.getWebsiteURL());
                }
            });
        } else{
            // If no data was given
            movieTitle.setText("Movie not found");
            releaseDate.setText("");
            directedBy.setText("");
            writtenBy.setText("");
            staring.setText("");
            plot.setText("");

            metascore.setText("");
            imdb.setText("");
            tomatoMeter.setText("");
            tomatoRating.setText("");

            moviePoster.setImage(null);
            moviePoster.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    // do nothing
                }
            });
        }
    }
}
