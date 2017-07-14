package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Gabor_Veress on 7/14/2017.
 */
public class AccountWindow
{
    public static void privacy(WebDriver driver)
    {
        Inbox.thisAccClick(driver);
        driver.findElement(By.cssSelector(".gb_ob>a")).click();
    }
    public static void myAcc(WebDriver driver)
    {
        Inbox.thisAccClick(driver);
        driver.findElement(By.cssSelector(".gb_Fa.gb_uf.gbp1.gb_le.gb_xb")).click();
    }
    public static void change(WebDriver driver)
    {
        Inbox.thisAccClick(driver);
        driver.findElement(By.cssSelector(".gb_tb.gbip")).click();
    }
    public static void addAcc(WebDriver driver)
    {
        Inbox.thisAccClick(driver);
        driver.findElement(By.cssSelector(".gb_Fa.gb_tf.gb_le.gb_xb")).click();
    }
    public static void signOut(WebDriver driver)
    {
        Inbox.thisAccClick(driver);
        driver.findElement(By.id("gb_71")).click();
    }
}
