package br.com.khadije.upcomingmovieswebapp.facade;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.khadije.upcomingmovieswebapp.repository.GenreRepository;
import br.com.khadije.upcomingmovieswebapp.utils.MethodUtils;
import br.com.khadije.upcomingmovieswebapp.wrapper.GenreWrapper;
@Service
@Component
public class GenreFacade {
	@Autowired
	GenreRepository genreRepository;
	@Value("${movieapi.genreurl}")
	private String genreUrl;
	public void saveGenre() throws JsonMappingException, JsonProcessingException {
		MethodUtils methodUtils = new MethodUtils();
	    GenreWrapper genre = (GenreWrapper) methodUtils.callAPI(genreUrl,new TypeReference<GenreWrapper>(){});
	    if(Objects.nonNull(genre)) {
	    	genreRepository.saveAll(genre.getGenres());
	    }
	}
}
