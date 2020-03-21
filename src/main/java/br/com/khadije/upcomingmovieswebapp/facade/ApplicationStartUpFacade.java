package br.com.khadije.upcomingmovieswebapp.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.khadije.upcomingmovieswebapp.entity.UpcomingMovie;
import br.com.khadije.upcomingmovieswebapp.utils.MethodUtils;
import br.com.khadije.upcomingmovieswebapp.wrapper.MoviePaginatedResponse;
@Service
@Component
public class ApplicationStartUpFacade {
	@Autowired
	GenreFacade genreFacade;
	@Autowired
	UpcomingMoviesFacade moviesFacade;
	private int pagenum;
	private MethodUtils methodUtils;
	private int totalPages;
	private List<UpcomingMovie> newMovies;
	@Value("${movieapi.moviesurl}")
	private String moviesUrl;
	@Value("${movieapi.imagebaseurl}")
	private String imageBaseUrl;
	@Value("${movieapi.noimageplaceholderurl}")
	private String noImagePlaceholderUrl;
	public ApplicationStartUpFacade() {
		this.methodUtils = new MethodUtils();
		this.pagenum = 1;
		this.totalPages = 1;
		this.newMovies = new ArrayList<>();
	}

	public void SyncAPIData() throws JsonMappingException, JsonProcessingException {
		genreFacade.saveGenre();
		do {
	    MoviePaginatedResponse movies = (MoviePaginatedResponse) methodUtils.callAPI(moviesUrl+pagenum,new TypeReference<MoviePaginatedResponse>(){});
	    if(Objects.nonNull(movies)) {
	    	totalPages = movies.getTotal_pages();
	    	movies.getMovies().stream().filter(Objects::nonNull).forEach(element -> {
	    		if(element.getPoster()!= null) element.setPoster(imageBaseUrl+element.getPoster());
	    		else if(element.getPoster() == null && element.getBackdrop() == null) {
	    			element.setPoster(noImagePlaceholderUrl);
	    			element.setBackdrop(noImagePlaceholderUrl);
	    		}else if(element.getPoster() == null) element.setPoster(imageBaseUrl+element.getBackdrop());
	    		element.setBackdrop(imageBaseUrl+element.getBackdrop());
	    		newMovies.add(element);
	    	});
		    pagenum++;
	    }else break;
	  }while(pagenum <= totalPages);
	  moviesFacade.saveMovies(newMovies);
	}
}
