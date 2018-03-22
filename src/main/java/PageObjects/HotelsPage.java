package PageObjects;

import General.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

import java.util.List;

import static General.Action.webDriver;

public class HotelsPage extends Page{

    Action action = new Action() ;
    HotelsPage(){
        super( "https://www.phptravels.net/hotels" ) ;
        PageFactory.initElements(webDriver, this);
    }

    ///Web Elements
    @FindAll(@FindBy(how= How.XPATH , using  = "//div[@class='rating']//input//parent::div"))
    List<WebElement> RatingRadioBtns;



    public void clickOnRatingRadioButton(int stars){

        action.mouseClick(RatingRadioBtns.get(stars-1));
    }
}
