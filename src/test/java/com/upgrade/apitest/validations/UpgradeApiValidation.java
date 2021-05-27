package com.upgrade.apitest.validations;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.stereotype.Component;

@Component
public class UpgradeApiValidation {

  public void validateApprovedApiResponse(Response response) throws JSONException {

    JSONObject jsonObject = new JSONObject(response.body().asString());
    JSONArray loansInReview = jsonObject.getJSONArray("loansInReview");
    JSONArray loanAccountSummaryAto = jsonObject.getJSONArray("loanAccountSummaryAto");

    Assert.assertEquals(200, response.statusCode());
    Assert.assertEquals("Ian", jsonObject.getString("firstName"));
    Assert.assertEquals("9114917", jsonObject.getString("userId"));
    Assert.assertEquals("34c16f53-38c4-461a-bd14-11fa748d2663", jsonObject.getString("userUuid"));
    Assert.assertEquals("FULL", jsonObject.getString("authenticationLevel"));
    Assert.assertEquals("9545966", loansInReview.getJSONObject(0).getString("id"));
    Assert.assertEquals(
        "230ea84a-7199-41c9-bf38-fff27e35970d", loansInReview.getJSONObject(0).getString("uuid"));
    Assert.assertEquals("WITHDRAWN", loansInReview.getJSONObject(0).getString("status"));
    Assert.assertEquals("PERSONAL_LOAN", loansInReview.getJSONObject(0).getString("productType"));
    Assert.assertEquals("false", loansInReview.getJSONObject(0).getString("hasOpenBackendCounter"));
    Assert.assertEquals("CREDIT_CARD", loansInReview.getJSONObject(0).getString("purpose"));
    Assert.assertEquals(
        "2019-08-21T18:18:59.959Z", loansInReview.getJSONObject(0).getString("createDate"));
    Assert.assertEquals("null", loansInReview.getJSONObject(0).getString("postIssuanceStatus"));
    Assert.assertEquals("null", loansInReview.getJSONObject(0).getString("addon"));
    Assert.assertEquals(
        "null", loanAccountSummaryAto.getJSONObject(0).getString("loanAccountNumber"));
    Assert.assertEquals(
        "null", loanAccountSummaryAto.getJSONObject(0).getString("postIssuanceLoanStatus"));
    Assert.assertEquals("0", loanAccountSummaryAto.getJSONObject(0).getString("daysPastDue"));
    Assert.assertEquals(
        "null", loanAccountSummaryAto.getJSONObject(0).getString("loanProductType"));

    System.out.println(loansInReview.getJSONObject(0).getString("id"));
  }

  public void validateErrorResponse(Response response) {

    Assert.assertEquals("100039", response.jsonPath().get("code").toString());
    Assert.assertEquals("INVALID_CREDENTIALS", response.jsonPath().get("codeName"));
    Assert.assertEquals(
        "We're sorry, the credentials you've provided are incorrect. Please try again",
        response.jsonPath().get("message"));
    Assert.assertEquals("false", response.jsonPath().get("retryable").toString());
    Assert.assertEquals("NORMAL", response.jsonPath().get("type"));
    Assert.assertEquals("UNAUTHORIZED", response.jsonPath().get("httpStatus"));
  }
}
