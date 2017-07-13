package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Peter_Hegedus2 on 7/13/2017.
 */
public class Screenshot
{
    public void getScreenshot(WebDriver driver) throws Exception
    {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String pattern = "EEEEE MMMMM yyyy HH.mm.ss.SSSZ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        FileUtils.copyFile(scrFile, new File("C:\\Users\\Gabor_Veress\\IdeaProjects\\gmaillogintest\\src\\Screenshots\\" + date + "screenshot.jpg"));
    }
}