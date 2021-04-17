package com.esay2excel.crm.repository;

import com.esay2excel.crm.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
