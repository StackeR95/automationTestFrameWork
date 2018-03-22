package PageObjects;

import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class CarsPage extends Page {


    CarsPage(){
        super( "https://www.phptravels.net/car" ) ;
        PageFactory.initElements(webDriver, this);
    }

}
