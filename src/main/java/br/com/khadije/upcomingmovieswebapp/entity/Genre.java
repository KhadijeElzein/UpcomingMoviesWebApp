package br.com.khadije.upcomingmovieswebapp.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Genre")
public class Genre implements Serializable{

	private static final long serialVersionUID = -5524697044712805424L;

	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "name",updatable=false)
	@JsonProperty("name")
	private String genreName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
	private Set<UpcomingMovie> movies = new HashSet<>();
	public Genre(int id) {
	    this.id = id;
	}
	public Genre() {
		
	}
}