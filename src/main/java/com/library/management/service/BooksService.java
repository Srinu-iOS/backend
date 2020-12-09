package com.library.management.service;

import com.library.management.dto.AddBooksDTO;
import com.library.management.dto.EditBooksDTO;
import com.library.management.dto.LendBooksDTO;
import com.library.management.dto.Response.ResponseDTO;

public interface BooksService {
    ResponseDTO addBooks(AddBooksDTO addBooksDTO);

    ResponseDTO editBooks(EditBooksDTO editBooksDTO);

    ResponseDTO deleteBooks(Long bookId);

    ResponseDTO lendBooks(LendBooksDTO lendBooksDTO);

    ResponseDTO getLendBookList(Long userId);

    ResponseDTO returnLendBooks(LendBooksDTO lendBooksDTO);

    ResponseDTO getAdminBookList(Long userId);

    ResponseDTO searchBooks(String author, String bookName, String publisher, String bookCategory);

}
