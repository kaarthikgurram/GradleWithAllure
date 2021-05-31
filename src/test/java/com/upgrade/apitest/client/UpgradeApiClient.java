package com.upgrade.apitest.client;

import static io.restassured.RestAssured.given;

import com.upgrade.apitest.fixtures.UpgradeRequestContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class UpgradeApiClient {

  private static final Logger logger = LoggerFactory.getLogger(UpgradeApiClient.class);

  @Value("${upgrade.apiUrl}")
  private String baseUrl;

  public Response upgradeApiPost(UpgradeRequestContext upgradeRequestContext) {

    RestAssured.defaultParser = Parser.JSON;

    logger.info("Logging upgrade coding challenge request" + upgradeRequestContext);
    Response response =
        given()
            .header("x-cf-source-id", "coding-challenge")
            .header("x-cf-corr-id", "0fd2cd8a-bdbb-11eb-8529-0242ac130003")
            .contentType(ContentType.JSON)
            .body(upgradeRequestContext)
            .when()
            .post(baseUrl)
            .then()
            .contentType(ContentType.JSON)
            .extract()
            .response();

    logger.info("Logging upgrade coding challenge response" + response.prettyPrint());

    return response;
  }
}
