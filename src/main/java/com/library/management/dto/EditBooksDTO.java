package com.library.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.management.model.Author;
import com.library.management.model.Book;
import com.library.management.model.Publisher;
import lombok.Data;

@Data
public class EditBooksDTO {
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

    @JsonProperty("bookId")
    private Long bookId;

    public Book toEditEntity(Book book) {
        if (this.bookName != null)
            book.setBookName(this.bookName);
        if (this.bookDetails != null)
            book.setBookDescription(this.bookDetails);
        if (this.bookImage != null)
            book.setBookImage(this.bookImage);
        if(book.getAuthor() != null) {
            Author author = book.getAuthor();
            if (this.authorDetails != null)
                author.setAuthorDetails(this.authorDetails);
            if (this.authorName != null)
                author.setAuthorName(this.authorName);
            if (this.authorAddress != null)
                author.setAuthorAddress(this.authorAddress);
            book.setAuthor(author);
        }
        if(book.getPublisher() != null) {
            Publisher publisher = book.getPublisher();
            if (this.publisherAddress != null)
                publisher.setPublisherAddress(this.publisherAddress);
            if (this.publisherDate != null)
                publisher.setPublisherDate(this.publisherDate);
            if (this.publisherName != null)
                publisher.setPublisherName(this.publisherName);
            book.setPublisher(publisher);
        }
        return book;
    }
}
