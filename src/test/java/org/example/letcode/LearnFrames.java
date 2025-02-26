package org.example.letcode;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LearnFrames {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://letcode.in/frame");
        System.out.println("Frame Page Title: "+driver.getTitle());

        WebDriver firstFr = driver.switchTo().frame("firstFr");
        firstFr.findElement(By.name("fname")).sendKeys("Esaimani");

        firstFr.findElement(By.name("lname")).sendKeys("Navamani");

        List<WebElement> iframe = firstFr.findElements(By.tagName("iframe"));
        System.out.println(iframe.size());

        WebDriver secframe = firstFr.switchTo().frame(1);
        secframe.findElement(By.name("email")).sendKeys("abc@gmail.com");
        secframe.switchTo().parentFrame();

        firstFr.findElement(By.name("fname")).sendKeys("Music");

        firstFr.switchTo().defaultContent();

        System.out.println(driver.getCurrentUrl());


        Thread.sleep(5000);

        driver.quit();
    }
}
