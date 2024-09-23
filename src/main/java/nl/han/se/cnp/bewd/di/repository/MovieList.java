package nl.han.se.cnp.bewd.di.repository;

import nl.han.se.cnp.bewd.di.domain.Movie;
import nl.han.se.cnp.bewd.di.exceptions.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieList {
    private List<Movie> movieList = new ArrayList<>();

    @Value("${movie1.title}")
    private String movieTitle1;

    @Value("${movie2.title}")
    private String movieTitle2;

    @Value("${movie3.title}")
    private String movieTitle3;

    public MovieList() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();
        movie1.setId("1");
        movie2.setId("2");
        movie3.setId("3");
        movie1.setName(movieTitle1);
        movie2.setName(movieTitle2);
        movie3.setName(movieTitle3);
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
    }

    public List<Movie> getProductList() {
        return movieList;
    }

    public Movie findMovieById(String id) {
        for (Movie movie : movieList) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        throw new MovieNotFoundException();
    }

}
