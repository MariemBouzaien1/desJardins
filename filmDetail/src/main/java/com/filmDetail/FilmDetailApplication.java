package com.filmDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.filmDetail.entity.Film;
import com.filmDetail.repository.IFilmRepository;

@SpringBootApplication
public class FilmDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmDetailApplication.class, args);
	}

	

}
