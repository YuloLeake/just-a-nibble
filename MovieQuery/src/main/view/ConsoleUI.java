package main.view;

import main.model.MovieQuery;
import main.model.MovieData;
import main.model.data_provider.DataProvider;
import main.model.data_provider.UrlDataProvider;

import java.util.Scanner;

/**
 * Created by Yulo Leake on 1/21/2017.
 */
public class ConsoleUI {

    public static void main(String[] args){
        DataProvider dataProvider = new UrlDataProvider();
        MovieQuery movieQuery = new MovieQuery(dataProvider);

        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        do{
            System.out.print("Enter a movie title (or \"EXIT\" to exit): ");
            userInput = scanner.nextLine();

            // Query for movie data based on given user input
            MovieData movieData = movieQuery.getMovieData(userInput);

            if(movieData == null){
                System.out.println("Movie by the title \"" + userInput  + "\" was not found.");
            } else {
                System.out.println(movieData);
            }
        }while(!userInput.equals("EXIT"));
    }
}
