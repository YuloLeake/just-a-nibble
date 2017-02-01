package main.model.data_provider;

import main.model.MovieData;

/**
 * Created by Yulo Leake on 1/21/2017.
 */
public interface DataProvider {
    MovieData getMovieData(String title);
}
