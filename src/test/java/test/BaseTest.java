package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleHomePage;

import static java.lang.Thread.sleep;

public class BaseTest
{
    public WebDriver webDriver;
    public GoogleHomePage googleHomePage;

    @Parameters({"browserType", "envURL"})
    @BeforeMethod
    public void before(@Optional("chrome") String browserType, @Optional("https://www.google.com/") String envURL) throws InterruptedException
    {
        switch (browserType.toLowerCase())
        {
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                break;
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                break;
            case "ie" :
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
                webDriver.manage().window().maximize();
                break;
            default :
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
                webDriver.manage().window().maximize();
        }

        webDriver.navigate().to(envURL);
        googleHomePage = new GoogleHomePage(webDriver);
    }

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }
}

