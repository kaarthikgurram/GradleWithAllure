package com.upgrade.apitest.client;

import static io.restassured.RestAssured.given;

import com.upgrade.apitest.fixtures.UpgradeRequestContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UpgradeApiClient {

  private static final Logger logger = LoggerFactory.getLogger(UpgradeApiClient.class);

  @Value("${upgrade.apiUrl}")
  private String baseUrl;

  private String xcfsourceid = "coding-challenge";
  private String xcfcorrid = UUID.randomUUID().toString();

  public UpgradeApiClient() {
    System.out.println("value of base url is " + baseUrl);
  }

  public Response upgradeApiPost(UpgradeRequestContext upgradeRequestContext) {
    return upgradeApiPost(upgradeRequestContext, xcfsourceid, xcfcorrid);
  }

  public Response upgradeApiPost(
      UpgradeRequestContext upgradeRequestContext, String xcfsourceid, String xcfcorrid) {

    logger.info("Logging upgrade coding challenge request" + upgradeRequestContext.toString());
    Response response =
        given()
            .header("x-cf-source-id", xcfsourceid)
            .header("x-cf-corr-id", xcfcorrid)
            .contentType(ContentType.JSON)
            .body(upgradeRequestContext)
            .when()
            .post(baseUrl);

    logger.info("Logging upgrade coding challenge response" + response.prettyPrint());

    return response;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
    System.out.println("called setter method");
  }
}
