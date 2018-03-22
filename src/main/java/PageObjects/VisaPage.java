package PageObjects;

import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class VisaPage extends Page{

    VisaPage(){
        super( "https://www.phptravels.net/visa" ) ;
        PageFactory.initElements(webDriver, this);
    }
}
