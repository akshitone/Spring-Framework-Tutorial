package com.springTutorial.spring5WebApp.repositories;

import com.springTutorial.spring5WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
