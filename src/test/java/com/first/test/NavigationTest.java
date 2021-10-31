package com.first.test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.testng.annotations.Test;

public class NavigationTest {

    @Test
    public void navigationTest() throws InterruptedException {

        open("https://google.com");
        System.out.println("Page Title ::: " + title());

        open("https://amazon.com");
        System.out.println("Page Title ::: " + title());

        open("https://yahoo.com");
        System.out.println("Page Title ::: " + title());

        back();
        Thread.sleep(5000);
        System.out.println("Page Title ::: " + title());

        forward();
        Thread.sleep(5000);
        System.out.println("Page Title ::: " + title());

        back();
        Thread.sleep(5000);
        System.out.println("Page Title ::: " + title());

        Thread.sleep(5000);

        refresh();
    }
}
