package org.java.lessons.springboot.bestoftheyear.controller;

import org.java.lessons.springboot.bestoftheyear.model.Movie;
import org.java.lessons.springboot.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final String name = "Manuel";

    @GetMapping("/")
    public String index(Model model) {
        int year = Year.now().getValue();
        model.addAttribute("currentYear", year);
        model.addAttribute("myName", name);
        model.addAttribute("movies", getBestMovies());
        model.addAttribute("songs", getBestSongs());
        return "home";
    }

    private List<Movie> getBestMovies() {
        Movie[] moviesArray = {
                new Movie("01", "The Godfather"),
                new Movie("02", "Fight Club"),
                new Movie("03", "The Matrix"),
                new Movie("04", "Star Wars"),
                new Movie("05", "Oppenheimer")
        };
        return new ArrayList<>(Arrays.asList(moviesArray));
    }

    private List<Song> getBestSongs() {
        Song[] songsArray = {
                new Song("01", "Highway to Hell"),
                new Song("02", "I Want to Break Free"),
                new Song("03", "Radioactive"),
                new Song("04", "Turn Down for What"),
                new Song("05", "The Final Countdown")
        };
        return new ArrayList<>(Arrays.asList(songsArray));
    }

    @GetMapping("movies/{id}")
    public String movieDetail(@PathVariable("id") String id, Model model) {
        Movie movie = getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie-details";
    }

    private Movie getMovieById(String id) {
        for(Movie movie : getBestMovies()) {
            if(movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    @GetMapping("songs/{id}")
    public String songDetail(@PathVariable("id") String id, Model model) {
        Song song = getSongById(id);
        model.addAttribute("song", song);
        return "song-details";
    }

    private Song getSongById(String id) {
        for(Song song : getBestSongs()) {
            if(song.getId().equals(id)) {
                return song;
            }
        }
        return null;
    }
}



