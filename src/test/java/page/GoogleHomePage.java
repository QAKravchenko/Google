package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

import static java.lang.Thread.sleep;

public class GoogleHomePage extends BasePage
{
    public GoogleHomePage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (id = "lst-ib")
    WebElement searchField;

    @FindBy (xpath = "//input[@type='button' and contains(@value,'Google')]")
    WebElement searchButton;

    public GoogleSearchResultsPage search(String searchTerm) throws InterruptedException {
        searchField.sendKeys(searchTerm);
        sleep(1000);
        searchButton.click();
        return new GoogleSearchResultsPage(webDriver);
    }
}
