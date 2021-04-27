package com.springTutorial.spring5WebApp.initial;

import com.springTutorial.spring5WebApp.model.Author;
import com.springTutorial.spring5WebApp.model.Book;
import com.springTutorial.spring5WebApp.model.Publisher;
import com.springTutorial.spring5WebApp.repositories.AuthorRepository;
import com.springTutorial.spring5WebApp.repositories.BookRepository;
import com.springTutorial.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public InitialData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initial data");

        Publisher marvel = new Publisher();
        marvel.setName("Marvel Studio");
        marvel.setCity("Los Angeles");
        marvel.setState("California");

        publisherRepository.save(marvel);

        Author dwayne = new Author("Dwayne", "Johnson");
        Book rampage = new Book("Rampage 2019", "R20190504");

        dwayne.getBooks().add(rampage);
        rampage.getAuthors().add(dwayne);
        rampage.setPublisher(marvel);
        marvel.getBooks().add(rampage);

        authorRepository.save(dwayne);
        bookRepository.save(rampage);
        publisherRepository.save(marvel);

        Author tom = new Author("Tom", "Cruise");
        Book mission007 = new Book("Mission007", "M19960708");

        tom.getBooks().add(mission007);
        mission007.getAuthors().add(tom);
        mission007.setPublisher(marvel);
        marvel.getBooks().add(mission007);

        authorRepository.save(tom);
        bookRepository.save(mission007);
        publisherRepository.save(marvel);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Marvel publisher's number of Books: " + marvel.getBooks().size());
    }
}
