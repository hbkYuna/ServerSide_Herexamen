package be.thomasmore.bookserver.model.converters;

import be.thomasmore.bookserver.model.BookUserReview;
import be.thomasmore.bookserver.model.dto.BookUserReviewDetailedDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookUserReviewDetailedDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BookUserReviewDetailedDTO convertToDto(BookUserReview bookUserReview) {
        return modelMapper.map(bookUserReview, BookUserReviewDetailedDTO.class);
    }

    public BookUserReview convertToEntity(BookUserReviewDetailedDTO bookUserReviewDetailedDTO) {
        return modelMapper.map(bookUserReviewDetailedDTO, BookUserReview.class);
    }
}
