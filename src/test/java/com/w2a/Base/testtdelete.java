
package com.devskiller.selenium;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final String URL = "http://localhost:8089/index.html";
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String... queryParams) {
        String queryString = QueryStringBuilder.buildQueryString(queryParams);
        String finalurl = driver.get(URL + queryString);
    }

    public void fillCredentials(String username, String password) {
        //TODO implementation
    }

    public void clickLoginButton() {
        //TODO implementation
    }

    public String getErrorMessage() {
        //TODO implementation
        return null;
    }

    public void setRememberMeChecked(boolean checked) {
        //TODO implementation
    }
}
