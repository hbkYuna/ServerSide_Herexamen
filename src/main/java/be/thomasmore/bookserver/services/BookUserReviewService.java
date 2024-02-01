package be.thomasmore.bookserver.services;

import be.thomasmore.bookserver.model.Book;
import be.thomasmore.bookserver.model.BookUserReview;
import be.thomasmore.bookserver.model.dto.BookUserReviewDTO;
import be.thomasmore.bookserver.model.dto.BookUserReviewDetailedDTO;
import be.thomasmore.bookserver.repositories.BookRepository;
import be.thomasmore.bookserver.repositories.BookUserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookUserReviewService {

    @Autowired
    private BookUserReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<BookUserReviewDTO> getAllReviewsForBook(int bookId) {
        List<BookUserReview> reviews = reviewRepository.findAllByBook_Id(bookId);
        return reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public BookUserReviewDetailedDTO getReviewDetailsForBook(int bookId, int reviewId) {
        BookUserReview review = getReviewByIdAndBookId(reviewId, bookId);
        return convertToDetailedDto(review);
    }

    public BookUserReviewDetailedDTO createReview(int bookId, BookUserReviewDetailedDTO reviewDto) {
        BookUserReview review = convertToEntity(reviewDto);

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        review.setBook(book);

        BookUserReview savedReview = reviewRepository.save(review);
        return convertToDetailedDto(savedReview);
    }

    public BookUserReviewDetailedDTO editReview(int bookId, int reviewId, BookUserReviewDetailedDTO reviewDto) {
        BookUserReview existingReview = getReviewByIdAndBookId(reviewId, bookId);

        existingReview.setReview(reviewDto.getReview()); // Update review text
        BookUserReview savedReview = reviewRepository.save(existingReview);
        return convertToDetailedDto(savedReview);
    }

    private BookUserReview getReviewByIdAndBookId(int reviewId, int bookId) {
        Optional<BookUserReview> review = Optional.ofNullable(reviewRepository.findByIdAndBook_Id(reviewId, bookId));
        if (review.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Review with ID %d not found for book with ID %d.", reviewId, bookId));
        }
        return review.get();
    }

    private BookUserReviewDTO convertToDto(BookUserReview review) {
        BookUserReviewDTO dto = new BookUserReviewDTO();
        dto.setDate(review.getDate());
        dto.setUsername(review.getUser().getUsername());
        return dto;
    }

    private BookUserReviewDetailedDTO convertToDetailedDto(BookUserReview review) {
        BookUserReviewDetailedDTO dto = new BookUserReviewDetailedDTO();
        dto.setDate(review.getDate());
        dto.setReview(review.getReview());
        dto.setUsername(review.getUser().getUsername());
        return dto;
    }


    private BookUserReview convertToEntity(BookUserReviewDetailedDTO dto) {
        BookUserReview review = new BookUserReview();
        review.setDate(dto.getDate());
        review.setReview(dto.getReview());
        return review;
    }
}
