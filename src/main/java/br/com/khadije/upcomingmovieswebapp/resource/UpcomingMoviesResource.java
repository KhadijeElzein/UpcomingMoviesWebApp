package br.com.khadije.upcomingmovieswebapp.resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.khadije.upcomingmovieswebapp.facade.UpcomingMoviesFacade;

import org.springframework.http.ResponseEntity;
import br.com.khadije.upcomingmovieswebapp.entity.UpcomingMovie;
@RestController
@CrossOrigin
@RequestMapping(path = "/v1.0/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class UpcomingMoviesResource {

	@Autowired
    UpcomingMoviesFacade facade;
	@GetMapping
    public ResponseEntity<List<UpcomingMovie>> listMovies(){
		List<UpcomingMovie> movies = facade.listMovies();
    	return ResponseEntity.ok(movies);
	}
	@GetMapping("/{id}")
    public ResponseEntity<UpcomingMovie> getMovieById(@PathVariable Long id){
		UpcomingMovie movie = facade.getMovieById(id);
    	return ResponseEntity.ok(movie);
	}
	@GetMapping(params="title")
    public ResponseEntity<List<UpcomingMovie>> getMoviesByTitle(@RequestParam String title){
		List<UpcomingMovie> movies = facade.getMoviesByTitle(title);
    	return ResponseEntity.ok(movies);
	}
}
