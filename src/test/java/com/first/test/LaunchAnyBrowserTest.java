package com.first.test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.appear;

public class LaunchAnyBrowserTest {

    HashMap<Integer, String> PL_Ranking = new HashMap<Integer, String>();

    @BeforeClass
    public void setUp() {
        Configuration.browser = "edge";
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://www.google.com";
        Configuration.screenshots=true;
        ScreenShooter.captureSuccessfulTests = true;
    }

    @Test
    public void football() {

        open("/");

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
        int i = 1;
        for (SelenideElement e : teamList) {
            System.out.println(i + ". " + e.getText());
            PL_Ranking.put(i, e.getText());
            i++;
        }

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(teamList.size(), 21);
        sa.assertAll();
    }

    @Test(dependsOnMethods = "football")
    public void summary(){
        System.out.println("\n\nWho is currently leading the PL Table...?");
        System.out.println(PL_Ranking.get(1) + " are currently on top of the table");

        System.out.println("\nWhich teams will be selected to the Champions League next season...?");
        System.out.println(PL_Ranking.get(1));
        System.out.println(PL_Ranking.get(2));
        System.out.println(PL_Ranking.get(3));
        System.out.println(PL_Ranking.get(4));

        System.out.println("\nWhich teams will be selected to the Europa League next season...?");
        System.out.println(PL_Ranking.get(5));
        System.out.println(PL_Ranking.get(6));

        System.out.println("\nWhich teams will be relegated at end of the season...?");
        System.out.println(PL_Ranking.get(18));
        System.out.println(PL_Ranking.get(19));
        System.out.println(PL_Ranking.get(20));
    }
}
