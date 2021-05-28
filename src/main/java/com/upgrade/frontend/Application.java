package com.upgrade.frontend;

import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    //SpringApplication.run(Application.class, args);
    SpringApplication application = new SpringApplication(Application.class);
    Properties properties = new Properties();
    properties.setProperty("spring.main.banner-mode", "on");
    properties.setProperty("logging.pattern.console", "");
    application.setDefaultProperties(properties);
    application.run(args);
  }
}
