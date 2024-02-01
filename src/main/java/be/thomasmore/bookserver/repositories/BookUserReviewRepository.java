package be.thomasmore.bookserver.repositories;

import be.thomasmore.bookserver.model.BookUserReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookUserReviewRepository extends JpaRepository<BookUserReview, Integer> {

    List<BookUserReview> findAllByBook_Id(int bookId);

    BookUserReview findByIdAndBook_Id(int reviewId, int bookId);

    Optional<BookUserReview> findByUser_IdAndBook_Id(int userId, int bookId);
}
