package PageObjects;

import General.PageDoesNotExistException;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class PageManager {

    public final static String HOMEPAGENAME="home page" , HOTELSPAGENAME="hotels page", FLIGHTSPAGENAME="flights page" ,TOURSPAGENAME="tours page",CARSPAGENAME="cars page" ,
    OFFERSPAGENAME="offers page" ,VISAPAGENAME="visa page" ,BLOGPAGENAME="blog page" ,HOTELDETAILSPAGESNAME="hotel details page" ,BOOKINGSUMMARYPAGE="booking summary page" ,
    INVOICEPAGENAME="invoice page";
    final String CANVASID="offcanvas-menu";
    static HashMap<String,Page> savedPages=new HashMap<String,Page>();

    static public Page getPage(String pageName) throws PageDoesNotExistException
    {
        if(pageName.equals(HOMEPAGENAME))
                return savedPages.putIfAbsent(pageName,new HomePage())==null ?savedPages.get(pageName) :savedPages.get(pageName);

        if(pageName.equals(HOTELSPAGENAME))
            return savedPages.putIfAbsent(pageName,new HotelsPage())==null ?savedPages.get(pageName) :savedPages.get(pageName);

        if(pageName.equals(FLIGHTSPAGENAME))
            return savedPages.putIfAbsent(pageName,new FlightsPage())==null ?savedPages.get(pageName) :savedPages.get(pageName);
        if(pageName.equals(TOURSPAGENAME))
            return savedPages.putIfAbsent(pageName,new ToursPage())==null ?savedPages.get(pageName) :savedPages.get(pageName);

        if(pageName.equals(CARSPAGENAME))
            return savedPages.putIfAbsent(pageName,new CarsPage())==null ?savedPages.get(pageName) :savedPages.get(pageName);

        if(pageName.equals(OFFERSPAGENAME))
            return savedPages.putIfAbsent(pageName,new OffersPage())==null ?savedPages.get(pageName) :savedPages.get(pageName);

        if(pageName.equals(VISAPAGENAME))
            return savedPages.putIfAbsent(pageName,new VisaPage())==null ?savedPages.get(pageName) :savedPages.get(pageName);

        if(pageName.equals(BLOGPAGENAME))
            return savedPages.putIfAbsent(pageName,new BlogPage())==null ?savedPages.get(pageName) :savedPages.get(pageName);
        if(pageName.equals(HOTELDETAILSPAGESNAME))
            return savedPages.putIfAbsent(pageName,new HotelDetailsPage())==null ?savedPages.get(pageName) :savedPages.get(pageName);
        if(pageName.equals(BOOKINGSUMMARYPAGE))
            return savedPages.putIfAbsent(pageName,new BookingSummaryPage()) ==null?savedPages.get(pageName): savedPages.get(pageName);
        if(pageName.equals(INVOICEPAGENAME))
            return savedPages.putIfAbsent(pageName,new InvoicePage()) ==null?savedPages.get(pageName): savedPages.get(pageName);
        throw new PageDoesNotExistException();

    }

}



