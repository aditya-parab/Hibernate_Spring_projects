package com.example.collegemgmt;

import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class   CollegeMgmtSystemApplication implements CommandLineRunner {


	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CollegeMgmtSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Book book1 = new Book("progress in java",900,150.0);
//		this.bookRepository.save(book);
//		System.out.println(book.getId());
//		Book book2 = new Book("progress in java2",9300,150.0);
//		Book book3 = new Book("progress in java3",93300,150.0);
//		List<Book> books = Arrays.asList(book1,book2,book3);
//
		//save all books
//		this.bookRepository.saveAll(books);

		//find book by id, change it and resave it in session
//		this.bookRepository.findById(1l)
//				.ifPresentOrElse(
//						(book)-> {
//							System.out.println(book);
//							book.setPages(10);
//							this.bookRepository.save(book);
//						},
//						()-> System.out.println("book not found")
//				);

		//delete a book
//		this.bookRepository.deleteById(1l);
//		this.bookRepository.findAll()
//				.forEach(book -> System.out.println(book.getId()));

		//count all books
//		System.out.println(this.bookRepository.count());

		//check if book exists or not
//		System.out.println(this.bookRepository.existsById(2l));

		//dynamic finders example
		//find books greater than price
//		this.bookRepository.findBookByPrice(150.0)
//				.forEach(book -> System.out.println(book.getTitle()));

		// find all books by price greater than 10
//		this.bookRepository.findBookByPriceGreaterThan(10.0)
//				.forEach(book -> System.out.println(book.getTitle()));

		//find all books by price greater than 1000 and pages less than 900
//		this.bookRepository.findBookByPriceGreaterThanAndPagesLessThan(100.0,9500)
//				.forEach(book -> System.out.println(book.getTitle()));

		//count of all the books where pages is more than 200
//		int ans = this.bookRepository.countBookByPagesGreaterThan(900);
//		System.out.println(ans);

		//find all books that have "prog" in title, sorted in desc order of price
			this.bookRepository.findBookByTitleContainingOrderByPriceDesc("prog")
					.forEach(book -> System.out.println(book.getTitle()));






	}

}
