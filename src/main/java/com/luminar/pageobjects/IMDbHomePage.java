/*
IMDb Home Page Operations
 */
package com.luminar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import static com.codeborne.selenide.Selenide.*;

public class IMDbHomePage {

    private WebDriver driver;

    By searchBox = By.name("q");

    public IMDbHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchIMDb(){
        $(searchBox).setValue("games of thrones").pressEnter();
        Reporter.log("games of thrones - is entered in the Search box");
    }
}
