package com.page;

import com.util.AutomationConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends PageObject {

    @FindBy(css = ".subheader .subheader-close .icon-close")
    private WebElement spanSubheaderCloseIcon;
    @FindBy(css = ".user-menu__log-out")
    private WebElement spanLogout;

    public LandingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isLogined()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationConstants.TIMEOUT);
        try {
            spanSubheaderCloseIcon = wait.until(ExpectedConditions.elementToBeClickable(spanSubheaderCloseIcon));
        }
        catch (Exception nsee)
        {
            return false;
        }
        spanSubheaderCloseIcon.click();
        spanLogout = wait.until(ExpectedConditions.elementToBeClickable(spanLogout));
        return spanLogout.isEnabled();
    }
}
