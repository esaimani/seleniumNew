package org.example.letcode;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class LearnDropdowns {

    static WebDriver driver;

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://letcode.in/dropdowns");
        System.out.println("Dropdowns Page Title: "+driver.getTitle());

        WebElement fruits = driver.findElement(By.cssSelector("#fruits"));
        new Select(fruits).selectByVisibleText("Apple");

        WebElement element = driver.findElement(By.cssSelector("#superheros"));
        Select superHeros = new Select(element);
        System.out.println(superHeros.isMultiple());

        List<WebElement> options2 = superHeros.getOptions();

        for (int i = 0; i < options2.size(); i++) {
            options2.get(i).click(); }

        WebElement lang = driver.findElement(By.id("lang"));
        Select langSelect = new Select(lang);
        List<WebElement> options1 = langSelect.getOptions();

        for (int i = 0; i < options1.size(); i++) {
            System.out.println(options1.get(i).getText());
        }

        langSelect.selectByIndex(options1.size()-1);

        WebElement country = driver.findElement(By.id("country"));
        Select select = new Select(country);
        select.selectByValue("India");
        System.out.println(select.getFirstSelectedOption().getText());

        driver.close();
    }
}
