package General;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Action {

    public  static  WebDriver webDriver;

    public static void mouseClick(WebElement element) {
        scrollToElement(element);
        element.click();
    }


    public static void openUrl (String url){
        webDriver.get(url);
    }

    public static void selectSliderValues(double start,double end,WebElement head, WebElement tail, WebElement slider) {
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

    public static void scrollToElement(WebElement w)  {
      //  ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,0)");
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", w);

    }
    public static String extractTextFromWebElement(WebElement w){
        scrollToElement(w);
        return  w.getText() ;
    }


    public static void NavigateBack () {
        webDriver.navigate().back();
    }

    public static void setText(WebElement w  ,  String text )
    {
        scrollToElement(w);
        w.clear();
        w.sendKeys(text);
    }

    public static void selectByindex (WebElement w , int index){
        scrollToElement(w);
        Select numberOfRoomsSelector=new Select(w);
        numberOfRoomsSelector.selectByIndex(index);
    }

    public static void selectByValue(WebElement w , String value){
        scrollToElement(w);
        Select numberOfRoomsSelector=new Select(w);
        numberOfRoomsSelector.selectByValue(value);
    }

    public int extractNumber (String text) {
        String output = "" ;
        for ( int i =0  ; i < text.length() ; i ++ ){
            if((int)text.charAt(i)>=48 &&(int)text.charAt(i)<=57 )
                output += text.charAt(i) ;
        }
        if(output.equals(""))
            return -1;
        return Integer.parseInt(output) ;
    }


}
