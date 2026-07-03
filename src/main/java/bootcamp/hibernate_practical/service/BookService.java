package bootcamp.hibernate_practical.service;

import bootcamp.hibernate_practical.dto.BookResponse;
import bootcamp.hibernate_practical.dto.CreateBookRequest;
import bootcamp.hibernate_practical.dto.UpdateBookRequest;
import bootcamp.hibernate_practical.entity.Book;
import bootcamp.hibernate_practical.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook(CreateBookRequest request) {
        Book book = new Book(
                request.getTitle(),
                request.getAuthor(),
                request.getGenre(),
                request.getPublicationYear(),
                true
        );
        Book savedBook = bookRepository.save(book);
        return mapToResponse(savedBook);
    }

    public List<BookResponse> getAllBooks() {

        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::mapToResponse).toList();
    }

    public BookResponse getBookById(Long id) {

        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("no book found with id: " + id));
        return mapToResponse(book);
    }

    public BookResponse updateBook(Long id, UpdateBookRequest request) {

        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("no book no found with id: " + id));
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setGenre(request.getGenre());
        book.setPublicationYear(request.getPublicationYear());
        book.setAvailable(request.isAvailable());

        Book updatedBook = bookRepository.save(book);

        return mapToResponse(updatedBook);
    }

    public void deleteBook(Long id) {

        bookRepository.findById(id).orElseThrow(()->new RuntimeException("no book found with id: " + id));
        bookRepository.deleteById(id);
    }

    public List<BookResponse> findByAuthor(String author) {

        return bookRepository.findByAuthor(author).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<BookResponse> findAvailableBooks(){

        return bookRepository.findByAvailableTrue().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private BookResponse mapToResponse(Book book) {

        return new BookResponse(

                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getPublicationYear(),
                book.isAvailable()

        );

    }
}
