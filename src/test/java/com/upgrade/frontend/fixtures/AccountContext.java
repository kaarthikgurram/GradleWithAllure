package com.upgrade.frontend.fixtures;

public class AccountContext {

  private static String emailAddress = "candidate" + Math.random() + "@upgrade-challenge.com";
  private static String password = "P@ssw0rd";

  public static String getEmailAddress() {
    return emailAddress;
  }

  public static void setEmailAddress(String emailAddress) {
    AccountContext.emailAddress = emailAddress;
  }

  public static String getPassword() {
    return password;
  }

  public static void setPassword(String password) {
    AccountContext.password = password;
  }
}
