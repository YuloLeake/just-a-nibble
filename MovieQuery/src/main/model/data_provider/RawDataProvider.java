package main.model.data_provider;

import main.model.MovieData;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Yulo Leake on 1/21/2017.
 *
 * For testing purposes, use HashMap to store JSON
 */
public class RawDataProvider implements DataProvider {

    private static final Map<String, MovieData> titleToMovieDataMap;
    static {
        titleToMovieDataMap = new HashMap<String, MovieData>();
        titleToMovieDataMap.put("Star Wars: Episode IV",
                new MovieData.MovieDataBuilder()
                        .setTitle("Star Wars: Episode IV - A New Hope")
                        .setReleaseDate("25 May 1977")
                        .setRunTime("121 min")
                        .setRating("PG")
                        .setGenre("Action, Adventure, Fantasy")
                        .setDirector("George Lucas")
                        .setWriter("George Lucas")
                        .setActors("Mark Hamill, Harrison Ford, Carrie Fisher, Peter Cushing")
                        .setPlot("Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a wookiee and two droids to save the galaxy from the Empire's world-destroying battle-station, while also attempting to rescue Princess Leia from the evil Darth Vader.")
                        .setPosterURL("https://images-na.ssl-images-amazon.com/images/M/MV5BYzQ2OTk4N2QtOGQwNy00MmI3LWEwNmEtOTk0OTY3NDk2MGJkL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_SX300.jpg")
                        .setMetascore("92")
                        .setImdbRating("8.7")
                        .setTomatoMeter("93")
                        .setTomatoRating("8.6")
                        .setProduction("20th Century Fox")
                        .setWebsiteURL("http://www.starwars.com/episode-iv/")
                        .build());

        titleToMovieDataMap.put("Star Wars: Episode V",
                new MovieData.MovieDataBuilder()
                        .setTitle("Star Wars: Episode V - The Empire Strikes Back")
                        .setReleaseDate("20 Jun 1980")
                        .setRunTime("124 min")
                        .setRating("PG")
                        .setGenre("Action, Adventure, Fantasy")
                        .setDirector("Irvin Kershner")
                        .setWriter("Leigh Brackett (screenplay), Lawrence Kasdan (screenplay), George Lucas (story by)")
                        .setActors("Mark Hamill, Harrison Ford, Carrie Fisher, Billy Dee Williams")
                        .setPlot("After the rebels have been brutally overpowered by the Empire on their newly established base, Luke Skywalker takes advanced Jedi training with Master Yoda, while his friends are pursued by Darth Vader as part of his plan to capture Luke.")
                        .setPosterURL("https://images-na.ssl-images-amazon.com/images/M/MV5BYmViY2M2MTYtY2MzOS00YjQ1LWIzYmEtOTBiNjhlMGM0NjZjXkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_SX300.jpg")
                        .setMetascore("81")
                        .setImdbRating("8.8")
                        .setTomatoMeter("94")
                        .setTomatoRating("8.9")
                        .setProduction("20th Century Fox")
                        .setWebsiteURL("http://www.starwars.com/episode-v/")
                        .build());

        titleToMovieDataMap.put("Star Wars: Episode VI",
                new MovieData.MovieDataBuilder()
                        .setTitle("Star Wars: Episode VI - Return of the Jedi")
                        .setReleaseDate("25 May 1983")
                        .setRunTime("131 min")
                        .setRating("PG")
                        .setGenre("Action, Adventure, Fantasy")
                        .setDirector("Richard Marquand")
                        .setWriter("Lawrence Kasdan (screenplay), George Lucas (screenplay), George Lucas (story by)")
                        .setActors("Mark Hamill, Harrison Ford, Carrie Fisher, Billy Dee Williams")
                        .setPlot("After rescuing Han Solo from the palace of Jabba the Hutt, the rebels attempt to destroy the second Death Star, while Luke struggles to make Vader return from the dark side of the Force.")
                        .setPosterURL("https://images-na.ssl-images-amazon.com/images/M/MV5BODllZjg2YjUtNWEzNy00ZGY2LTgyZmQtYTkxNDYyOWM3OTUyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg")
                        .setMetascore("53")
                        .setImdbRating("8.4")
                        .setTomatoMeter("80")
                        .setTomatoRating("7.2")
                        .setProduction("20th Century Fox")
                        .setWebsiteURL("http://www.starwars.com/episode-vi/")
                        .build());

    }

    @Override
    public MovieData getMovieData(String title) {
        MovieData movieData = titleToMovieDataMap.get(title);

        if(movieData == null){
            throw new NoSuchElementException("Error: Movie with title \"" + title + "\" was not found in database");
        }

        return movieData;
    }


}
