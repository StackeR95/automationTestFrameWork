package PageObjects;

import General.Action;
import General.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static General.Action.webDriver;

public class HotelDetailsPage extends Page{

    HotelDetailsPage(){
        super( "this is redundant" ) ;
        PageFactory.initElements(webDriver, this);
    }

    public  float totalPrice ;
    public String checkInDate;
    public String checkOutDate;
    @FindAll(@FindBy(how= How.XPATH , using  = "//div[@class='panel-body']//div[@class=\"col-xs-6 col-sm-3\"]/div[@class=\"row\"]//img"))
    List<WebElement> amanitiesDetails;

    @FindAll(@FindBy(how= How.XPATH , using  = "//input[@placeholder='Check out']"))
    List<WebElement> checkOutTextBox;

    @FindAll(@FindBy(how= How.XPATH , using  = "//table[@class='bgwhite table table-striped']/child::tbody/child::tr"))
    List<WebElement> availableRooms;


    @FindAll(@FindBy(how= How.XPATH , using  = "//button[text()='Modify']"))
    List<WebElement> modifyButton;

    @FindAll(@FindBy(how= How.XPATH , using  = "//select[@name='roomscount']"))
    List<WebElement> numberOfRoomsElements;

    @FindAll(@FindBy(how= How.XPATH , using  = "//button[text()='Book Now']"))
    List<WebElement> bookNowButtons;

    @FindAll(@FindBy(how= How.XPATH , using  = "//strong[@class='text-success']"))
    List<WebElement> roomPrices;

    //strong[@class='text-success']


    //select[@name='roomscount']
    public boolean checkAmenitiesResults(String [] requiredAmenities) {

        for(int i=0;i<requiredAmenities.length;i++) {

            boolean flag = false ;
            for ( int j=0 ; j < amanitiesDetails.size() ; j++) {

                if (amanitiesDetails.get(j).getAttribute("data-original-title").equals(requiredAmenities[i]))
                    flag = true;
            }
            if(!flag)
                return false ;
        }

        return true ;
    }

    public void setDates(int numberOfDays)
    {

            Date currentDate = new Date();
            long timeDiff = 1000 * 60 * 60 * 24 * numberOfDays;
            Date newDate = new Date();
            newDate.setTime(currentDate.getTime() + timeDiff);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            checkInDate = df.format(currentDate);
            checkOutDate = df.format(newDate);
            Action.setText(checkOutTextBox.get(1), checkOutDate);



    }

    public void pressModifyButton (){
        Action.mouseClick(modifyButton.get(1));
    }


    public void selectNumberOfRooms(int numberOfRooms){
        Action.selectByindex(numberOfRoomsElements.get(0) , numberOfRooms-1);
        totalPrice = Utilities.extractNumber(Action.extractTextFromWebElement(roomPrices.get(1))) * numberOfRooms;
    }

    public void pressBookNowButton() {
        Action.mouseClick(bookNowButtons.get(0)) ;
    }
}
