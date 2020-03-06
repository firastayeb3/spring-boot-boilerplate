package com.virtualidentity.firstproject.authors.rest;
//package com.virtualidentity.myProjectName.authors.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


import com.virtualidentity.firstproject.authors.rest.TestVIController;
import com.virtualidentity.firstproject.generated.model.TestVI;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;


public class TestVIControllerTest {

  @Test
  public void WHEN_get_test_THEN_response_is_not_null() {
    // Arrange
    TestVIController viController = new TestVIController();

    // Act
    ResponseEntity<TestVI> test = viController.getStringTest();

    // Assert
    assertThat(test, is(notNullValue()));
  }

  @Test
  public void WHEN_get_test_THEN_response_contains_vi_string() {
    // Arrange
    TestVIController viController = new TestVIController();

    // Act
    ResponseEntity<TestVI> response = viController.getStringTest();

    // Assert
    TestVI test = response.getBody();
    assertThat(test, is(notNullValue()));
    assertThat(test.getValue(), is(equalTo("Virtual Identity")));
  }

}
