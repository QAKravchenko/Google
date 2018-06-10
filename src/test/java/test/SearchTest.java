package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchResultsPage;
import page.GoogleSearchResultsPage2;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Test for performing search in Google
 */
public class SearchTest extends BaseTest
{
    @Test
    public void basicSearchTest() throws InterruptedException
    {
        String searchTerm = "Selenium";

        GoogleSearchResultsPage googleSearchResultsPage = googleHomePage.search(searchTerm);
        Assert.assertEquals(googleSearchResultsPage.getCurrentTitle(),
                "Selenium - Пошук Google",
                "Title of the page is wrong!!!");

        List<String> googleSearchResultsList = googleSearchResultsPage.getSearchResults();
        Assert.assertEquals(googleSearchResultsList.size(), 10,
                "Count of search result items is wrong.");
        System.out.println(googleSearchResultsList.size());

        for (String searchResult : googleSearchResultsList)
        {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "Searchterm " + searchTerm + " was not found in: \n" + searchResult);
        }
        sleep(2000);

        GoogleSearchResultsPage2 googleSearchResultsPage2 = googleSearchResultsPage.clickOnSecondPage();
        Assert.assertEquals(googleSearchResultsPage2.getCurrentTitle(),
                "Selenium - Пошук Google",
                "Title of the page is wrong!!!");

        List<String> googleSearchResultsList2 = googleSearchResultsPage2.getSearchResults();
        Assert.assertEquals(googleSearchResultsList2.size(), 10,
                "Count of search result items is wrong.");
        System.out.println(googleSearchResultsList2.size());

        for (String searchResult : googleSearchResultsList2)
        {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "Searchterm " + searchTerm + " was not found in: \n" + searchResult);
        }
        sleep(2000);

    }
}
