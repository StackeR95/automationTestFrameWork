package StepDefs;
import General.Action;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    static boolean isFirstTime = true ;
    @Before
    public void beforeScenario() {
        if (isFirstTime) {
            System.setProperty("webdriver.chrome.driver", "/Users/user2/Downloads/chromedriver");
            Action.webDriver = new ChromeDriver();
            isFirstTime = false ;
            Runtime.getRuntime().addShutdownHook(new Thread()
            {
                public void run()
                {
                    Action.webDriver.close();
                }
            });
        }

    }

    @After
    public void AfterScenario() throws InterruptedException {
        Thread.sleep(5000);
    }





}
