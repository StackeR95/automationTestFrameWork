package PageObjects;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class HomePage extends Page {


    HomePage(){
        super( "https://www.phptravels.net/" ) ;
        PageFactory.initElements(webDriver, this);
    }





}
