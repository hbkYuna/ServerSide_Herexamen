package be.thomasmore.bookserver.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "book_user_review")
public class BookUserReview {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @NotNull(message = "Review date should not be null")
    @Column(name = "date")
    private Date date;

    @Column(name = "review", length = 1024)
    @NotBlank(message = "Review text should not be blank")
    private String review;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
