package com.webdriveruniversity.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class LoginPortalPage {
    private String usernameField = "//input[@id='text']";
    private String passwordField = "//input[@id='password']";
    private String loginButton = "//button[@id='login-button']";
    public void open() {
        Selenide.open("/Login-Portal/index.html");
    }

    public void login(String username, String password) {
        $(byXpath(usernameField)).sendKeys(username);
        $(byXpath(passwordField)).sendKeys(password);
        $(byXpath(loginButton)).click();
    }

    public String alertText() {
        return switchTo().alert().getText();
    }

    public void acceptAlert() {
        switchTo().alert().accept();
    }
}
