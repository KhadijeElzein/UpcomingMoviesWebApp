package br.com.khadije.upcomingmovieswebapp.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.khadije.upcomingmovieswebapp.entity.UpcomingMovie;
import br.com.khadije.upcomingmovieswebapp.repository.UpcomingMoviesRepository;
import br.com.khadije.upcomingmovieswebapp.utils.ListDiffer;

@Service
@Component
public class UpcomingMoviesFacade {
	@Autowired
	UpcomingMoviesRepository movieRepository;
	public List<UpcomingMovie> listMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}
	
	public UpcomingMovie getMovieById(Long id) {
		return movieRepository.findById(id).get();
	}
	
	public List<UpcomingMovie> getMoviesByTitle(String title) {
		// TODO Auto-generated method stub
		return movieRepository.findByTitleContainsIgnoreCase(title);
	}
	
	public void saveMovies(List<UpcomingMovie> newMovies) {
		List<UpcomingMovie> oldMovies = movieRepository.findAll();
		if(oldMovies.isEmpty() && !newMovies.isEmpty()) movieRepository.saveAll(newMovies);
		else if(!newMovies.isEmpty()) {
			 ListDiffer<UpcomingMovie> differ = new ListDiffer<UpcomingMovie>(oldMovies,newMovies);
			 if(!differ.getAddedList().isEmpty())movieRepository.saveAll(differ.getAddedList());
			 if(!differ.getRemovedList().isEmpty()) movieRepository.deleteAll(differ.getRemovedList());;
		}
	}
}