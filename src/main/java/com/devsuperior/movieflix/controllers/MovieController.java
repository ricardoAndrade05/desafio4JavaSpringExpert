package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@Autowired
	private ReviewService reviewService;
	
	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_VISITOR')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDetailsDTO> movieById(@PathVariable Long id) {
		MovieDetailsDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_VISITOR')")
	@GetMapping
	public ResponseEntity<Page<MovieDetailsDTO>> moviesByGenre(@RequestParam(defaultValue = "0") String genreId,Pageable pageable) {
		Page<MovieDetailsDTO> page = service.findByGenre(genreId, pageable);
		return ResponseEntity.ok().body(page);
	}
		
	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_VISITOR')")
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<List<ReviewDTO>> movieReview(@PathVariable Long id) {
		List<ReviewDTO> reviewsDTO = reviewService.findReviewsByIdMovie(id);
		return ResponseEntity.ok().body(reviewsDTO);
	}
	
}
