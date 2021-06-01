package com.upgrade.apitest.validations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class UpgradeApiValidation {

  public void validateApprovedApiResponse(Response response) throws JSONException {

    JSONObject jsonObject = new JSONObject(response.body().asString());

    assertEquals(200, response.statusCode());
    assertEquals("Ian", jsonObject.getString("firstName"));
    assertEquals("9114917", jsonObject.getString("userId"));
    assertEquals("34c16f53-38c4-461a-bd14-11fa748d2663", jsonObject.getString("userUuid"));
    assertEquals("FULL", jsonObject.getString("authenticationLevel"));
    JSONArray loansInReview = jsonObject.getJSONArray("loansInReview");
    assertEquals("9545966", loansInReview.getJSONObject(0).getString("id"));
    assertEquals(
        "230ea84a-7199-41c9-bf38-fff27e35970d", loansInReview.getJSONObject(0).getString("uuid"));
    assertEquals("WITHDRAWN", loansInReview.getJSONObject(0).getString("status"));
    assertEquals("PERSONAL_LOAN", loansInReview.getJSONObject(0).getString("productType"));
    assertEquals("false", loansInReview.getJSONObject(0).getString("hasOpenBackendCounter"));
    assertEquals("CREDIT_CARD", loansInReview.getJSONObject(0).getString("purpose"));
    assertEquals(
        "2019-08-21T18:18:59.959Z", loansInReview.getJSONObject(0).getString("createDate"));
    assertEquals("null", loansInReview.getJSONObject(0).getString("postIssuanceStatus"));
    assertEquals("null", loansInReview.getJSONObject(0).getString("addon"));
    JSONArray loanAccountSummaryAto = jsonObject.getJSONArray("loanAccountSummaryAto");
    assertEquals(
        "null", loanAccountSummaryAto.getJSONObject(0).getString("loanAccountNumber"));
    assertEquals(
        "null", loanAccountSummaryAto.getJSONObject(0).getString("postIssuanceLoanStatus"));
    assertEquals("0", loanAccountSummaryAto.getJSONObject(0).getString("daysPastDue"));
    assertEquals(
        "null", loanAccountSummaryAto.getJSONObject(0).getString("loanProductType"));

    System.out.println(loansInReview.getJSONObject(0).getString("id"));
  }

  public void validateErrorResponse(Response response) {

    assertEquals(401, response.statusCode());
    assertEquals("100039", response.jsonPath().get("code").toString());
    assertEquals("INVALID_CREDENTIALS", response.jsonPath().get("codeName"));
    assertEquals(
        "We're sorry, the credentials you've provided are incorrect. Please try again",
        response.jsonPath().get("message"));
    assertEquals("false", response.jsonPath().get("retryable").toString());
    assertEquals("NORMAL", response.jsonPath().get("type"));
    assertEquals("UNAUTHORIZED", response.jsonPath().get("httpStatus"));
  }

  public void validateBadRequest(Response response, String value) {

    assertEquals("0", response.jsonPath().get("code").toString());
    assertEquals(null, response.jsonPath().get("codeName"));
    assertEquals(
        "Invalid request for object: loginRequest, fields [ { " + value + ": null } ], violations [ ]",
        response.jsonPath().get("message"));
    assertEquals("false", response.jsonPath().get("retryable").toString());
    assertEquals(null, response.jsonPath().get("type"));
    assertEquals("BAD_REQUEST", response.jsonPath().get("httpStatus"));
  }
}
