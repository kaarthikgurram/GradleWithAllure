package com.upgrade.apiTest;

import com.upgrade.apiTest.client.UpgradeApiClient;
import com.upgrade.apiTest.fixtures.UpgradeRequestContext;
import com.upgrade.apiTest.validations.UpgardeApiValidation;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UpgradeCodingChallengeApiTests {

  @Autowired
  UpgradeApiClient upgradeApiClient;

  @Autowired
  UpgradeRequestContext upgradeRequestContext;

  @Autowired
  UpgardeApiValidation upgardeApiValidation;

  @BeforeEach
  public void beforeEach() {
    upgradeApiClient = new UpgradeApiClient();
    upgradeRequestContext = new UpgradeRequestContext();
    upgardeApiValidation = new UpgardeApiValidation();
  }

  @Test
  public void upgradeApi_happyPath_acceptedResponse() {

    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext);
    upgardeApiValidation.validateApprovedApiResponse(apiResponse);
  }
}
