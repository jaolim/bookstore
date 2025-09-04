package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookStore(BookRepository repository) {
		return (args) -> {
			log.info("Saving some test books");
			repository.save(new Book("Testi", "Testaaja", "2000", "9876543120123", "15,50"));
			repository.save(new Book("Testaamisen ilo", "Testaaja", "1999", "1234567890321", "19,99"));

			log.info("fetch books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
