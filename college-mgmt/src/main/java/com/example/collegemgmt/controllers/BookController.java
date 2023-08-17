package com.example.collegemgmt.controllers;


import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.exceptions.ResourceNotFoundException;
import com.example.collegemgmt.repository.BookRepository;
import com.example.collegemgmt.repository.BookStudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookStudentRepository bookStudentRepository;

    @GetMapping //annotation specifies GET for REST
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        List<Book> books = this.bookRepository.findAll()
                .stream()
                .map(book -> {book.setTitle(book.getTitle().toUpperCase());
                return book;})
                .collect(Collectors.toList());

        return books;

    }

//    @GetMapping("/{bookId}")
//    public ResponseEntity getBook(@PathVariable Long bookId){
//        Book book = this.bookRepository.findBookById(bookId);
//        if(book==null){
//            return new ResponseEntity("Book not found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(book, HttpStatus.OK);
//
//    }

    @GetMapping("/{bookId}")
    @ResponseBody
    public Book getBook(@PathVariable Long bookId) throws ResourceNotFoundException{

        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("book with id %s not found",bookId)));
                return book;
    }

//    @DeleteMapping("/{bookId}")
//    public ResponseEntity deleteBook(@PathVariable Long bookId){
//        Book book = this.bookRepository.findBookById(bookId);
//        if(book==null){
//            return new ResponseEntity("Book not found", HttpStatus.NOT_FOUND);
//        }
//
//
//        this.bookRepository.deleteById(bookId);
//        return new ResponseEntity<>("Book was deleted", HttpStatus.NO_CONTENT);
//
//    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId){
        Book book = this.bookRepository.findBookById(bookId);
        if(book==null){
            throw new ResourceNotFoundException(String.format("Book with id %s not found",bookId));
        }


       this.bookRepository.deleteById(bookId);


    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody Book book){
        Book newBook = this.bookRepository.save((book));
        return newBook;


    }
}
