package com.devsuperior.movieflix.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@GetMapping
	public ResponseEntity<Page<MovieCardDTO>> moviesByGenre(@RequestParam(defaultValue = "0") String genreId,Pageable pageable) {
		Page<MovieCardDTO> page = null;
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieCardDTO> movieById(@PathVariable Long id) {
		MovieCardDTO dto = null;
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<MovieDetailsDTO> movieReview(@PathVariable Long id) {
		MovieDetailsDTO dto = null;
		return ResponseEntity.ok().body(dto);
	}
	
}
