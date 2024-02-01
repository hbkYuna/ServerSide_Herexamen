package be.thomasmore.bookserver.model.converters;

import be.thomasmore.bookserver.model.Book;
import be.thomasmore.bookserver.model.dto.BookDTO;
import be.thomasmore.bookserver.model.dto.BookUserReviewDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookUserReviewDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BookUserReviewDTO convertToDto(Book book) {
        return modelMapper.map(book, BookUserReviewDTO.class);
    }
}
