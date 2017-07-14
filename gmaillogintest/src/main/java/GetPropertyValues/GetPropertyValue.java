package GetPropertyValues;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Gabor_Veress on 7/14/2017.
 */
public class GetPropertyValue
{
    public void getPropValue() throws IOException
    {
        String result = "";
        Date time=new Date(System.currentTimeMillis());
    }
    public Properties loadProperty() throws IOException
    {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null)
        {
            prop.load(inputStream);
        }
        else
        {
            throw  new FileNotFoundException("property file '"+propFileName+"' not found in the classpath");
        }
        return prop;
    }
}
