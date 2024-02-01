package be.thomasmore.bookserver.controllers;

import be.thomasmore.bookserver.model.dto.AuthorDTO;
import be.thomasmore.bookserver.model.dto.AuthorDetailedDTO;
import be.thomasmore.bookserver.model.dto.BookDetailedDTO;
import be.thomasmore.bookserver.services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authors")
@Slf4j
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Operation(summary = "find all the authors that are stored in the database ")
    @GetMapping("")
    public Iterable<AuthorDTO> findAll() {
        log.info("##### findAll authors");
        return authorService.findAll();
    }

    @Operation(summary = "get 1 author from the database.",
            description = "Author with id is fetched from database. " +
                    "</br>" +
                    "The books Collection contains only id, title and authors-array. </br>" +
                    "Use GET api/books/{id} to fetch more info about the books. ")
    @GetMapping("{id}")
    public AuthorDetailedDTO findOne(@PathVariable int id) {
        log.info(String.format("##### findOne author %d", id));
        return authorService.findOne(id);
    }

    @Operation(summary = "create a new author in the database.",
            description = "Returns new author (containing id from database). ")
    @PostMapping("")
    public AuthorDetailedDTO create(@Valid @RequestBody AuthorDetailedDTO authorDTO) {
        log.info("##### create author");
        return authorService.create(authorDTO);
    }

    @Operation(summary = "edit existing author in the database.",
            description = "</br> Returns updated author. ")
    @PutMapping("{id}")
    public AuthorDetailedDTO edit(@PathVariable int id, @RequestBody AuthorDetailedDTO authorDTO) {
        log.info(String.format("##### edit author %d", id));
        return authorService.edit(id, authorDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info(String.format("##### delete author %d", id));
        authorService.delete(id);
    }
}
