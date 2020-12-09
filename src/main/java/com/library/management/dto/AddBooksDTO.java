package com.library.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.management.model.Author;
import com.library.management.model.Book;
import com.library.management.model.Publisher;
import lombok.Data;

@Data
public class AddBooksDTO {
    @JsonProperty("bookName")
    private String bookName;

    @JsonProperty("bookDetails")
    private String bookDetails;

    @JsonProperty("bookImage")
    private String bookImage;

    @JsonProperty("authorDetails")
    private String authorDetails;

    @JsonProperty("authorName")
    private String authorName;

    @JsonProperty("authorAddress")
    private String authorAddress;

    @JsonProperty("publisherAddress")
    private String publisherAddress;

    @JsonProperty("publisherDate")
    private String publisherDate;

    @JsonProperty("publisherName")
    private String publisherName;

    @JsonProperty("userId")
    private Long userId;

    public Book toSaveEntity() {
        Book book = new Book();
        book.setBookName(this.bookName);
        book.setBookDescription(this.bookDetails);
        book.setUserId(this.userId);
        book.setBookImage(this.bookImage);
        Author author = new Author();
        author.setAuthorDetails(this.authorDetails);
        author.setAuthorName(this.authorName);
        author.setAuthorAddress(this.authorAddress);
        book.setAuthor(author);
        Publisher publisher = new Publisher();
        publisher.setPublisherAddress(this.publisherAddress);
        publisher.setPublisherDate(this.publisherDate);
        publisher.setPublisherName(this.publisherName);
        book.setPublisher(publisher);
        return book;
    }
}
