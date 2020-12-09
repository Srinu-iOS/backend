package com.library.management.repositories;

import com.library.management.model.Author;
import com.library.management.model.Book;
import com.library.management.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Long> {
    Book findByBookIdAndLendStatus(Long bookId, Boolean lendStatus);

    Book findByBookId(Long bookId);

    Book findByAuthorAndLendStatus(Author author, Boolean lendStatus);

    Book findByPublisherAndLendStatus(Publisher publisher, Boolean lendStatus);

    List<Book> findByLendUserId(Long lendUserId);

    List<Book> findByUserId(Long userId);

    List<Book> findByLendStatus(Boolean lendStatus);
}
