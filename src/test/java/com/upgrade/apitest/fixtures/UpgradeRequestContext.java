package com.upgrade.apitest.fixtures;

import org.springframework.stereotype.Component;

@Component
public class UpgradeRequestContext {

  public static String username = "coding.challenge.login@upgrade.com";
  public static String password = "On$3XcgsW#9q";
  public static String recaptchaToken = "coding_challenge";

  public String getUsername() {
    return username;
  }

  public UpgradeRequestContext setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UpgradeRequestContext setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getRecaptchaToken() {
    return recaptchaToken;
  }

  public UpgradeRequestContext setRecaptchaToken(String recaptchaToken) {
    this.recaptchaToken = recaptchaToken;
    return this;
  }
}
