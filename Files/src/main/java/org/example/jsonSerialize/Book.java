package org.example.jsonSerialize;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int pageNumber;
    private int agePublished;


    public Book(String title, String isbn, String author, int pageNumber, int agePublished) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.pageNumber = pageNumber;
        this.agePublished = agePublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getAgePublished() {
        return agePublished;
    }

    public void setAgePublished(int agePublished) {
        this.agePublished = agePublished;
    }


    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                ", agePublished=" + agePublished +
                '}';
    }
}
