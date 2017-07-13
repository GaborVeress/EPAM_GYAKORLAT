package StepDefinition;

import Utility.Screenshot;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class StepDefinition {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Screenshot screenshot = new Screenshot();

    @Before
    public void openDriver() {
        System.setProperty("webdriver.gecko.driver", "D:/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
    }

    @Given("^the user is on the gmail login page$")
    public void loginpage() {
        driver.get("https://www.google.com/intl/hu/gmail/about/#");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__sign-in")).click();
    }

    @When("^tries to go to the enter password page without entering the email or username$")
    public void noEmailOrUsername() {
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
    }

    @Then("^the enter an email or phone number error message should be displayed$")
    public void noEmailOrPhone() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        boolean statement = driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).isDisplayed();
        if (!statement) {
            try {
                screenshot.getScreenshot(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).isDisplayed());
        }
    }

    @When("^the user enters a not existing email or username$")
    public void nonExistingIdentifier() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("identifierId")).sendKeys("gfh134656544687683212");
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
    }

    @Then("^the Couldn't find your Google Account error message should be displayed$")
    public void couldntFind() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        boolean statement = driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).isDisplayed();
        if (!statement) {
            try {
                screenshot.getScreenshot(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).isDisplayed());
        }
    }

    @When("^the user enters a valid username$")
    public void validUsername() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("identifierId")).sendKeys("mrasd8522");
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception a) {
        }
    }

    @And("^the user enters an invalid password$")
    public void invalidPass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".whsOnd.zHQkBf")).sendKeys("gfh134656544687683212");
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
    }

    @Then("^the Wrong password. Try again. error message should be displayed$")
    public void wrongPassError() throws Exception {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        boolean statement = driver.findElement(By.xpath(".//*[@id='password']/div[2]/div[2]")).isDisplayed();
        if (!statement) {
            System.out.println("In the if statement");
            screenshot.getScreenshot(driver);
            assertTrue(driver.findElement(By.xpath(".//*[@id='password']/div[2]/div[2]")).isDisplayed());
            System.out.println("In the if statement");
        }
    }

    @And("^the user enters an valid password$")
    public void validPass() {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".whsOnd.zHQkBf")).sendKeys("cisco123");
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
    }

    @Then("^the user should be on the home page$")
    public void homePage() throws Exception {
        wait.until(ExpectedConditions.titleContains("Inbox"));
        boolean statement = driver.getTitle().contains("Inbox");
        if (!statement) {
            try {
                screenshot.getScreenshot(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(driver.getTitle().contains("Inbox"));
        }
    }

    @After
    public void closeDriver() {
        try {
            Thread.sleep(3000);
        } catch (Exception a) {
        }
        driver.close();
    }
}
