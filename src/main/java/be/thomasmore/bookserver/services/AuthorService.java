package be.thomasmore.bookserver.services;

import be.thomasmore.bookserver.model.Author;
import be.thomasmore.bookserver.model.Book;
import be.thomasmore.bookserver.model.converters.AuthorDTOConverter;
import be.thomasmore.bookserver.model.converters.AuthorDetailedDTOConverter;
import be.thomasmore.bookserver.model.dto.AuthorDTO;
import be.thomasmore.bookserver.model.dto.AuthorDetailedDTO;
import be.thomasmore.bookserver.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorDTOConverter authorDTOConverter;
    @Autowired
    private AuthorDetailedDTOConverter authorDetailedDTOConverter;

    public List<AuthorDTO> findAll() {
        final List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(a -> authorDTOConverter.convertToDto(a))
                .collect(Collectors.toList());
    }

    public AuthorDetailedDTO findOne(int id) {
        final Optional<Author> author = authorRepository.findById(id);
        if (author.isEmpty())
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("Author with id %d does not exist.", id));
        return authorDetailedDTOConverter.convertToDto(author.get());
    }

    public AuthorDetailedDTO create(AuthorDetailedDTO authorDto) {
        if (authorRepository.findByName(authorDto.getName()).isPresent())
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("Author with name %s already exists.", authorDto.getName()));

        final Author author = authorDetailedDTOConverter.convertToEntity(authorDto);
        return authorDetailedDTOConverter.convertToDto(authorRepository.save(author));
    }

    public AuthorDetailedDTO edit(int id, AuthorDetailedDTO authorDto) {
        if (authorDto.getId() != id)
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("id in author (%d) does not match id in url (%d).", authorDto.getId(), id));

        final Optional<Author> authorFromDb = authorRepository.findById(id);
        if (authorFromDb.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Author with id %d not found.", id));

        //overwrite fields present in bookDto - relations are not touched
        final Author authorNewValues = authorDetailedDTOConverter.convertToEntity(authorDto, authorFromDb.get());
        final Author authorSaved = authorRepository.save(authorNewValues);
        return authorDetailedDTOConverter.convertToDto(authorSaved);
    }

    public void delete(int id) {
        final Optional<Author> authorFromDb = authorRepository.findById(id);
        if (authorFromDb.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Author with id %d not found.", id));

        final Set<Book> booksForAuthor = authorFromDb.get().getBooks();
        if (booksForAuthor != null && !booksForAuthor.isEmpty())
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("Author %s is still linked to books. Remove ", authorFromDb.get().getName()));

        authorRepository.deleteById(id);
    }
}
