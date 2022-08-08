package com.filmDetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmDetail.entity.Film;
@Repository
public interface IFilmRepository extends JpaRepository<Film, Long>{

}
