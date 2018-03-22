package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Action {

    public  static  WebDriver webDriver;

    public void mouseClick(WebElement element)
    {
        element.click();
    }


    public void openUrl (String url){
        webDriver.get(url);
    }


}
