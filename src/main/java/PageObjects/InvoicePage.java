package PageObjects;

import General.Action;
import General.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static General.Action.webDriver;

public class InvoicePage extends Page {
    InvoicePage(){
        super( "this is redundant" ) ;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(how= How.XPATH , using  = "//strong[text()='Check in  ']//parent::td//following-sibling::td")
    WebElement checkInDate;

    @FindBy(how= How.XPATH , using  = "//strong[text()='Check out  ']//parent::td//following-sibling::td")
    WebElement checkOutDate;

    @FindBy(how= How.XPATH , using  = "//table[@class='table table-bordered']//tbody//td[3]")
    WebElement finalPrice;


    @FindBy(how= How.XPATH , using  = "//div[text()='Customer Details']//following-sibling::div")
    List<WebElement> customerDetails;






    public  String checkCorrectData(HotelDetailsPage hotelDetailsPage , BookingSummaryPage bookingSummaryPage ){


        String invoiceCheckinDate = Action.extractTextFromWebElement(checkInDate).replaceAll(" ", "");
        String invoiceCheckoutDate = Action.extractTextFromWebElement(checkOutDate).replaceAll(" ", "");
        String invoiceUserName = Action.extractTextFromWebElement(customerDetails.get(0)) ;
        String invoiceAddress = Action.extractTextFromWebElement(customerDetails.get(1)) ;
        String invoicePhone = Action.extractTextFromWebElement(customerDetails.get(2)) ;
        float invoicePrice = Utilities.extractNumber(Action.extractTextFromWebElement(finalPrice));





        String bookingSummaryUserName= (bookingSummaryPage.firstName + " " + bookingSummaryPage.lastName);

        float priceWithVat = hotelDetailsPage.totalPrice * 1.1f ;

        System.out.println(priceWithVat);

        if(!hotelDetailsPage.checkInDate.equals(invoiceCheckinDate))
            return "check in Date is not correct" ;
        else if(!hotelDetailsPage.checkOutDate.equals(invoiceCheckoutDate) )
            return "check out Date is not correct";
        else if(priceWithVat != invoicePrice)
            return "price is not correct";
        else if(!bookingSummaryUserName.toUpperCase().equals(invoiceUserName))
            return "user name is not correct";
        else if (!bookingSummaryPage.phone.equals(invoicePhone))
            return "phone is not correct";
        else if (!bookingSummaryPage.address.toUpperCase().equals(invoiceAddress))
            return "address is not correct";
        else
            return "true";
    }

}
