package StepDefinition;

import GetPropertyValues.GetPropertyValue;
import PageObjects.*;
import Utility.Screenshot;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class StepDefinition {
    private static Apps apps = new Apps();
    private static Inbox inbox = new Inbox();
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Screenshot screenshot = new Screenshot();
    public static Logger log = Logger.getLogger(StepDefinition.class);
    public static int scenario = 1;
    private GetPropertyValue getPropertyValue=new GetPropertyValue();

    @Before
    public void openDriver() {
        System.setProperty("webdriver.gecko.driver", "D:/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        log.info("Starting " + scenario + ". Scenario.");
        scenario++;
        PageFactory.initElements(driver, SignIn.class);
        PageFactory.initElements(driver,Inbox.class);
    }

    @Given("^the user is on the gmail login page$")
    public void loginpage() {
        driver.get("https://www.google.com/intl/hu/gmail/about/#");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        HomePage.logIn(driver);
        log.info("Clicking in login button");
    }

    @When("^tries to go to the enter password page without entering the email or username$")
    public void noEmailOrUsername() {
        SignIn.next(driver);
        log.info("Trying to login without username/e-mail");
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
            log.error("There is no enter an email or phone number error message ");
            assertTrue(driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).isDisplayed());
        }
        log.info("The enter an email or phone number error message is successfully written on the screen.");
    }

    @When("^the user enters a not existing email or username$")
    public void nonExistingIdentifier() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        SignIn.writeEmailOrUsername(driver, "gfh134656544687683212");
        SignIn.next(driver);
        log.info("Trying to login with nonexisting username/e-mail.");
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
            log.error("There is no Couldn't find your Google Account error message.");
        }
        log.info("The Couldn't find your Google Account error message successfully written on the screen.");
    }

    @When("^the user enters a valid username$")
    public void validUsername() throws IOException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        SignIn.writeEmailOrUsername(driver, getPropertyValue.loadProperty().getProperty("user"));
        SignIn.next(driver);
        log.info("Trying with existing username.");
        try {
            Thread.sleep(1000);
        } catch (Exception a) {
        }
    }

    @And("^the user enters an invalid password$")
    public void invalidPass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        SignIn.writePass(driver, "gfh134656544687683212");
        log.info("Trying with nonexisting password.");
        SignIn.next(driver);
    }

    @Then("^the Wrong password. Try again. error message should be displayed$")
    public void wrongPassError() throws Exception {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        boolean statement = driver.findElement(By.xpath(".//*[@id='password']/div[2]/div[2]")).isDisplayed();
        if (!statement) {
            screenshot.getScreenshot(driver);
            assertTrue(driver.findElement(By.xpath(".//*[@id='password']/div[2]/div[2]")).isDisplayed());
            log.error("There is no Wrong password. Try again. error message.");
        }
        log.info("The Wrong password. Try again. error message successfully written on the screen.");
    }

    @And("^the user enters an valid password$")
    public void validPass() throws IOException {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        SignIn.writePass(driver, getPropertyValue.loadProperty().getProperty("pass"));
        log.info("Entering existing password.");
        SignIn.next(driver);
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
            log.error("The user isn't on the Home Page.");
        }
        log.info("The user is on the Home Page.");
    }

    @Then("^click on the apps button and then navigate to the calendar page$")
    public void navToCalendar() {
        try {
            Thread.sleep(5000);
        } catch (Exception a) {
        }
        inbox.clickOnAppsButton(driver);
        apps.calendar(driver);
    }

    @Then("^click on the apps button and then navigate to the youtube page$")
    public static void navToYoutube() {
        try {
            Thread.sleep(5000);
        } catch (Exception a) {
        }
        inbox.clickOnAppsButton(driver);
        apps.youtube(driver);
    }

    @Then("^click on the gmail button and then navigate to the tasks$")
    public static void navToTasks() {
        try {
            Thread.sleep(5000);
        } catch (Exception a) {
        }
        Gmail.tasks(driver);
    }

    @After
    public void closeDriver() {
        log.info("The program quits.");
        try {
            Thread.sleep(3000);
        } catch (Exception a) {
        }
        driver.close();
    }
}
