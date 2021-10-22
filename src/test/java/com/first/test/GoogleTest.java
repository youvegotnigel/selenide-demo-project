package com.first.test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GoogleTest {

    @Test
    public void googleTest(){

        open("https://www.google.com/");
        $(By.xpath("//input[@title='Search']")).setValue("PL Table");
        $(By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']")).click();
        $(By.xpath("//div[@class='ofy7ae'][normalize-space()='Premier League standings']")).shouldHave(appear);

    }
}
