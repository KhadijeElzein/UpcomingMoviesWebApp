package br.com.khadije.upcomingmovieswebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.khadije.upcomingmovieswebapp.entity.Genre;

public interface GenreRepository  extends JpaRepository<Genre,Long>{

}