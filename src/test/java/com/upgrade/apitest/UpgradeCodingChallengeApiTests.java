package com.upgrade.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.upgrade.apitest.client.UpgradeApiClient;
import com.upgrade.apitest.fixtures.UpgradeRequestContext;
import com.upgrade.apitest.validations.UpgradeApiValidation;
import com.upgrade.frontend.Application;
import io.restassured.response.Response;
import java.util.UUID;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = Application.class)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpgradeCodingChallengeApiTests {

  @Autowired UpgradeApiClient upgradeApiClient;

  UpgradeRequestContext upgradeRequestContext;

  @Autowired UpgradeApiValidation upgradeApiValidation;

  @BeforeEach
  public void beforeEach() {
    upgradeRequestContext = new UpgradeRequestContext();
  }

  @Test
  public void upgradeApi_happyPath_acceptedResponse() throws JSONException {

    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext);
    upgradeApiValidation.validateApprovedApiResponse(apiResponse);
  }

  @Test
  public void upgradeApi_invalidUsername_declineWithUnAuthorized() {

    Response apiResponse =
        upgradeApiClient.upgradeApiPost(upgradeRequestContext.username("wrongUserName"));
    upgradeApiValidation.validateErrorResponse(apiResponse);
  }

  @Test
  public void upgradeApi_invalidPassword_declineWithUnAuthorized() {

    Response apiResponse =
        upgradeApiClient.upgradeApiPost(upgradeRequestContext.password("wrongPassword"));
    upgradeApiValidation.validateErrorResponse(apiResponse);
  }

  @Test
  public void upgradeApi_invalidRecaptcha_approvedResponse() throws JSONException {

    Response apiResponse =
        upgradeApiClient.upgradeApiPost(upgradeRequestContext.recaptchaToken("invalidRecaptcha"));
    upgradeApiValidation.validateApprovedApiResponse(apiResponse);
  }

  @Test
  public void upgradeApi_nullUsername_declineWithBadRequest() {

    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext.username(null));
    upgradeApiValidation.validateBadRequest(apiResponse, ("username"));
  }

  @Test
  public void upgradeApi_nullPassword_declineWithBadRequest() {

    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext.password(null));
    upgradeApiValidation.validateBadRequest(apiResponse, ("password"));
  }

  @Test
  public void upgradeApi_nullRecaptcha_acceptedResponse() throws JSONException {

    Response apiResponse =
        upgradeApiClient.upgradeApiPost(upgradeRequestContext.recaptchaToken(null));
    upgradeApiValidation.validateApprovedApiResponse(apiResponse);
  }

  @Test
  public void upgradeApi_invalidXcfSourceId_acceptedResponse() throws JSONException {

    Response apiResponse =
        upgradeApiClient.upgradeApiPost(
            upgradeRequestContext, "invalidSourceId", UUID.randomUUID().toString());
    upgradeApiValidation.validateApprovedApiResponse(apiResponse);
  }

  @Test
  public void upgradeApi_invalidXcfCorrId_acceptedResponse() throws JSONException {

    Response apiResponse =
        upgradeApiClient.upgradeApiPost(
            upgradeRequestContext, "coding-challenge", "randomString");
    assertEquals(500, apiResponse.statusCode());
  }
}
