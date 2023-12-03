package com.webdriveruniversity.tests;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.webdriveruniversity.pages.LoginPortalPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Configuration.baseUrl;
// import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.reportsFolder;

@ExtendWith({ScreenShooterExtension.class})
public class LoginPortalTest {
    private final LoginPortalPage loginPortalPage = new LoginPortalPage();

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://webdriveruniversity.com/";
        //browser = "chrome";
        reportsFolder = "target/screenshots";
    }

    @Test
    public void invalidLogin() {
        loginPortalPage.open();

        loginPortalPage.login("user1", "pass1");

        Assertions.assertEquals(loginPortalPage.alertText(), "validation failed");
        loginPortalPage.acceptAlert();
    }
}
