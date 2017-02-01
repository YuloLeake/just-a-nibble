package main.model.data_provider;

import main.model.MovieData;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.NoSuchElementException;

/**
 * Created by Yulo Leake on 1/21/2017.
 */
public class UrlDataProvider implements DataProvider {

    @Override
    public MovieData getMovieData(String title) {
        MovieData movieData = null;

        try {
            String json = readJsonFromQuery(generateURL(title));
            movieData = jsonToMovieData(json);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e){
            throw e;
        }

        return movieData;
    }

    private URL generateURL(String title){
        URL url = null;
        try {
            url = new URI("http","www.omdbapi.com", "/", "t=" + title + "&y=&plot=short&r=json&tomatoes=true", null).toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String readJsonFromQuery(URL url) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String content = "";
        String line = reader.readLine();
        while(line != null){
            content += line;
            line = reader.readLine();
        }
        reader.close();

        return content;
    }

    private MovieData jsonToMovieData(String json){
        JSONObject obj = new JSONObject(json);
        if(obj.has("Error")){
            throw new NoSuchElementException("Movie not found!");
        }
        return new MovieData.MovieDataBuilder()
                .setTitle(obj.getString("Title"))
                .setReleaseDate(obj.getString("Released"))
                .setRunTime(obj.getString("Runtime"))
                .setRating(obj.getString("Rated"))
                .setGenre(obj.getString("Genre"))
                .setDirector(obj.getString("Director"))
                .setWriter(obj.getString("Writer"))
                .setActors(obj.getString("Actors"))
                .setPlot(obj.getString("Plot"))
                .setPosterURL(obj.getString("Poster"))
                .setMetascore(obj.getString("Metascore"))
                .setImdbRating(obj.getString("imdbRating"))
                .setTomatoMeter(obj.getString("tomatoMeter"))
                .setTomatoRating(obj.getString("tomatoRating"))
                .setProduction(obj.getString("Production"))
                .setWebsiteURL(obj.getString("Website"))
                .build();
    }
}
