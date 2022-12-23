package test;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        System.setProperty("browser", "chrome");
        driver = Driver.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        Driver.closeDriver();
    }
}