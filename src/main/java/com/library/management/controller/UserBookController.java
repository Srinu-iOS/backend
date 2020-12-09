package com.library.management.controller;

import com.library.management.dto.LendBooksDTO;
import com.library.management.dto.Response.ResponseDTO;
import com.library.management.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserBookController {
    @Autowired
    BooksService booksService;

    @PutMapping("/user/lendBooks")
    public ResponseDTO lendBooks(@RequestBody LendBooksDTO lendBooksDTO) {
        return booksService.lendBooks(lendBooksDTO);
    }

    @PutMapping("/user/return/lendBooks")
    public ResponseDTO returnLendBooks(@RequestBody LendBooksDTO lendBooksDTO) {
        return booksService.returnLendBooks(lendBooksDTO);
    }

    @GetMapping("/user/getLendBookList/{userId}")
    public ResponseDTO getLendBookList(@PathVariable Long userId) {
        return booksService.getLendBookList(userId);
    }

    @GetMapping("/search/books")
    public ResponseDTO searchBooks(@RequestParam(value = "author", required = false) String author,
                                   @RequestParam(value = "bookName", required = false) String bookName,
                                   @RequestParam(value = "publisher", required = false) String publisher,
                                   @RequestParam(value = "bookCategory", required = false) String bookCategory) {
        return booksService.searchBooks(author,bookName,publisher,bookCategory);
    }
}
