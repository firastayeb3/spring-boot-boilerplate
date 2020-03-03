package com.virtualidentity.firstproject.authors.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.virtualidentity.firstproject.common.rest.controller.BaseController;
import com.virtualidentity.firstproject.generated.AuthorsApi;
import com.virtualidentity.firstproject.generated.model.Author;
import com.virtualidentity.firstproject.generated.model.AuthorLinks;
import com.virtualidentity.firstproject.generated.model.AuthorList;
import com.virtualidentity.firstproject.generated.model.AuthorListLinks;
import com.virtualidentity.firstproject.generated.model.HalLink;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorController extends BaseController implements AuthorsApi {

  @Override
  public ResponseEntity<AuthorList> getAuthors(
      @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
      @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

    Author author1 = new Author()
        .firstname("Max")
        .lastname("Mustermann")
        .links(new AuthorLinks().self(getAuthorLink(1)));

    Author author2 = new Author()
        .firstname("Test")
        .lastname("User")
        .links(new AuthorLinks().self(getAuthorLink(2)));

    AuthorList authorList = new AuthorList()
        .embedded(Stream.of(author1, author2).collect(Collectors.toList()))
        .links(new AuthorListLinks()
            .self(getHalGetLink(methodOn(this.getClass()).getAuthors(limit, offset))));

    return new ResponseEntity<>(authorList, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Author> getAuthorById(@PathVariable("id") Integer id) {

    if (id == 1) {
      Author author = new Author()
          .firstname("Max")
          .lastname("Mustermann")
          .links(new AuthorLinks().self(getAuthorLink(id)));
      return new ResponseEntity<>(author, HttpStatus.OK);
    } else {
      throw new IllegalArgumentException("Could not find author");
    }
  }

  private HalLink getAuthorLink(Integer id) {
    return getHalGetLink(methodOn(this.getClass()).getAuthorById(id));
  }

}
