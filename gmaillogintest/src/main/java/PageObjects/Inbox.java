package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Gabor_Veress on 7/14/2017.
 */
public class Inbox
{
    @FindBy(how = How.CSS, using = ".gb_Za.gb_5b")
    private static WebElement refresh;
    @FindBy(how = How.CSS, using =".T-I.J-J5-Ji.T-I-KE.L3.T-I-JO")
    private static WebElement gmail;
    @FindBy(how = How.CSS, using =".TN.GLujEb.aHS-bnw")
    private static WebElement starred;
    @FindBy(how = How.XPATH, using =".//*[@id=':4g']/div/div[2]/span/a")
    private static WebElement sentmails;
    @FindBy(how= How.XPATH, using=".//*[@id=':4h']/div/div[2]")
    private static  WebElement drafts;
    @FindBy(how= How.CSS, using=".TN.GLujEb.aHS-bnw")
    private static  WebElement more;
    @FindBy(how= How.CSS, using=".TN.GLujEb.aHS-bnt")
    private static  WebElement inbox;
    @FindBy(how= How.CSS, using=".gb_8a.gbii")
    private static  WebElement accclick;

    public static void refresh(WebDriver driver)
    {
        refresh.click();
    }
    public static void gmail(WebDriver driver)
    {
       gmail.click();
    }
    public static void starred(WebDriver driver)
    {
        starred.click();
    }
    public static void sentMails(WebDriver driver)
    {
        sentmails.click();
    }
    public static void drafts(WebDriver driver)
    {
       drafts.click();
    }
    public static void more(WebDriver driver)
    {
       more.click();
    }
    public static void inbox(WebDriver driver)
    {
        inbox.click();
    }
    public static void thisAccClick(WebDriver driver)
    {
        accclick.click();
    }
    public static void search(WebDriver driver,String s)
    {
        driver.findElement(By.id("gs_taif50")).sendKeys(s);
        driver.findElement(By.id("gbqfb")).click();
    }
    public static void clickOnAppsButton(WebDriver driver)
    {
        driver.findElement(By.cssSelector("a[class='gb_b gb_5b']")).click();
    }
}
