package PageObjects;

import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class OffersPage extends Page {

    OffersPage(){
        super( "https://www.phptravels.net/offers" ) ;
        PageFactory.initElements(webDriver, this);
    }

}
