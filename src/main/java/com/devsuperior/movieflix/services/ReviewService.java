package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		User user = authService.authenticated();
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		Review review = new Review(null, dto.getText(), movie, user);
		review = repository.save(review);
		return new ReviewDTO(review);
	}

	@Transactional(readOnly = true)
	public List<ReviewDTO> findReviewsByIdMovie(Long id) {
		List<Review> reviews = repository.findAllByMovieId(id);
		return reviews.stream().map(x -> new ReviewDTO(x)).toList();
	}

}
