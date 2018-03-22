package PageObjects;

import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class HotelsPage extends Page{

    HotelsPage(){
        super( "https://www.phptravels.net/hotels" ) ;
        PageFactory.initElements(webDriver, this);
    }
}
