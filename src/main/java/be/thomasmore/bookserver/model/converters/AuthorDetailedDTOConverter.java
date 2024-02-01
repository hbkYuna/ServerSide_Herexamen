package be.thomasmore.bookserver.model.converters;

import be.thomasmore.bookserver.model.Author;
import be.thomasmore.bookserver.model.dto.AuthorDetailedDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorDetailedDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param author the entity from the db
     * @return AuthorDetailedDTO object to send to the client.
     */
    public AuthorDetailedDTO convertToDto(Author author) {
        return modelMapper.map(author, AuthorDetailedDTO.class);
    }

    /**
     * @param authorDto the data from client that has to be converted
     * @param author:   the original author entity (from db) - this object will be overwritten with the data from authorDto
     * @return the modified author entity object - ready to save in the database
     */
    public Author convertToEntity(AuthorDetailedDTO authorDto, Author author) {
        modelMapper.map(authorDto, author);
        return author;
    }

    /**
     * @param authorDto the data from client that has to be converted
     * @return the modified author entity object - ready to save in the database
     */
    public Author convertToEntity(AuthorDetailedDTO authorDto) {
        return modelMapper.map(authorDto, Author.class);
    }

}
