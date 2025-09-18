package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookStore(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Category category1 = new Category("scifi");
			Category category2 = new Category("fiction");
			Category category3 = new Category("non-fiction");
			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);
			repository.save(new Book("Testi", "Testaaja", 2000, "9876543120123", "15,50", category1));
			repository.save(new Book("Testaamisen ilo", "Testaaja", 1999, "1234567890321", "19,99", category2));
			repository.save(new Book("Testaamisen latina", "Lorem Ipsum", 2025, "1133554488996", "29,99", category1));
			log.info("fetch books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
