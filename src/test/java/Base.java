
import com.util.AutomationConstants;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.util.PropertyReader;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Base implements IBase {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", PropertyReader.getReader().getProperties().getProperty(AutomationConstants.DRIVER_PATH));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        //shutdowns all pages
        String subWindowHandler=null;
        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){

            subWindowHandler = iterator.next();
            driver.switchTo().window(subWindowHandler).close();
        }
    }
}
