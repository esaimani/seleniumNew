package org.example.letcode;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LearnAlert {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://letcode.in/alert");
        System.out.println("Alert Page Title: "+driver.getTitle());

        WebElement simpleAlert = driver.findElement(By.id("accept"));
        simpleAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: "+alert.getText());
        alert.accept();

        WebElement confirmAlert = driver.findElement(By.id("confirm"));
        confirmAlert.click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Confirm Alert Text: "+alert1.getText());
        alert1.dismiss();


        WebElement promptAlert = driver.findElement(By.id("prompt"));
        promptAlert.click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: "+alert2.getText());
        alert2.sendKeys("Prompt Alert Handled");
        alert2.accept();

        WebElement modernAlert = driver.findElement(By.id("modern"));
        modernAlert.click();

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector(".title")).getText());
        driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();


        Thread.sleep(5000);

        driver.quit();
    }
}
