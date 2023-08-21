package com.neebal.collegemgmt;

import com.neebal.collegemgmt.entities.Book;
import com.neebal.collegemgmt.entities.Student;
import com.neebal.collegemgmt.repository.BookRepository;
import com.neebal.collegemgmt.repository.StudentRepository;
import com.neebal.collegemgmt.services.BookStudentService;
//import com.neebal.collegemgmt.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableAsync
public class CollegeMgmtSystemApplication /*implements CommandLineRunner*/ {

	/*@Autowired
	private BookRepository bookRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BookStudentService bookStudentService;

	@Autowired
	private SendEmailService sendEmailService;*/

	public static void main(String[] args) {
		SpringApplication.run(CollegeMgmtSystemApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		//save a new book
		/*Book book = new Book("Prog in java", 900, 1500.0);
		this.bookRepository.save(book);
		System.out.println(book.getId());*/

		// save multiple book simultaneously
		/*Book b1 = new Book("The song of ice and fire", 1200, 6000.0);
		Book b2 = new Book("Kafka on the shore", 400, 3500.0);

		List<Book> list = Arrays.asList(b1, b2);
		this.bookRepository.saveAll(list);*/



		/*Student s1 = new Student("shrikant26", "123", 'M');
		Student s2 = new Student("chetan26", "456", 'M');
		Student s3 = new Student("Alexa", "789", 'F');

		List<Student> list = Arrays.asList(s1,s2,s3);
		this.studentRepository.saveAll(list);*/

		/*this.studentRepository.saveAll(
				Arrays.asList(
						new Student("shrikant26", "123", 'M'),
						new Student("chetan26", "456", 'M'),
						new Student("Alexa", "789", 'F')
				)
		);*/


		// find book with id 3
		/*this.bookRepository.findById(3l)
				.ifPresentOrElse(
						book -> System.out.println(book),
						()-> System.out.println("book not found")
				);*/

		// set pages of the book with id 2 to 800
		/*this.bookRepository.findById(2l)
				.ifPresentOrElse(
						book -> {
							book.setPages(800);
							bookRepository.save(book);
						},
						()-> System.out.println("book not found")
				);*/

		// delete a book where id is 3
		//this.bookRepository.deleteById(3l);

		// find all the books
		/*this.bookRepository.findAll()
				.forEach(book -> System.out.println(book));*/

		//count of all the books
		//System.out.println(this.bookRepository.count());

		// see whether book with given id exists or not
		//System.out.println(this.bookRepository.existsById(1l));
		//System.out.println(this.bookRepository.existsById(5l));

		//find all the books by price 3400
		/*this.bookRepository.findBookByPrice(3400.0)
				.forEach(book -> System.out.println(book));*/

		// find all the books by price greater than 1000
		/*this.bookRepository.findBookByPriceGreaterThan(1000.0)
				.forEach(book -> System.out.println(book));*/

		//find all the books by price greater than 1000 and pages less than 900

/*
		this.bookRepository.findBookByPriceGreaterThanAndPagesLessThan(1000.0, 900)
				.forEach(book -> System.out.println(book));
*/
		// count of all the books where pages are more than 200
		// System.out.println(this.bookRepository.countBookByPagesGreaterThan(200));

		// find all the books that have the word "Prog" in their title and sorted in desc
		/*bookRepository.findBookByTitleContainingOrderByPriceDesc("Prog")
				.forEach(book -> System.out.println(book));*/

		// check wether a book exists whose title starts with the word Prog
		//System.out.println(bookRepository.existsBookByTitleStartingWith("Prog"));

		// query for title, price of all books whose pages greater than 200
		/*bookRepository.findBookByPagesGreaterThan(200)
				.forEach(bookTitlePrice ->
						System.out.println(bookTitlePrice.getTitle()+" "+
								bookTitlePrice.getPrice()));*/

		// group the books by price and find the count of the groups
		/*bookRepository.groupByPriceCountBooks()
				.forEach(objects -> System.out.println(objects[0] + " " + objects[1]));*/

		// using NamedQuery

		/*this.bookRepository
				.queryBookByPriceLessThanEqual(2000.0)
				.forEach(book -> System.out.println(book));*/

		//this.bookStudentService.issueBook(1l,3l);

		//this.bookStudentService.returnBook(3l,3l);

		//this.bookStudentService.transferBook(2l,1l,3l);
		//this.sendEmailService.sendEmail("rajshreemohanrav@gmail.com", "Hi book is issued");

}
