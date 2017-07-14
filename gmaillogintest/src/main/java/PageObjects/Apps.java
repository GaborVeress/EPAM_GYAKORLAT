package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.attribute.standard.Finishings;

/**
 * Created by Gabor_Veress on 7/14/2017.
 */
public class Apps
{
    public static void myAcc(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb192']/span[1]")).click();
    }
    public static void search(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb1']/span[1]")).click();
    }
    public static void maps(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb8']/span[1]")).click();
    }
    public static void youtube(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb36']/span[1]")).click();
    }
    public static void play(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb78']/span[1]")).click();
    }
    public static void gmail(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb23']/span[1]")).click();
    }
    public static void drive(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb49']/span[1]")).click();
    }
    public static void calendar(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb24']/span[1]")).click();
    }
    public static void googlePlus(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb119']/span[1]")).click();
    }
    public static void translate(WebDriver driver)
    {
        driver.findElement(By.cssSelector(".//*[@id='gb51']/span[1]")).click();
    }
    public static void photos(WebDriver driver)
    {
        driver.findElement(By.xpath(".//*[@id='gb31']/span[1]")).click();
    }
}
