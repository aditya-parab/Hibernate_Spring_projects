package com.neebal.collegemgmt.controllers;

import com.neebal.collegemgmt.entities.Book;
import com.neebal.collegemgmt.exceptions.ResourceNotFoundException;
import com.neebal.collegemgmt.repository.BookRepository;
import com.neebal.collegemgmt.repository.BookStudentRepository;
import com.neebal.collegemgmt.services.BookStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookStudentRepository bookStudentRepository;

    @Autowired
    BookStudentService bookStudentService;


    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return this.bookRepository
                .findAll()
                .stream()
                .map(book -> {
                        book.setTitle(book.getTitle().toUpperCase());
                        return book;
                        }
                ).collect(Collectors.toList());
    }

    @GetMapping("/{bookId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable Long bookId){

        Book book = this.bookRepository.findById(bookId)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("book with id %s is not found", bookId)
                ));
        return book;
    }




    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId){
        if(!this.bookRepository.existsById(bookId)){
            throw new ResourceNotFoundException(
                    String.format("book with id %s is not found", bookId)
            );
        }
        this.bookRepository.deleteById(bookId);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody Book book){
        Book newBook = this.bookRepository.save(book);
        return newBook;
    }

    //issue book
    @PostMapping("/{bookId}/students/{studentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void issueBook(@PathVariable Long bookId, @PathVariable Long studentId){
        bookStudentService.issueBook(bookId,studentId);

    }

    //return book
    @PutMapping("/{bookId}/students/{studentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void returnBook(@PathVariable Long bookId, @PathVariable Long studentId){
        bookStudentService.returnBook(bookId,studentId);

    }

    //transfer book
    @PostMapping("/{bookId}/students/{fromStudentId}/students/{toStudentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void transferBook(@PathVariable Long bookId, @PathVariable Long fromStudentId, @PathVariable Long toStudentId){
        bookStudentService.transferBook(bookId,fromStudentId,toStudentId);

    }

}
