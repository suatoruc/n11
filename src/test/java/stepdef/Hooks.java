package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilities.Driver;

public class Hooks {
  static String url;
    @Before
    public void setUp(){


    }

    @AfterStep
    public void tearDown(Scenario scenario){

        if(!scenario.isFailed()) {
            if (!Driver.getDriver().getCurrentUrl().equals(url)||url.length()!=0) {
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/jpg", "screenshots");
                url=Driver.getDriver().getCurrentUrl();

            }

        }

    }
    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
