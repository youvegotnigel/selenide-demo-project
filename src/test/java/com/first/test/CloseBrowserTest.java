package com.first.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CloseBrowserTest {

    @Test
    public void BrowseCloseTest(){

        open("https://opensource-demo.orangehrmlive.com/"); //index = 0
        System.out.println("Page Title ::: " + title());

        WebElement youtube = $(By.xpath("//img[@alt='OrangeHRM on youtube']"));
        youtube.click();

        switchTo().window(1); // switch by index = 1
        System.out.println("Page Title ::: " + title());
        String youtubePageTitle = title();

        closeWindow(); //driver.close equivalent

        switchTo().window(0);
        System.out.println("Page Title ::: " + title());

        youtube.click();
        switchTo().window(youtubePageTitle); //switch by title
        System.out.println("Page Title ::: " + title());

        closeWebDriver();

    }
}
