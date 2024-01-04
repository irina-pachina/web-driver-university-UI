package com.webdriveruniversity.tests;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.webdriveruniversity.pages.LoginPortalPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({ScreenShooterExtension.class})
public class LoginPortalTest {
    private final LoginPortalPage loginPortalPage = new LoginPortalPage();

    @BeforeAll
    public static void setUp() {

        if (remote.equals("http://localhost:4444/wd/hub")){
            Map<String, Object> selenoidOptions = Map.of(
                    "enableVNC", true,
                    "enableLog", true
//                ,"enableVideo", true
            );

            DesiredCapabilities options = new DesiredCapabilities();
            options.setCapability("selenoid:options", selenoidOptions);
            browserCapabilities = options;
        } else {
            remote = null;
        }
    }

    @Test
    public void invalidLogin() {
        loginPortalPage.open();

        loginPortalPage.login("user1", "pass1");

        assertEquals("validation! failed", loginPortalPage.alertText());
        loginPortalPage.acceptAlert();
    }
}
