package org.example.letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LearnRadioButtons {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://letcode.in/radio");
        System.out.println("Radio Page Title: "+driver.getTitle());

        WebElement element = driver.findElement(By.cssSelector("#yes"));
        element.click();

        driver.findElement(By.id("one")).click();
        driver.findElement(By.id("two")).click();


        List<WebElement> elements = driver.findElements(By.name("one"));
        System.out.println(elements.size());
        int selectedCount=0;
        for (WebElement element1:elements)
        {
            if (element1.isSelected())
                selectedCount+=1;
        }
        System.out.println(selectedCount);

        List<WebElement> foobar = driver.findElements(By.name("foobar"));
        for (WebElement foo:foobar)
        {
            if (foo.isSelected())
            {
                System.out.println(foo.getText()+" is selected");
            }
        }

        System.out.println(driver.findElement(By.xpath("//label[text()=' Remember me ']")).isSelected());

        WebElement element1 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));
//       JavascriptExecutor js=  (JavascriptExecutor)driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//       js.executeScript("arguments[0].scrollIntoView();", element);
       element1.click();

        Thread.sleep(5000);

        driver.quit();
    }
}
