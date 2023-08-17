package com.example.collegemgmt.controllers;

import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllBooks() throws Exception {
        List<Book> books = Arrays.asList(
                new Book("book 1",1000,900.0),
                new Book("book 2",1000,900.0)
        );

        given(bookRepository.findAll()).willReturn(books);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].title",is("BOOK 1")))
                .andExpect(jsonPath("$[1].title",is("BOOK 2")));
    }
}