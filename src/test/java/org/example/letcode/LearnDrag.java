package org.example.letcode;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class LearnDrag {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://letcode.in/draggable");
        System.out.println("Drag Page Title: "+driver.getTitle());

        WebElement element = driver.findElement(By.id("sample-box"));
        Actions actions = new Actions(driver);
        Point location = element.getLocation();
        System.out.println(location.getX()+" "+ location.getY());
        actions.dragAndDropBy(element,50,70).perform();

        Thread.sleep(5000);
        driver.quit();
    }
}
