package org.example.letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LearnInput {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://letcode.in/edit");
        System.out.println("Input Page Title: "+driver.getTitle());

        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("Esaimani Navamani");

        WebElement appendText = driver.findElement(By.id("join"));
        appendText.sendKeys(" in selenium", Keys.TAB);

        WebElement getMe = driver.findElement(By.id("getMe"));
        System.out.println(getMe.getAttribute("value"));

        WebElement clearMe = driver.findElement(By.id("clearMe"));
        clearMe.clear();

        WebElement noEdit = driver.findElement(By.id("noEdit"));
        boolean enabled = noEdit.isEnabled();
        if (enabled) {
            System.out.println("Field is disabled as expected");
        }
        else {
            System.out.println("Field is enable as unexpected");
        }

        WebElement dontwrite = driver.findElement(By.id("dontwrite"));
        String readonly = dontwrite.getAttribute("readonly");
        System.out.println(readonly);

Thread.sleep(10000);
        driver.close();
    }
}
