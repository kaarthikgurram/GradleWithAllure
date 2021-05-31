package com.upgrade.apitest;

import com.upgrade.apitest.client.UpgradeApiClient;
import com.upgrade.apitest.fixtures.UpgradeRequestContext;
import com.upgrade.apitest.validations.UpgradeApiValidation;
import com.upgrade.frontend.Application;
import io.restassured.response.Response;
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

  @Autowired
  UpgradeApiClient upgradeApiClient;

  UpgradeRequestContext upgradeRequestContext;

  @Autowired
  UpgradeApiValidation upgradeApiValidation;

  @BeforeEach
  public void beforeEach() {
    upgradeApiClient = new UpgradeApiClient();
    upgradeApiValidation = new UpgradeApiValidation();
    upgradeRequestContext = new UpgradeRequestContext();
  }

  @Test
  public void upgradeApi_happyPath_acceptedResponse() throws JSONException {

    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext);
    upgradeApiValidation.validateApprovedApiResponse(apiResponse);
  }

  @Test
  public void upgradeApi_wrongPassword_declineWithError() {

    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext.password("wrongPassword"));
    upgradeApiValidation.validateErrorResponse(apiResponse);
  }

  @Test
  public void upgradeApi_wrongUsername_declineWithError() {

    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext.username("wrongUserName"));
    upgradeApiValidation.validateErrorResponse(apiResponse);
  }
}
