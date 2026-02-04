package com.devsuperior.movieflix.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreDTO;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {
	
	@GetMapping
	public ResponseEntity<Page<GenreDTO>> genres(
			@RequestParam(defaultValue = "") String name,
			Pageable pageable) {
		Page<GenreDTO> list = null;
		return ResponseEntity.ok().body(list);
	}

}
