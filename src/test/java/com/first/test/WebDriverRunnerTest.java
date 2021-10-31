package com.first.test;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class WebDriverRunnerTest {

    @Test
    public void myTest(){

        open("https://opensource-demo.orangehrmlive.com/");
        WebDriverRunner.clearBrowserCache();
        System.out.println("URL ::: " + WebDriverRunner.url());
        Assert.assertTrue(WebDriverRunner.source().contains("<title>OrangeHRM</title>"));

        WebDriverRunner.getWebDriver().manage().window().maximize();

        System.out.println("Is running chrome ::: " + WebDriverRunner.isChrome());
        System.out.println("Is running headless ::: " + WebDriverRunner.isHeadless());
        System.out.println("Does this browser supports JavaScript? ::: " + WebDriverRunner.supportsJavascript());

        List <File> fileList = WebDriverRunner.getBrowserDownloadsFolder().files();
        System.out.println("No of files ::: " + fileList.size());

        WebDriverRunner.closeWebDriver();

    }
}
