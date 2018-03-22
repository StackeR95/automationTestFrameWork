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
    protected Action action = new Action () ;

    ///Web Elements
    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Hotels')]//parent::a")
    protected WebElement hotelsButton;

    ///Web Elements
    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Flights')]//parent::a")
    protected WebElement flightsButton;

    ///Web Elements
    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Tours')]//parent::a")
    protected WebElement toursButton;

    ///Web Elements
    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Cars')]//parent::a")
    protected WebElement carsButton;

    ///Web Elements
    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Offers')]//parent::a")
    protected WebElement offersButton;

    ///Web Elements
    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Visa')]//parent::a")
    protected WebElement visaButton;

    ///Web Elements
    @FindBy(how = How.XPATH, using = "id('"+CANVASID+"')//ul[@class='main-menu go-left RTL']//span[contains(text(),'Blog')]//parent::a")
    protected WebElement blogButton;


    Page (String url){
        this.myUrl = url ;
        PageFactory.initElements(webDriver, this);
    }
    public void open() {
        action.openUrl(myUrl);
    }

    public void clickHotelsButton() {
        action.mouseClick(hotelsButton);
    }

    public void clickFlightsButton() {
        action.mouseClick(flightsButton);
    }
    public void clickToursButton() {
        action.mouseClick(toursButton);
    }
    public void clickCarsButton() {
        action.mouseClick(carsButton);
    }
    public void clickOffersButton() {
        action.mouseClick(offersButton);
    }

    public void clickVisaButton() {
        action.mouseClick(visaButton);
    }
    public void clickBlogButton() {
        action.mouseClick(blogButton);
    }

    public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(myUrl);
    }
}
