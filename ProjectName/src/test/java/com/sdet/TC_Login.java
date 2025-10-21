package com.sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Login {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set ChromeDriver path (optional if added to PATH)
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        // Step 1: Enter Username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        // Step 2: Enter Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // Step 3: Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Step 4: Wait and verify Dashboard is visible
        Thread.sleep(3000); // (For demo purpose; ideally use WebDriverWait)

        WebElement dashboardText = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertEquals(dashboardText.getText(), "Dashboard", "Login Failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
