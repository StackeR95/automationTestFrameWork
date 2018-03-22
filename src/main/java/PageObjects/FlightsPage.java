package PageObjects;

import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class FlightsPage extends Page{

    FlightsPage(){
        super( "https://www.phptravels.net/flightst" ) ;
        PageFactory.initElements(webDriver, this);
    }
}
