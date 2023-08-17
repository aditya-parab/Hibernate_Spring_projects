package com.example.collegemgmt;

import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.entities.BookStudent;
import com.example.collegemgmt.entities.Student;
import com.example.collegemgmt.repository.BookRepository;
import com.example.collegemgmt.repository.BookStudentRepository;
import com.example.collegemgmt.repository.StudentRepository;
import com.example.collegemgmt.services.BookStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableAsync
public class   CollegeMgmtSystemApplication {


	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BookStudentRepository bookStudentRepository;

	@Autowired
	private BookStudentService bookStudentService;

	public static void main(String[] args) {
		SpringApplication.run(CollegeMgmtSystemApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
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
//			this.bookRepository.findBookByTitleContainingOrderByPriceDesc("prog")
//					.forEach(book -> System.out.println(book.getTitle()));

		//check whether a book exists whose title starts with word prog
//		System.out.println(this.bookRepository.existsBookByTitleStartingWith("prog"));

		//query for title,price of all books  whose pages greater than 200
//		bookRepository.findBookByPagesGreaterThan(200)
//				.forEach(bookTitlePrice -> {
//					System.out.println(bookTitlePrice.getTitle()+ " "+ bookTitlePrice.getPrice());
//				});

		//group the books by price and find the count of groups
//		bookRepository.groupByPriceCountBooks()
//				.forEach(objects -> System.out.println(objects[0]+" "+objects[1]));

//		this.bookRepository
//				.queryBookByPriceLessThanEqual(200.0)
//				.forEach(book -> System.out.println(book.getTitle()));

//this.studentRepository
//		.saveAll(Arrays.asList(new Student("cheemu","619",'m'),
//				new Student("meow","1748",'f'),
//				new Student("janestreet","22",'f')
//				));



//		this.bookStudentService.transferBook(3l,2l,4l);

//		this.bookStudentService.issueBook(5l,4l);


//	}

}
