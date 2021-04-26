package com.springTutorial.spring5WebApp.repositories;

import com.springTutorial.spring5WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
