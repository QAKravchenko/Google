package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage extends BasePage
{
    public GoogleSearchResultsPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    WebElement secondPage;

    public List<String> getSearchResults()
    {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements)
        {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }

    public GoogleSearchResultsPage2 clickOnSecondPage()
    {
        secondPage.click();
        return new GoogleSearchResultsPage2(webDriver);
    }
}
