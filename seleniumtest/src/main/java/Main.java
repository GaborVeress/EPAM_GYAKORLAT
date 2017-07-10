import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Scanner;

/**
 * Created by Gabor_Veress on 7/10/2017.
 */
public class Main
{
    public static WebDriver driver;
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        switch (input.nextLine())
        {
            case "Explorer":
            {
                System.setProperty("webdriver.ie.driver", "D:/explorerdriver/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            }
            case "Chrome":
            {
                System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            case "Firefox":
            {
                System.setProperty("webdriver.gecko.driver", "D:/geckodriver/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
            default:
            {
             System.out.println("Nem tudom megnyitni ezt a böngészőt.");
            }
        }
        driver.get("https://www.google.hu/");
        System.out.println(driver.getTitle());
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();

    }
}
