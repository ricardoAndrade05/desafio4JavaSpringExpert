package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query("SELECT m FROM Movie m WHERE (:genreId = 0 OR m.genre.id = :genreId) order by m.title")
	Page<Movie> findByGenre(Long genreId, Pageable pageable);

}
