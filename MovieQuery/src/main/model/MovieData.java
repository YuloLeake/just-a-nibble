package main.model;

import java.text.MessageFormat;

/**
 * Created by Yulo Leake on 1/21/2017.
 */
public class MovieData {

    private String title;
    private String releaseDate;
    private String rating;
    private String runTime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String posterURL;
    private String metascore;
    private String imdbRating;
    private String tomatoMeter;
    private String tomatoRating;
    private String production;
    private String websiteURL;

    private MovieData(String title, String releaseDate, String rating, String runTime, String genre, String director, String writer, String actors, String plot, String posterURL, String metascore, String imdbRating, String tomatoMeter, String tomatoRating, String production, String websiteURL){
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.runTime = runTime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.posterURL = posterURL;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.tomatoMeter = tomatoMeter;
        this.tomatoRating = tomatoRating;
        this.production = production;
        this.websiteURL = websiteURL;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getTomatoMeter() {
        return tomatoMeter;
    }

    public String getTomatoRating() {
        return tomatoRating;
    }

    public String getProduction() {
        return production;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String toString(){
        String str = MessageFormat.format("Title: \"{0}\" (rated {1})\n", title, rating);
        str += MessageFormat.format("A {0} production movie\n", production);
        str += MessageFormat.format("Directed by {0}\n", director);
        str += MessageFormat.format("Written by {0}\n", writer);
        str += MessageFormat.format("Staring {0}\n", actors);
        str += MessageFormat.format("Released on {0}\n", releaseDate);
        str += MessageFormat.format("Plot: {0}\n", plot);

        str += "Critical Scores:\n";
        str += MessageFormat.format("\t{0}/100 (Metascore)\n", metascore);
        str += MessageFormat.format("\t{0}/10 (imdbRating)\n", imdbRating);
        str += MessageFormat.format("\t{0}/100 (Tomato Meter)\n", tomatoMeter);
        str += MessageFormat.format("\t{0}/10 (Tomato Rating)\n", tomatoRating);

        return str;
    }

    public static class MovieDataBuilder{

        private String title;
        private String releaseDate;
        private String rating;
        private String runTime;
        private String genre;
        private String director;
        private String writer;
        private String actors;
        private String plot;
        private String posterURL;
        private String metascore;
        private String imdbRating;
        private String tomatoMeter;
        private String tomatoRating;
        private String production;
        private String websiteURL;

        public MovieDataBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieDataBuilder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public MovieDataBuilder setRating(String rating) {
            this.rating = rating;
            return this;
        }

        public MovieDataBuilder setRunTime(String runTime) {
            this.runTime = runTime;
            return this;
        }

        public MovieDataBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieDataBuilder setDirector(String director) {
            this.director = director;
            return this;
        }

        public MovieDataBuilder setWriter(String writer) {
            this.writer = writer;
            return this;
        }

        public MovieDataBuilder setActors(String actors) {
            this.actors = actors;
            return this;
        }

        public MovieDataBuilder setPlot(String plot) {
            this.plot = plot;
            return this;
        }

        public MovieDataBuilder setPosterURL(String posterURL) {
            this.posterURL = posterURL;
            return this;
        }

        public MovieDataBuilder setMetascore(String metascore) {
            this.metascore = metascore;
            return this;
        }

        public MovieDataBuilder setImdbRating(String imdbRating) {
            this.imdbRating = imdbRating;
            return this;
        }

        public MovieDataBuilder setTomatoMeter(String tomatoMeter) {
            this.tomatoMeter = tomatoMeter;
            return this;
        }

        public MovieDataBuilder setTomatoRating(String tomatoRating) {
            this.tomatoRating = tomatoRating;
            return this;
        }

        public MovieDataBuilder setProduction(String production) {
            this.production = production;
            return this;
        }

        public MovieDataBuilder setWebsiteURL(String websiteURL) {
            this.websiteURL = websiteURL;
            return this;
        }

        public MovieData build() {
            return new MovieData(title, releaseDate, rating, runTime, genre, director, writer, actors, plot, posterURL, metascore, imdbRating, tomatoMeter, tomatoRating, production, websiteURL);
        }
    }

}
