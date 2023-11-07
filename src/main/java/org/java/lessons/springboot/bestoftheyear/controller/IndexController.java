package org.java.lessons.springboot.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final String name = "Manuel";
    @GetMapping("/")
    public String index(Model model){
        //prendo l'anno corrente
        int year = Year.now().getValue();
        // prendo il mio nome

        // li assegno a degli attributi
        model.addAttribute("currentYear", year);
        model.addAttribute("myName", name);
        return "home";
    }

    //    metodo privato per restituire una lista di titoli di film chiamato getBestMovies()
    private List<String> getBestMovies(){
        String[] moviesArray = {"The Godfather", "The Shawshank Redemption", "Schindler's List", "Raging Bull", "Casablanca", "Citizen Kane", "Gone with the Wind", "The Wizard of Oz", "One Flew Over the Cuckoo's Nest", "Lawrence of Arabia"};
        List<String> movies = new ArrayList<>(Arrays.asList(moviesArray));
        return movies;
    }
    // metodo privato per restituire una lista di titoli di canzoni chiamato getBestSongs()
    private List<String> getBestSongs(){
        String[] songsArray = {"Like a Rolling Stone", "Satisfaction", "Imagine", "What's Going On", "Respect", "Good Vibrations", "Johnny B. Goode", "Hey Jude", "Smells Like Teen Spirit", "What'd I Say"};
        List<String> songs = new ArrayList<>(Arrays.asList(songsArray));
        return songs;
    }
    // metodo publico che risponde all'url "/movies" e restituisce la pagina "movies"
    @GetMapping("movies")
    public String movies(Model model) {
        List<String> myMovies = getBestMovies();
        String bestMovies = String.join(", ", myMovies);
        model.addAttribute("movies", bestMovies);
        return "home";
    }

    @GetMapping("songs")
    public String songs(Model model) {
        List<String> mySongs = getBestSongs();
        String bestSongs = String.join(", ", mySongs);
        model.addAttribute("songs", bestSongs);
        return "home";
    }
}
