package com.first.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FindElements {

    @Test
    public void elementsTest(){

        open("https://www.amazon.com");
        ElementsCollection collection = $$(By.tagName("a"));

        System.out.println("Total Links :: " + collection.size());

//        for(var e : collection){
//            String text = e.getText();
//            String href = e.getAttribute("href");
//            System.out.println(text + " ------> " + href);
//        }

        collection.shouldHave(CollectionCondition.sizeLessThan(400));
        collection.stream().filter(e -> !e.getText().isEmpty()).forEach(e -> System.out.println(e.getText()));
    }

}
