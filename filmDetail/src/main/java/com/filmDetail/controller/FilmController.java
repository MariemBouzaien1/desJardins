package com.filmDetail.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmDetail.entity.Film;
import com.filmDetail.repository.IFilmRepository;

@RestController
@RequestMapping("/api")
public class FilmController {

	@Autowired
	IFilmRepository filmRepo;
	
	
	@GetMapping("/film/{id}")
	public ResponseEntity<Film> getFilmById(@PathVariable(name = "id") Long  id) {

		Optional<Film> optional = filmRepo.findById(id);

		if (optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("/film")
	public List<Film> saveFilm(@RequestBody Film film) {
		film.getActeurs().forEach((acteur) -> {
			acteur.setFilm(film);
		   });

		filmRepo.save(film);
		return filmRepo.findAll();

	}

}
