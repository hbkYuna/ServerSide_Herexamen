package be.thomasmore.bookserver.model;

import jakarta.validation.constraints.Size;
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
    @Column
    private Date date;

    @Size(max = 1024, message = "Review text should not exceed 1024 characters")
    @Column(length = 1024)    // Geen idee of de lenght achter Column nu overbodig is maar ik laat zet ze erbij voor de zekerheid.
    @NotBlank(message = "Review text should not be blank")
    private String review;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
