package com.luminar.pageobjects;

import com.codeborne.selenide.commands.TakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.*;

public class IMDbGamePage {
    private WebDriver driver;

    By gameOfThrones = By.xpath("//a[contains(text(),'Game of Thrones')]");

    public IMDbGamePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyGamePage(){
        int NumOfGames = $$(gameOfThrones).size();
        Reporter.log("There are: " + NumOfGames + " Results found for Games!!");
        try{
            Assert.assertEquals(title(), "Find - IMDb", "Titles are matching!!");
            Reporter.log("Webpage Title is verified successfully");
        }
        catch (AssertionError e){
            new TakeScreenshot();
        }
    }
}
