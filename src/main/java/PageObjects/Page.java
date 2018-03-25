package PageObjects;

import General.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class Page {
    final String CANVASID="offcanvas-menu";
    protected String myUrl;

    ///Web Elements
    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Hotels')]//parent::a")
    protected WebElement hotelsButton;


    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Flights')]//parent::a")
    protected WebElement flightsButton;


    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Tours')]//parent::a")
    protected WebElement toursButton;


    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Cars')]//parent::a")
    protected WebElement carsButton;


    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Offers')]//parent::a")
    protected WebElement offersButton;


    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Visa')]//parent::a")
    protected WebElement visaButton;


    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Blog')]//parent::a")
    protected WebElement blogButton;


    Page (String url){
        this.myUrl = url ;
        PageFactory.initElements(webDriver, this);
    }
    public void open() {
        Action.openUrl(myUrl);
    }

    public void clickHotelsButton() {
        Action.mouseClick(hotelsButton);
    }

    public void clickFlightsButton() {
        Action.mouseClick(flightsButton);
    }
    public void clickToursButton() {
        Action.mouseClick(toursButton);
    }
    public void clickCarsButton() {
        Action.mouseClick(carsButton);
    }
    public void clickOffersButton() {
        Action.mouseClick(offersButton);
    }

    public void clickVisaButton() {
        Action.mouseClick(visaButton);
    }
    public void clickBlogButton() {
        Action.mouseClick(blogButton);
    }

    public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(myUrl);
    }
}
