package com.virtualidentity.firstproject.authors.rest;

import com.virtualidentity.firstproject.common.rest.controller.BaseController;
import com.virtualidentity.firstproject.generated.AuthorsApi;
import com.virtualidentity.firstproject.generated.TestApi;
import com.virtualidentity.firstproject.generated.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class TestVIController extends BaseController implements TestApi {

    @Override
    public ResponseEntity<Test> getStringTest(
            @RequestParam(value = "limit", required = false, defaultValue = "0") Integer limit,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

        Test vi = new Test().value("Virtual Identity");

        return new ResponseEntity<Test>(vi, HttpStatus.OK);
    }
}
