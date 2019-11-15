package com.mavenit.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/Genie/Desktop/chromedriver/chromedriver.exe");
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
