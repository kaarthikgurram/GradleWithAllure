package com.upgrade.apitest.fixtures;

public class UpgradeRequestContext {

  public String username = "coding.challenge.login@upgrade.com";
  public String password = "On$3XcgsW#9q";
  public String recaptchaToken = "coding_challenge";

  public UpgradeRequestContext username(String username) {
    this.username = username;
    return this;
  }

  public UpgradeRequestContext password(String password) {
    this.password = password;
    return this;
  }

  public UpgradeRequestContext recaptchaToken(String recaptchaToken) {
    this.recaptchaToken = recaptchaToken;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getRecaptchaToken() {
    return recaptchaToken;
  }

  @Override
  public String toString() {
    return "UpgradeRequestContext{"
        + "username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + ", recaptchaToken='"
        + recaptchaToken
        + '\''
        + '}';
  }
}
