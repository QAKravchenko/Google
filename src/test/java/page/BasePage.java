package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage
{
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public String getCurrentTitle()
    {
        return webDriver.getTitle();
    }

}

