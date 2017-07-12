package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gabor_Veress on 7/12/2017.
 */
public class StepDefinition
{
    public static WebDriver driver;
@Before
    public void openDriver()
      {
          System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
          driver=new ChromeDriver();
      }
  @Given("^the user is on the https://wordpress.com/ webpage$")
    public void startPage()
  {
      driver.manage().window().maximize();
      driver.get("https://wordpress.com/");
  }
  @And("^the user navigates to the login page by clicking the Log In button$")
  public void logInButton()
  {
      driver.findElement(By.id("navbar-login-link")).click();
  }
  @When("^the user enters valid credentials$")
    public void LogingIn() throws InterruptedException {
      driver.findElement(By.id("usernameOrEmail")).sendKeys("mrasd8522@gmail.com");
      driver.findElement(By.id("password")).sendKeys("cisco1234");
      driver.findElement(By.cssSelector(".button.form-button.is-primary")).click();
      Thread.sleep(2000);
  }
  @Then("^the user should be on the Home page$")
    public void isHomePage()
  {
     //assertTrue(driver.getTitle().contains("Following"));
  }
  @When("^the user clicks the write button$")
    public void clickOnTheWriteButton()
  {
      driver.findElement(By.cssSelector("a[class='masterbar__item masterbar__item-new']")).click();
  }
  @Then("^the add a new post page should be loaded$")
    public void isItTheRightPage()
  {
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      //assertTrue(driver.getTitle().contains("New Post"));
  }
  @And("^the user sets a title$")
    public void setTitle()
  {
      driver.findElement(By.cssSelector(".textarea-autosize.editor-title__input")).sendKeys("a title");
  }
  @And("^the user sets body$")
    public void setBody()
  {
      driver.findElement(By.id("tinymce")).sendKeys("a body");
  }
  @And("^publishes the post$")
    public void publish()
  {
      driver.findElement(By.cssSelector(".button.editor-publish-button.is-primary"));
  }
  @Then("^ the user navigates to the https://wordpress.com/ and the recently created blog post should be visible $")
    public void visible()
  {
//      driver.get("https://wordpress.com");
//      driver.close();
  }
@After
    public void closeDriver()
  {
      driver.close();
  }
}
