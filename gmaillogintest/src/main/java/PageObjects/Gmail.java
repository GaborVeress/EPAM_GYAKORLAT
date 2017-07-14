package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Gabor_Veress on 7/14/2017.
 */
public class Gmail
{
    public static void gmail(WebDriver driver)
    {
        Inbox.gmail(driver);
        driver.findElement(By.xpath(".//*[@id=':12']")).click();
    }
    public static void contacts(WebDriver driver)
    {
        Inbox.gmail(driver);
        driver.findElement(By.xpath(".//*[@id=':13']")).click();
    }
    public static void tasks(WebDriver driver)
    {
        Inbox.gmail(driver);
        driver.findElement(By.xpath(".//*[@id=':ii']")).click();
    }
}
