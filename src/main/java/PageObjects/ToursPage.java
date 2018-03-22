package PageObjects;

import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class ToursPage extends Page {

    ToursPage(){
        super( "https://www.phptravels.net/tours" ) ;
        PageFactory.initElements(webDriver, this);
    }

}
