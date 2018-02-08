package com.page;

import com.util.AutomationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject {
    @FindBy(id = "EmailLogin")
    private WebElement textFieldEmail;
    @FindBy(id = "Password")
    private WebElement textFieldPassword;
    @FindBy(className = "login__btn")
    private WebElement buttonSignIn;
    @FindBy(className = "login__facebook")
    private WebElement buttonFacebookSignIn;
    @FindBy(className = "login__heading")
    private WebElement textSignIn;
    @FindBy(id= "Password-error")
    private WebElement spanPasswordError;
    @FindBy(id= "EmailLogin-error")
    private WebElement spanEmailLoginError;
    @FindBy(className= "login__forgot-password")
    private WebElement buttonForgotPassword;
    @FindBy(className= "js-password-recovery-input")
    private WebElement textFieldPasswordRecovery;
    @FindBy(className= "js-password-recovery-button")
    private WebElement buttonSendForgotPassword;
    @FindBy(className= "password-recovery-result")
    private WebElement spanPasswordRecoveryResult;
    @FindBy(className= "modal-body")
    private WebElement modalBody;
    @FindBy(id= "Mail-error")
    private WebElement spanPasswordRecoveryValidationFailed;




    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage setEmail(String email)
    {
        this.textFieldEmail.clear();
        this.textFieldEmail.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String pwd)
    {
        this.textFieldPassword.clear();
        this.textFieldPassword.sendKeys(pwd);
        return this;
    }
    public LoginPage setPasswordRecoveryField(String email)
    {
        this.textFieldPasswordRecovery.clear();
        this.textFieldPasswordRecovery.sendKeys(email);
        return this;
    }
    public LoginPage signin()
    {
        this.buttonSignIn.click();
        return this;
    }
    public LoginPage signinWithFacebook()
    {
        this.buttonFacebookSignIn.click();
        return this;
    }
    public LoginPage clickForgotPassword()
    {
        this.buttonForgotPassword.click();
        return this;
    }
    public LoginPage sendForgotPassword()
    {
        this.buttonSendForgotPassword.click();
        return this;
    }
    public boolean isModalAppeared()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            modalBody = wait.until(ExpectedConditions.elementToBeClickable(modalBody));
            return modalBody.getText().contains("E-mail address or password is incorrect. Please check your information and try again");
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean isPasswordRecoveryModalAppeared()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            modalBody = wait.until(ExpectedConditions.elementToBeClickable(modalBody));
            return modalBody.getText().contains("E-mail Address not Found");
        }
        catch (Exception e)
        {
            return false;
        }
    }    public boolean isPasswordRecoveryValidationFailed()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            spanPasswordRecoveryValidationFailed = wait.until(ExpectedConditions.elementToBeClickable(spanPasswordRecoveryValidationFailed));
        }
        catch (Exception e)
        {
            return false;
        }
        return spanPasswordRecoveryValidationFailed.isDisplayed();
    }

    public boolean isInitialized()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            textSignIn = wait.until(ExpectedConditions.elementToBeClickable(textSignIn));
        }
        catch (Exception e)
        {
            return false;
        }
        return textSignIn.isDisplayed();
    }
    public boolean isPasswordInvalid()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            spanPasswordError = wait.until(ExpectedConditions.elementToBeClickable(spanPasswordError));
        }
        catch (Exception e)
        {
            return false;
        }
        return spanPasswordError.isDisplayed();
    }
    public boolean isEmailInvalid()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            spanEmailLoginError = wait.until(ExpectedConditions.elementToBeClickable(spanEmailLoginError));
        }
        catch (Exception e)
        {
            return false;
        }
        return spanEmailLoginError.isDisplayed();
    }
    public boolean isPasswordRecoveryField()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            textFieldPasswordRecovery = wait.until(ExpectedConditions.elementToBeClickable(textFieldPasswordRecovery));
        }
        catch (Exception e)
        {
            return false;
        }
        return textFieldPasswordRecovery.isDisplayed();
    }
    public boolean isPasswordRecoveryResult()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            return wait.until(ExpectedConditions.textToBePresentInElement(spanPasswordRecoveryResult,"You will receive an e-mail from us with instructions for resetting your password"));
        }
        catch (Exception e)
        {
            return false;
        }
    }



}
