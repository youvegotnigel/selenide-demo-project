package com.first.test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllureTest {

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    public void userCanSearchAnyKeyword() {
        open("https://duckduckgo.com/");
        $(By.name("q")).val("selenide").pressEnter();
        $$(".js-results").shouldHave(size(1));
        $$(".js-results .result").shouldHave(sizeGreaterThan(5));
        $(".js-results .result").shouldHave(text("selenide.org"));
    }
}
