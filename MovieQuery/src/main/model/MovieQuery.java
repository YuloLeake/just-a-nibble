package main.model;

import main.model.data_provider.DataProvider;

import java.util.NoSuchElementException;

/**
 * Created by Yulo Leake on 1/23/2017.
 *
 * Meh, probably an useless class that kinda acts like an adapter class for DataProvider.
 */
public class MovieQuery {

    private final DataProvider provider;

    public MovieQuery(DataProvider provider){
        this.provider = provider;
    }

    public MovieData getMovieData(String title){
        try{
            return provider.getMovieData(title);
        } catch (NoSuchElementException e){
            return null;
        }
    }
}
