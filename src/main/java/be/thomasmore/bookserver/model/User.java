package be.thomasmore.bookserver.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "BOOKSUSER")
@Data
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    String username;
    String password;
    String role;

    @OneToMany
    private List<BookUserReview> reviews;
}
