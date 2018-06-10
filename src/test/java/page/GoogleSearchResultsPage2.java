package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage2 extends BasePage
{
    public GoogleSearchResultsPage2(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResultElements;

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
}
