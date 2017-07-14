package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Gabor_Veress on 7/14/2017.
 */
public class HomePage
{
    public static void refresh(WebDriver driver)
    {
        driver.findElement(By.cssSelector(".gmail-nav__logo.gmail-logo")).click();
    }
    public static void forWork(WebDriver driver)
    {
        driver.findElement(By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__for-work")).click();
    }
    public static void logIn(WebDriver driver)
    {
        driver.findElement(By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__sign-in")).click();
    }
    public static void createAcc(WebDriver driver)
    {
        driver.findElement(By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__create-account")).click();
    }
    public static void createNewAcc(WebDriver driver)
    {
        createAcc(driver);
    }
}
