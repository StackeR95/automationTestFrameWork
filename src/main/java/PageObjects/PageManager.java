package PageObjects;

import General.PageDoesNotExistException;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PageManager {

    private final static String HOMEPAGENAME="home page" , HOTELSPAGENAME="hotels page", FLIGHTSPAGENAME="flights page" ,TOURSPAGENAME="tours page",CARSPAGENAME="cars page" ,
    OFFERSPAGENAME="offers page" ,VISAPAGENAME="visa page" ,BLOGPAGENAME="blog page" ;

    final String CANVASID="offcanvas-menu";


    public Page getPage(String pageName) throws PageDoesNotExistException
    {
        if(pageName.equals(HOMEPAGENAME))
                return new HomePage();

        if(pageName.equals(HOTELSPAGENAME))
            return new HotelsPage();

        if(pageName.equals(FLIGHTSPAGENAME))
            return new FlightsPage();

        if(pageName.equals(TOURSPAGENAME))
            return new ToursPage();

        if(pageName.equals(CARSPAGENAME))
            return new CarsPage();

        if(pageName.equals(OFFERSPAGENAME))
            return new OffersPage();

        if(pageName.equals(VISAPAGENAME))
            return new VisaPage();

        if(pageName.equals(BLOGPAGENAME))
            return new BlogPage();

        throw new PageDoesNotExistException();

    }

}



