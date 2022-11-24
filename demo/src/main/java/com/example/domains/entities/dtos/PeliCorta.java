package com.example.domains.entities.dtos;

import org.springframework.data.rest.core.config.Projection;

import com.example.domains.entities.Film;

@Projection(name = "PeliCorta", types = Film.class)
public interface PeliCorta {
	int getFilmId();
	String getTitle();
}
