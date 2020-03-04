package com.virtualidentity.firstproject.authors.rest;

import com.virtualidentity.firstproject.common.rest.controller.BaseController;
import com.virtualidentity.firstproject.generated.TestVIApi;
import com.virtualidentity.firstproject.generated.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class TestVIController extends BaseController implements TestVIApi {

    @Override
    public ResponseEntity<TestVI> getStringTest() {

        TestVI vi = new TestVI().value("Virtual Identity");

        return new ResponseEntity<>(vi, HttpStatus.OK);
    }
}
