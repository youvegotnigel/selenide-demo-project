package com.first.test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleTest {

    @BeforeClass
    public static void setUp() {
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
    }

    @Test
    public void googleTest(){

        open("https://www.google.com/");

        $(By.xpath("//input[@title='Search']")).setValue("PL Table");
        $(By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']")).click();
        $(By.xpath("//div[@class='ofy7ae'][normalize-space()='Premier League standings']")).shouldHave(appear);

        //click on see more
        $(By.xpath("//span[@class='mtqGb']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ElementsCollection teamList = $$(By.xpath("(//div[@class='sWfpOe'])[1]//span[@class='ellipsisize hsKSJe']"));

        for(SelenideElement e : teamList){
            System.out.println(e.getText());
        }
        Assert.assertEquals(teamList.size(),20);

    }
}
