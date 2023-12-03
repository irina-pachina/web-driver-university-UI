package com.webdriveruniversity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) { this.driver = driver; }

    private By loginLink = cssSelector("#register-email");

    public HomePage goToLoginPortal() {
        driver.findElement(loginLink).click();
        return this;
    }
}
