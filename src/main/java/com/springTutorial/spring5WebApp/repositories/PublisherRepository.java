package com.springTutorial.spring5WebApp.repositories;

import com.springTutorial.spring5WebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
