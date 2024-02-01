package be.thomasmore.bookserver.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class BookUserReviewDetailedDTO {

    private Date date;
    private String username;
    private String review;

    private BookDTO book;
    private UserDTO user;

}
