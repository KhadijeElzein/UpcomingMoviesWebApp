package br.com.khadije.upcomingmovieswebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.khadije.upcomingmovieswebapp.entity.UpcomingMovie;

public interface UpcomingMoviesRepository  extends JpaRepository<UpcomingMovie,Long>{
	List<UpcomingMovie> findByTitleContainsIgnoreCase(String title);


}