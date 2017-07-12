package StepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Gabor_Veress on 7/12/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "C:\\Users\\Gabor_Veress\\IdeaProjects\\seleniumpractice\\src\\main\\java\\StepDefinition\\blog.feature"
                ,glue = "StepDefinition"
        )
public class TestRunner
{

}
