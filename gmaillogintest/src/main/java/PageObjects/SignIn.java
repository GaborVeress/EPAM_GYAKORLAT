package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Gabor_Veress on 7/14/2017.
 */
public class SignIn
{
    @FindBy(how = How.ID, using = "identifierId")
    private static WebElement userName;
    @FindBy(how = How.CSS, using =".uBOgn")
    private static WebElement forgotemail;
    @FindBy(how = How.CSS, using ="IMH1vc.lUHSR.Hj2jlf")
    private static WebElement moreopt;
    @FindBy(how = How.CSS, using =".RveJvd.snByac")
    private static WebElement next;
    @FindBy(how= How.XPATH, using=".//*[@id='password']/div[1]/div/div[1]/input")
    private static  WebElement passwriter;
    @FindBy(how= How.XPATH, using=".//*[@id='initialView']/footer/ul/li[1]/a")
    private static  WebElement help;
    @FindBy(how= How.XPATH, using=".//*[@id='initialView']/footer/ul/li[2]/a")
    private static  WebElement privacy;
    @FindBy(how= How.XPATH, using=".//*[@id='initialView']/footer/ul/li[3]/a")
    private static  WebElement terms;

    public static void writeEmailOrUsername(WebDriver driver, String s)
    {
        userName.sendKeys(s);
    }
    public static void forgotEmail(WebDriver driver)
    {
       forgotemail.click();
    }
    public static void moreOptions (WebDriver driver)
    {
       moreopt.click();
    }
    public static void next (WebDriver driver)
    {
        next.click();
    }
    public static void writePass(WebDriver driver,String s)
    {
       passwriter.sendKeys(s);
    }
    public static void forgotPass(WebDriver driver)
    {
        moreopt.click();
    }
    public static void help(WebDriver driver)
    {
        help.click();
    }
    public static  void privacy(WebDriver driver)
    {
        privacy.click();
    }
    public static void terms(WebDriver driver)
    {
        terms.click();
    }
    public static void errorMesseage(WebDriver driver)
    {
        driver.findElement(By.cssSelector(".dEOOab.RxsGPe"));
    }
}
