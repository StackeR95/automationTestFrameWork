package PageObjects;

import General.Action;
import General.PageDoesNotExistException;
import General.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static General.Action.NavigateBack;
import static General.Action.extractTextFromWebElement;
import static General.Action.webDriver;

public class HotelsPage extends Page{


    private final String SEARCHBUTTONID="searchform";
    HotelsPage(){
        super( "https://www.phptravels.net/hotels" ) ;
        try {
            PageFactory.initElements(webDriver, this);
        }
        catch(NoSuchElementException e)
        {
            nextButton=null;
        }
    }

    ///Web Elements
    @FindAll(@FindBy(how= How.XPATH , using  = "//div[@class='rating']//input//parent::div"))
    List<WebElement> ratingRadioBtns;

    @FindAll(@FindBy(how= How.XPATH , using  = "//table[@class='bgwhite table table-striped']//div[@class='row']//span[@class='go-right mob-fs10']"))
    List<WebElement> ratingFilterResults;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='text-success fs18 text-left go-text-right go-right review ']/child::b"))
    List<WebElement> pricesResults;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@id='collapse4']//ins[@class='iCheck-helper']"))
    List<WebElement> amentiesCheckboxes;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@id='collapse4']//label"))
    List<WebElement> amentiesLabels;

    @FindAll(@FindBy(how = How.XPATH, using = "//ul[@class='hotelpreferences go-right hidden-xs']/child::img"))
    List<WebElement> amentiesResults;

    @FindAll(@FindBy(how = How.XPATH, using = " //table[@class='bgwhite table table-striped']//a//b"))
    List<WebElement> HotelNamesResult;

    @FindBy(how = How.XPATH, using = "//i[@class='glyphicon-chevron-right fa fa-angle-right']/parent::a")
    protected WebElement nextButton;

    @FindBy(how = How.XPATH, using = "id('"+SEARCHBUTTONID+"')")
    protected WebElement searchButton;


    @FindBy(how = How.XPATH, using = "//div[@class='slider-track']/child::div[2]")
    protected WebElement sliderStart;

    @FindBy(how = How.XPATH, using = "//div[@class='slider-track']/child::div[3]")
    protected WebElement sliderEnd;

    @FindBy(how = How.XPATH, using = "//div[@class='slider-track']")
    protected WebElement slider;

    @FindBy(how = How.XPATH, using = "//div[@class='slider slider-horizontal']/child::input")
    protected WebElement sliderInput;



    public void clickOnRatingRadioButton(int stars){
        Action.mouseClick(ratingRadioBtns.get(stars-1));
    }

    public void clickOnSearchButton(){
        System.out.println("i am here man");
        Action.mouseClick(searchButton);
    }



    public boolean isFilterResultsCorrect(int chosenRating) {

        boolean isValid=true;
        String oldPage;
        do{
            oldPage=webDriver.getCurrentUrl();
            isValid&=isCurrentRatingFilterCorrect(chosenRating);
            try {
                Action.mouseClick(nextButton);
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                return isValid;
            }
        }
        while(!oldPage.equals(webDriver.getCurrentUrl()));

        return isValid;
    }
    public void selectSliderPriceRange(int minReqPrice,int maxReqPrice) {

        int minPrice = Integer.parseInt(sliderInput.getAttribute("data-slider-min").replace(" ","")) ;
        int maxPrice = Integer.parseInt(sliderInput.getAttribute("data-slider-max").replace(" ","")) ;
        double Range=maxPrice-minPrice;
        double relativeMin=(minReqPrice-minPrice)/Range*100;
        double relativeMax=(maxReqPrice-minPrice)/Range*100;
        Action.selectSliderValues(relativeMin,relativeMax,sliderStart,sliderEnd, slider);
    }

    public  boolean checkPriceInRange (int minReqPrice , int maxReqPrice){

        boolean isValid=true;
        String oldPage;
        do{
            oldPage=webDriver.getCurrentUrl();
            isValid&=isCurrentPriceInRange(minReqPrice , maxReqPrice);
            try {
                Action.mouseClick(nextButton);
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                return isValid;
            }
        }
        while(!oldPage.equals(webDriver.getCurrentUrl()));

        return isValid;
    }

    public void chooseAmenties(String [] requiredAmenities) {
        for(int i=0;i<requiredAmenities.length;i++)
        {
            for( int j=0  ; j < amentiesLabels.size() ; j++)
            {
                if(requiredAmenities[i].equals(amentiesLabels.get(j).getText()))
                    Action.mouseClick(amentiesCheckboxes.get(j));
            }

        }
    }

    public boolean checkAmenitiesUIResults(String [] requiredAmenities) {

        boolean isValid=true;
        String oldPage;
        do{
            oldPage=webDriver.getCurrentUrl();
            isValid&=isCurrentAminitiesUIFilterCorrect(requiredAmenities);
            try {
                Action.mouseClick(nextButton);
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                return isValid;
            }
        }
        while(!oldPage.equals(webDriver.getCurrentUrl()));

        return isValid;

    }


    public boolean checkAmenitiesResults (String [] requiredAmenities) throws PageDoesNotExistException{

        boolean isValid=true;
        String oldPage;
        do{
            oldPage=webDriver.getCurrentUrl();
            isValid&=isCurrentAminitiesFilterCorrect(requiredAmenities);
            try {
                Action.mouseClick(nextButton);
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                return isValid;
            }
        }
        while(!oldPage.equals(webDriver.getCurrentUrl()));

        return isValid;

    }

    public boolean isCurrentAminitiesFilterCorrect(String [] requiredAmenities) throws PageDoesNotExistException{

        for (int i = 0 ; i < HotelNamesResult.size() ; i++){
            Action.mouseClick(HotelNamesResult.get(i));
            boolean PageIsFine  = ((HotelDetailsPage)PageManager.getPage("hotel details page")).checkAmenitiesResults(requiredAmenities);
            if(!PageIsFine)
                return false ;
            else
                NavigateBack();

        }
        return true;
    }


    public boolean isCurrentRatingFilterCorrect(int chosenRating) {

        for(WebElement w :ratingFilterResults){
            List<WebElement> stars=w.findElements(By.className("icon-star-5"));
            System.out.println(stars.size());
            if(stars.size()!=chosenRating)
                return false;
        }
        return true;
    }

    public  boolean isCurrentPriceInRange (int minReqPrice , int maxReqPrice){

        for(WebElement w :pricesResults){
            int shownPrice= Utilities.extractNumber(extractTextFromWebElement(w));
            System.out.println(shownPrice);
            if(shownPrice < minReqPrice || shownPrice > maxReqPrice)
                return false ;

        }
        return true ;
    }

    public boolean isCurrentAminitiesUIFilterCorrect(String [] requiredAmenities) {

        int numberOfResults = ratingFilterResults.size() ;

        for(int i=0;i<requiredAmenities.length;i++)
        {
            int counter = 0 ;

            for( int j=0  ; j < amentiesResults.size() ; j++)
            {

                if (amentiesResults.get(j).getAttribute("alt").equals(requiredAmenities[i]))
                    counter++ ;

            }

            if (counter != numberOfResults)
                return false ;

        }

        return true ;
    }

    public boolean checkAllFilters (int maxPrice , int minPrice , String[] requiredAmenities , int stars) throws PageDoesNotExistException{

        boolean isValid=true;
        String oldPage;
        do{
            oldPage=webDriver.getCurrentUrl();
            isValid&=isCurrentAminitiesFilterCorrect(requiredAmenities);
            isValid&=isCurrentPriceInRange(maxPrice , minPrice) ;
            isValid&=isCurrentRatingFilterCorrect(stars);
            try {
                Action.mouseClick(nextButton);
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                return isValid;
            }
        }
        while(!oldPage.equals(webDriver.getCurrentUrl()));

        return isValid;

    }

    public void selectAnHotel(){

        Action.mouseClick(HotelNamesResult.get(0));
    }






}
