/*
IMDb Search Page Operations
 */
package com.luminar.pageobjects;

import com.codeborne.selenide.commands.TakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class IMDbSearchPage {
    private WebDriver driver;

    By videoGameSearch = By.xpath("//a[contains(text(),'Video Game')]");

    public IMDbSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void openGameResult(){
        try{
            Assert.assertEquals(title(), "Find - IMDb", "Titles are matching!!");
            Reporter.log("Webpage Title is verified successfully");
        }
        catch (AssertionError e){
            new TakeScreenshot();
        }

        $(videoGameSearch).click();
        Reporter.log("Video Game Link is clicked in the search result page");
    }
}
