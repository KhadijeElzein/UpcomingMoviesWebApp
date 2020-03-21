package br.com.khadije.upcomingmovieswebapp.wrapper;

import java.util.List;

import br.com.khadije.upcomingmovieswebapp.entity.Genre;
import lombok.Data;
@Data
public class GenreWrapper {
	private List<Genre> genres;
}
