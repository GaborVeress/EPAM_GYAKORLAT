package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Gabor_Veress on 7/13/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "C:\\Users\\Gabor_Veress\\IdeaProjects\\gmaillogintest\\src\\main\\resources\\gmaillogin.feature"
                ,glue = "StepDefinition"
        )
public class TestRunner
{

}
