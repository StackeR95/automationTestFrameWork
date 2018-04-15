package StepDefs;


import General.PageDoesNotExistException;
import PageObjects.HotelsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sl.In;

import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class HotelFilterSteps extends Steps {



    @When("^user clicks on Rating Circle button Star (\\d+)$")
    public void user_clicks_on_Rating_Circle_button_Star(int stars) {
        ( (HotelsPage)page).clickOnRatingRadioButton(stars);
    }

    @When("^user clicks on search button$")
    public void user_clicks_on_search_button() {
        ((HotelsPage)page).clickOnSearchButton();
    }

    @Then("^Hotels with (\\d+) Star appear$")
    public void hotels_with_Star_appear(int stars) {
        String msg = "Rating check Failed";
        assertTrue(msg, ((HotelsPage)page).isFilterResultsCorrect(stars));

    }

    @When("^user drags sliders to specify a price range (.*) - (.*)$")
    public void user_drags_sliders_to_specify_a_price_range(String minPrice, String maxPrice)  {

        ((HotelsPage)page).selectSliderPriceRange(Integer.parseInt(minPrice) , Integer.parseInt(maxPrice));

    }

    @Then("^hotels with price range (.*) - (.*) are displayed$")
    public void hotels_with_price_range_are_displayed(String minPrice, String maxPrice)  {
        String msg = "Prices check Failed";
        System.out.println("minPrice = "+minPrice+" maxPrice="+maxPrice);

        assertTrue(msg , ((HotelsPage)page).checkPriceInRange(Integer.parseInt(minPrice) , Integer.parseInt(maxPrice)));
    }

    @When("^user selects \"([^\"]*)\" from Aminities check boxes$")
    public void user_selects_from_Aminities_check_boxes(String arg1)  {
        String[]data=arg1.split(",");
        ((HotelsPage)page).chooseAmenties(data);
    }

    @Then("^all Amenities in \"([^\"]*)\" are displayed in hotels page$")
    public void all_Amenities_are_displayed_in_hotels_page(String arg1) {
        String[]data=arg1.split(",");
        String msg = "Aminities UI check Failed";
        assertTrue(msg ,((HotelsPage)page).checkAmenitiesUIResults(data));

    }

    @Then("^hotels with \"([^\"]*)\" Aminities are displayed$")
    public void hotels_with_Aminities_are_displayed(String arg1) throws PageDoesNotExistException {
        String[]data=arg1.split(",");
        String msg = "Aminities check Failed";
        assertTrue(msg ,((HotelsPage)page).checkAmenitiesResults(data));
    }


    @Then("^hotels with \"([^\"]*)\" and (\\d+) and price range (\\d+) - (\\d+) are displayed$")
    public void hotels_with_and_and_price_range_are_displayed(String amenities, int stars, int minPrice, int maxPrice) throws PageDoesNotExistException {
        String[]data=amenities.split(",");
        String msg = "all filter check Failed";
        assertTrue(msg ,((HotelsPage)page).checkAllFilters(maxPrice , minPrice , data , stars));

    }




}
