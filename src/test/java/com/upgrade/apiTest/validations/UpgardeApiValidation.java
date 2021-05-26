package com.upgrade.apiTest.validations;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.response.Response;
import java.util.List;
import org.apache.tomcat.util.json.JSONParser;
import org.junit.Assert;
import org.springframework.stereotype.Component;

@Component
public class UpgardeApiValidation {

  public void validateApprovedApiResponse(Response response) {

    Assert.assertEquals(200, response.statusCode());
    Assert.assertEquals("Ian", response.jsonPath().get("firstName"));
    Assert.assertEquals("9114917", response.jsonPath().get("userId").toString());
    Assert.assertEquals(
        "34c16f53-38c4-461a-bd14-11fa748d2663", response.jsonPath().get("userUuid"));
    Assert.assertEquals("FULL", response.jsonPath().get("authenticationLevel"));
  }
}
