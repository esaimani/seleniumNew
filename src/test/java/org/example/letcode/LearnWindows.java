package org.example.letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LearnWindows {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://letcode.in/window");
        System.out.println("Window Page Title: "+driver.getTitle());

        WebElement home = driver.findElement(By.id("home"));
        String parentWindow = driver.getWindowHandle();
        home.click();

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windowHandles);
        System.out.println(list.size());

        for (int i = 1; i < list.size(); i++) {
            driver.switchTo().window(list.get(i));
            System.out.println(driver.getTitle());
            driver.close();
        }
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());

        driver.findElement(By.id("multi")).click();

        Set<String> windowHandles1 = driver.getWindowHandles();
        for (String window: windowHandles1)
        {
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
            driver.close();
        }


        Thread.sleep(5000);

        driver.quit();
    }
}
