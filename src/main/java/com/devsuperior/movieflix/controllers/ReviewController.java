package com.devsuperior.movieflix.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.ReviewDTO;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

	@PostMapping
	public ResponseEntity<ReviewDTO> newReview(@RequestBody ReviewDTO dto) {
		dto = null;
		URI uri = null;
		return ResponseEntity.created(uri).body(dto);
	}
}
