/*
Write automated web GUI test
1. Technology/tool stack:
		1.	using Selenide as test automation framework: https://selenide.org/quick-start.html
		2.	using any java 1.8: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
		3.	using IntelliJ as code editor: https://www.jetbrains.com/idea/download/
		4.	push the solution code to github
2. Test scenario:
		1.	open imdb.com
		2.	search for "games of thrones"
		3.	find and open Video Game related search results
		4.	verify correct page is opened
		5.	make a screenshot
		6.	generate report
3. Demo & explain all the above
 */
package com.luminar.tests;

import com.luminar.pageobjects.IMDbGamePage;
import com.luminar.pageobjects.IMDbHomePage;
import com.luminar.pageobjects.IMDbSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class IMDbTest {
    static WebDriver driver;
    static IMDbHomePage imdbHomePage = new IMDbHomePage(driver);
    static IMDbSearchPage imdbSearchPage = new IMDbSearchPage(driver);
    static IMDbGamePage imdbGamePage = new IMDbGamePage(driver);

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Verify games of thrones video game search result in imdb.com website")
    public void imdBsearch() {
        open("https://www.imdb.com/");
        Reporter.log("IMDb Website Launched Successfully");
        imdbHomePage.searchIMDb();
        imdbSearchPage.openGameResult();
        imdbGamePage.verifyGamePage();
    }

    @AfterTest
    public void tearDown() {
        closeWebDriver();
    }
}