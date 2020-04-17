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
3. Ddemo & explain all above
 */
package com.luminar.tests;

import com.codeborne.selenide.Configuration;
import com.google.common.base.Verify;
import com.luminar.pageobjects.IMDbPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class IMDbTest {
    static WebDriver driver;
    static IMDbPage imdbPage = new IMDbPage(driver);

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Driver setup started...");
    }
    @Test(description = "Verify games of thrones video game search result in imdb.com website")
    public void search() {
        open("https://www.imdb.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Configuration.timeout = 60000;
        //imdbPage = new IMDbPage(driver);
        //$(By.name("q")).setValue("games of thrones").pressEnter();
        $(imdbPage.getSearchBox()).setValue("games of thrones").pressEnter();
        Configuration.timeout = 60000;
        //$(By.xpath("//a[contains(text(),'Video Game')]")).click();
        $(imdbPage.getVideoGameSearch()).click();
        Configuration.timeout = 60000;
        //int NumOfGames = $$(By.xpath("//a[contains(text(),'Game of Thrones')]")).size();
        int NumOfGames = $$(imdbPage.getGameOfThrones()).size();
        Configuration.timeout = 60000;
        System.out.println("There are: " + NumOfGames + " Results found for Games!!");
        Assert.assertEquals(title(), "Find - IMDb", "Titles are matching!!");

        //$("#header").shouldHave(exactText("Find - IMDb"));
        //$("title").shouldHave(text("Find - IMDb"));
    }
    @AfterTest
    public void tearDown() {
        closeWindow();
        //driver.quit();
    }

}