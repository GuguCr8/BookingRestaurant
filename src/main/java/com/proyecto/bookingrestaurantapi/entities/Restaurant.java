package com.proyecto.bookingrestaurantapi.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDRESTAURANT", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "IMAGEN")
	private String image;
	
	//relacion para las reservations
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Reservation> reservations;
	
	//relacion para las boards
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Board> boards;
	
	//relacion para los Turns
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Turn> turns;

	public Long getId() {
		return id;
	}

	public void setIdRestaurant(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	public List<Turn> getTurns() {
		return turns;
	}

	public void setTurns(List<Turn> turns) {
		this.turns = turns;
	}
	
	


}
