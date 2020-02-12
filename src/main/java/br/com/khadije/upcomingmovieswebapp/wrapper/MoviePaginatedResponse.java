package br.com.khadije.upcomingmovieswebapp.wrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.khadije.upcomingmovieswebapp.entity.UpcomingMovie;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviePaginatedResponse {
	@JsonProperty("results")
	private List<UpcomingMovie> movies;
	@JsonProperty("page")
	private Integer page;
	@JsonProperty("total_results")
	private Integer total_results;
	@JsonProperty("total_pages")
	private Integer total_pages;
}
