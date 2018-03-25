package General;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.interactions.Actions;

 public class Action {

    public  static  WebDriver webDriver;

    public static void mouseClick(WebElement element)
    {
        element.click();
    }


    public static void openUrl (String url){
        webDriver.get(url);
    }

    public static void selectSliderValues(double start,double end,WebElement head, WebElement tail, WebElement slider)
    {
        Actions builder = new Actions(Action.webDriver);
        int width=slider.getSize().getWidth();
        org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(head)

                .moveToElement(slider, ((width*(int)start)/100), 0)
                .release()
                .build();

        dragAndDrop.perform();

        dragAndDrop = builder.clickAndHold(tail)

                .moveToElement(slider, ((width*(int)end)/100), 0)
                .release()
                .build();

        dragAndDrop.perform();
    }

    public static void scrollToElement(WebElement w){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", w);

    }
    public static String extractTextFromWebElement(WebElement w){
        scrollToElement(w);
        return  w.getText() ;
    }


}
