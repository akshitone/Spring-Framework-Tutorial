package com.springTutorial.spring5WebApp.initial;

import com.springTutorial.spring5WebApp.model.Author;
import com.springTutorial.spring5WebApp.model.Book;
import com.springTutorial.spring5WebApp.repositories.AuthorRepository;
import com.springTutorial.spring5WebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public InitialData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author dwayne = new Author("Dwayne", "Johnson");
        Book rampage = new Book("Rampage 2019", "R20190504");
        dwayne.getBooks().add(rampage);
        rampage.getAuthors().add(dwayne);
        authorRepository.save(dwayne);
        bookRepository.save(rampage);

        Author tom = new Author("Tom", "Cruise");
        Book mission007 = new Book("Mission007","M19960708");
        tom.getBooks().add(mission007);
        mission007.getAuthors().add(tom);
        authorRepository.save(tom);
        bookRepository.save(mission007);

        System.out.println("Initial data");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
