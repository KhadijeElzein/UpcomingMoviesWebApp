package br.com.khadije.upcomingmovieswebapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="Movie")
public class UpcomingMovie implements Serializable{

	private static final long serialVersionUID = -5524697044712805424L;
	
	@Id
	@EqualsAndHashCode.Include
	@Column(name="movieId")
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(columnDefinition="text", name="overview")
	private String overview;
	
	@Column(name = "releasedate")
	@JsonProperty("release_date")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;	
	
	@Column(name="backdrop_path")
	@JsonProperty("backdrop_path")
	private String backdrop;
	
	@Column(name="posterpath")
	@JsonProperty("poster_path")
	private String poster;
	
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "MovieGenre",
            joinColumns = {@JoinColumn(name = "movieId")},
            inverseJoinColumns = {@JoinColumn(name = "genreId")}
    )
	@JsonProperty("genre_ids")
    private Set<Genre> genres = new HashSet<>();
	
}