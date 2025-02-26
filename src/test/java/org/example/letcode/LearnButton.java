package org.example.letcode;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class LearnButton {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://letcode.in/button");
        System.out.println("Button Page Title: "+driver.getTitle());

        WebElement home = driver.findElement(By.cssSelector("#home"));
        home.click();
        driver.navigate().back();

        WebElement location = driver.findElement(By.cssSelector("#position"));
        Point location1 = location.getLocation();
        System.out.println(location1);

        WebElement color = driver.findElement(By.cssSelector("#color"));
        String cssValue = color.getCssValue("background-color");
        System.out.println(cssValue);

        WebElement size = driver.findElement(By.cssSelector("#property"));
        Dimension size1 = size.getSize();
        System.out.println("Height: "+size1.height);
        System.out.println("Width "+size1.width);

        WebElement isDisabled = driver.findElement(By.id("isDisabled"));
        boolean enabled = isDisabled.isEnabled();
        System.out.println(enabled);

        WebElement element = driver.findElement(By.xpath("//h2[text()=' Button Hold!']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();

        Thread.sleep(5000);

        driver.close();
    }
}
