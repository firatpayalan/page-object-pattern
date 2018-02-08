
import com.page.LandingPage;
import com.page.LoginPage;
import com.util.AutomationConstants;
import com.util.PropertyReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @author FIRAT
 */
public class LoginTest extends Base {
    /**
     * Enter a valid, registered user AND click Sign In button
     */
    @Test
    public void flora_01_01()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.setEmail("yfpayalan@gmail.com").setPassword("13579000Firat").signin();
        Assert.assertEquals(true,landingPage.isLogined());
    }

    /**
     * Enter a valid, unregistered user AND click Sign In button
     */
    @Test
    public void flora_01_02()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("yypayalan@gmail.com").setPassword("13579000Firat").signin();
        Assert.assertEquals(true,loginPage.isModalAppeared());
    }

    /**
     * Enter a valid e-mail AND an invalid password AND click Sign In button
     */
    @Test
    public void flora_01_03()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("yypayalan@gmail.com").setPassword("11").signin();
        Assert.assertEquals(true,loginPage.isPasswordInvalid());
    }

    /**
     * Enter an invalid e-mail and a valid password AND click Sign In button
     */
    @Test
    public void flora_01_05()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("yypayalan@gmailcom").setPassword("13579000Firat").signin();
        Assert.assertEquals(true,loginPage.isEmailInvalid());
    }

    /**
     * Enter an invalid e-mail and a valid password click AND Sign In button
     */
    @Test
    public void flora_01_06()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("yypayalangmailcom").setPassword("13579000Firat").signin();
        Assert.assertEquals(true,loginPage.isEmailInvalid());
    }

    /**
     * Enter a valid, registered mail address for password recovery AND click
     */
    @Test
    public void flora_01_20()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();
        Assert.assertEquals(true,loginPage.setPasswordRecoveryField("yfpayalan@gmail.com").sendForgotPassword().isPasswordRecoveryResult());
    }

    /**
     * Enter a valid, unregistered mail address for password recovery AND click
     */
    @Test
    public void flora_01_21()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();
        Assert.assertEquals(true,loginPage.setPasswordRecoveryField("yypayalan@gmail.com").sendForgotPassword().isPasswordRecoveryModalAppeared());
    }

    /**
     * Enter an invalid e-mail AND click Send button for password recovery
     */
    @Test
    public void flora_01_23()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();
        Assert.assertEquals(true,loginPage.setPasswordRecoveryField("yypayalangmailcom").sendForgotPassword().isPasswordRecoveryValidationFailed());
    }

    /**
     * Enter an invalid e-mail AND click Send button for password recovery
     */
    @Test
    public void flora_01_28()
    {
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();
        Assert.assertEquals(true,loginPage.setPasswordRecoveryField("a123/@asdas.com").sendForgotPassword().isPasswordRecoveryValidationFailed());
    }
    /**
     * Click Sign in with Facebook button
     */
    @Test
    public void flora_01_36()
    {
        String subWindowHandler = null;
        driver.get(PropertyReader.getReader().getProperties().getProperty(AutomationConstants.LOGIN_URL));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signinWithFacebook();
        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        Assert.assertEquals(true,driver.switchTo().window(subWindowHandler).getTitle().contains("Facebook"));
    }
}
