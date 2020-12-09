package com.library.management.controller;

import com.library.management.dto.AddBooksDTO;
import com.library.management.dto.EditBooksDTO;
import com.library.management.dto.Response.ResponseDTO;
import com.library.management.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ManageBookController {
    @Autowired
    BooksService booksService;

    @PostMapping("/addBooks")
    public ResponseDTO addBooks(@RequestBody AddBooksDTO addBooksDTO) {
        return booksService.addBooks(addBooksDTO);
    }

    @PutMapping("/editBooks")
    public ResponseDTO editBooks(@RequestBody EditBooksDTO editBooksDTO) {
        return booksService.editBooks(editBooksDTO);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseDTO deleteBooks(@PathVariable Long bookId) {
        return booksService.deleteBooks(bookId);
    }

    @GetMapping("/getAdminBookList/{userId}")
    public ResponseDTO getAdminBookList(@PathVariable Long userId) {
        return booksService.getAdminBookList(userId);
    }
}
