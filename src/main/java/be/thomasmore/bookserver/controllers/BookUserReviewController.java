package be.thomasmore.bookserver.controllers;

import be.thomasmore.bookserver.model.dto.BookUserReviewDTO;
import be.thomasmore.bookserver.model.dto.BookUserReviewDetailedDTO;
import be.thomasmore.bookserver.services.BookUserReviewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/{bookId}/reviews")
@Slf4j
public class BookUserReviewController {

    @Autowired
    private BookUserReviewService bookUserReviewService;

    @Operation(summary = "Get all reviews for a book with only date and username.")
    @GetMapping("")
    public List<BookUserReviewDTO> getAllReviewsForBook(@PathVariable int bookId) {
        log.info(String.format("##### Get all reviews for book %d", bookId));
        return bookUserReviewService.getAllReviewsForBook(bookId);
    }

    @Operation(summary = "Get details of a specific review for a book.")
    @GetMapping("/{reviewId}")
    public BookUserReviewDetailedDTO getReviewDetailsForBook(@PathVariable int bookId, @PathVariable int reviewId) {
        log.info(String.format("##### Get details of review %d for book %d", reviewId, bookId));
        return bookUserReviewService.getReviewDetailsForBook(reviewId, bookId);
    }


    @Operation(summary = "Create a new review for a book.")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BookUserReviewDetailedDTO createReviewForBook(
            @PathVariable("bookId") int bookId,
            @RequestBody BookUserReviewDetailedDTO reviewDto
    ) {
        log.info(String.format("##### Create a new review for book %d", bookId));
        return bookUserReviewService.createReview(bookId, reviewDto);
    }

    @Operation(summary = "Edit an existing review for a book.")
    @PutMapping("/{reviewId}")
    public BookUserReviewDetailedDTO editReviewForBook(@PathVariable int bookId, @PathVariable int reviewId, @RequestBody BookUserReviewDetailedDTO reviewDto) {
        log.info(String.format("##### Edit review %d for book %d", reviewId, bookId));
        return bookUserReviewService.editReview(bookId, reviewId, reviewDto);
    }
}
