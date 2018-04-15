package PageObjects;

import General.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static General.Action.webDriver;

public class BookingSummaryPage extends Page {
    BookingSummaryPage(){
        super( "this is redundant" ) ;
        PageFactory.initElements(webDriver, this);
    }

   @FindBy(how= How.XPATH , using  = "//input[@name='firstname']")
        WebElement firstNameTextBox;

    @FindBy(how= How.XPATH , using  = "//input[@name='lastname']")
    WebElement lastNameTextBox;

    @FindBy(how= How.XPATH , using  = "//input[@name='email']")
    WebElement emailTextBox;

    @FindBy(how= How.XPATH , using  = "//input[@name='confirmemail']")
    WebElement confirmEmailTextBox;

    @FindBy(how= How.XPATH , using  = "//input[@name='phone']")
    WebElement phoneTextBox;

    @FindBy(how= How.XPATH , using  = "//input[@name='address']")
    WebElement addressTextBox;

    @FindBy(how= How.XPATH , using  = "//select[@name='country']")
    WebElement countrySelector;

    @FindBy(how= How.XPATH , using  = "//button[@name='guest']")
    WebElement confirmBookingButton;



    public  String firstName = "walid" ;
    public  String lastName = "moussa" ;
    public  String email = "walid@lol.com";
    public  String phone = "01063074739" ;
    public  String address= "dar el fada";
    public  String country ="EG" ; //egypt



    public void fillPersonalDetails(){
        Action.setText(firstNameTextBox , firstName);

        Action.setText(lastNameTextBox , lastName);

        Action.setText(emailTextBox , email);
        Action.setText(confirmEmailTextBox , email);

        Action.setText(phoneTextBox , phone);

        Action.setText( addressTextBox, address);

        Action.selectByValue(countrySelector , country);


    }

    public void pressConfirmBookingButton () {
        Action.mouseClick(confirmBookingButton);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
