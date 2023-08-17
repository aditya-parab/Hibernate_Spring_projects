package com.neebal.collegemgmt.controllers;

import com.neebal.collegemgmt.entities.Book;
import com.neebal.collegemgmt.exceptions.ResourceNotFoundException;
import com.neebal.collegemgmt.repository.BookRepository;
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
        /*final ResponseEntity[] re = new ResponseEntity[1];
        this.bookRepository.findById(bookId)
                .ifPresentOrElse(
                        book-> re[0] = new ResponseEntity(book, HttpStatus.OK),
                        ()-> re[0] = new ResponseEntity("Not found", HttpStatus.NOT_FOUND)
                );
        return re[0];*/
        Book book = this.bookRepository.findById(bookId)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("book with id %s is not found", bookId)
                ));
        return book;
    }

    /*@DeleteMapping("/{bookId}")
    public ResponseEntity deleteBook(@PathVariable Long bookId){
        if(!this.bookRepository.existsById(bookId)){
            return new ResponseEntity("book not found", HttpStatus.NOT_FOUND);
        }
        this.bookRepository.deleteById(bookId);
        return new ResponseEntity("",HttpStatus.NO_CONTENT);
    }*/


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
}
