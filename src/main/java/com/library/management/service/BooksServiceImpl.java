package com.library.management.service;

import com.library.management.Enum.UserTypeEnum;
import com.library.management.dto.AddBooksDTO;
import com.library.management.dto.EditBooksDTO;
import com.library.management.dto.LendBooksDTO;
import com.library.management.dto.Response.ResponseDTO;
import com.library.management.model.Author;
import com.library.management.model.Book;
import com.library.management.model.Publisher;
import com.library.management.model.User;
import com.library.management.repositories.AuthorRepository;
import com.library.management.repositories.BooksRepository;
import com.library.management.repositories.PublisherRepository;
import com.library.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public ResponseDTO addBooks(AddBooksDTO addBooksDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userRepository.findByUserId(addBooksDTO.getUserId());
        if(user != null) {
            if(user.getUserType() == UserTypeEnum.ADMIN.getUserTypeId()) {
                booksRepository.save(addBooksDTO.toSaveEntity());
                responseDTO.setCode(HttpStatus.OK.value());
                responseDTO.setMessage("Added Your book successfully");
            } else {
                responseDTO.setCode(HttpStatus.NOT_FOUND.value());
                responseDTO.setMessage("You are not allowed to add or edit");
            }
        } else {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("You are not allowed to add or edit");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO editBooks(EditBooksDTO editBooksDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        Book book = booksRepository.findByBookId(editBooksDTO.getBookId());
        if(book != null) {
            booksRepository.save(editBooksDTO.toEditEntity(book));
            responseDTO.setCode(HttpStatus.OK.value());
            responseDTO.setMessage("Updated successfully");
        } else {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("Book not found");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteBooks(Long bookId) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            booksRepository.delete(bookId);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("unable to delete");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO lendBooks(LendBooksDTO lendBooksDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        Book book = booksRepository.findByBookIdAndLendStatus(lendBooksDTO.getBookId(),false);
        if(book != null) {
            book.setLendUserId(lendBooksDTO.getUserId());
            book.setLendStatus(true);
            booksRepository.save(book);
            responseDTO.setCode(HttpStatus.OK.value());
            responseDTO.setMessage("You have lend this book successfully");
        } else {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("Book not available");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO returnLendBooks(LendBooksDTO lendBooksDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        Book book = booksRepository.findByBookIdAndLendStatus(lendBooksDTO.getBookId(),false);
        if(book != null) {
            book.setLendUserId(0L);
            book.setLendStatus(false);
            booksRepository.save(book);
            responseDTO.setCode(HttpStatus.OK.value());
            responseDTO.setMessage("You have return lend this book successfully");
        } else {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("Book not available");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO getLendBookList(Long userId) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<Book> bookList = booksRepository.findByLendUserId(userId);
        if(bookList.isEmpty()) {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("You have not lend any books");
        } else {
            responseDTO.setCode(HttpStatus.OK.value());
            responseDTO.setMessage("Books found");
            responseDTO.setData(bookList);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO getAdminBookList(Long userId) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<Book> bookList = booksRepository.findByUserId(userId);
        if(bookList.isEmpty()) {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("You have not lend any books");
        } else {
            responseDTO.setCode(HttpStatus.OK.value());
            responseDTO.setMessage("Books found");
            responseDTO.setData(bookList);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO searchBooks(String author, String bookName, String publisher, String bookCategory) {
        ResponseDTO responseDTO = new ResponseDTO();
        if(author != null) {
            List<Author> authorList = authorRepository.findAll();
            if(authorList != null) {
                List<Book> bookList = new ArrayList<>();
                for(Author author1:authorList) {
                    Book book = booksRepository.findByAuthorAndLendStatus(author1,false);
                    if(book != null) {
                        bookList.add(book);
                    }
                }
                responseDTO.setCode(HttpStatus.OK.value());
                responseDTO.setMessage("Books found");
                responseDTO.setData(bookList);
            } else {
                responseDTO.setCode(HttpStatus.NOT_FOUND.value());
                responseDTO.setMessage("You have not lend any books");
            }
        } else if(bookName != null || bookCategory != null) {
            List<Book> bookList = booksRepository.findByLendStatus(false);
            if(bookList != null) {
                responseDTO.setCode(HttpStatus.OK.value());
                responseDTO.setMessage("Books found");
                responseDTO.setData(bookList);
            } else {
                responseDTO.setCode(HttpStatus.NOT_FOUND.value());
                responseDTO.setMessage("You have not lend any books");
            }
        } else if(publisher != null) {
            List<Publisher> publisherList = publisherRepository.findAll();
            if(publisherList != null) {
                List<Book> bookList = new ArrayList<>();
                for(Publisher publisher1:publisherList) {
                    Book book = booksRepository.findByPublisherAndLendStatus(publisher1,false);
                    if(book != null) {
                        bookList.add(book);
                    }
                    responseDTO.setCode(HttpStatus.OK.value());
                    responseDTO.setMessage("Books found");
                    responseDTO.setData(bookList);
                }
            } else {
                responseDTO.setCode(HttpStatus.NOT_FOUND.value());
                responseDTO.setMessage("You have not lend any books");
            }
        }
        return responseDTO;
    }
}
