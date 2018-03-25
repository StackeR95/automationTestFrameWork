package StepDefs;


import PageObjects.HotelsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sl.In;

import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class HotelSteps extends Steps {



    @When("^user clicks on Rating Circle button Star \"([^\"]*)\"$")
    public void user_clicks_on_Rating_Circle_button_Star(String stars) {
        ( (HotelsPage)page).clickOnRatingRadioButton(Integer.parseInt(stars));
    }

    @When("^user clicks on search button$")
    public void user_clicks_on_search_button() {
        ((HotelsPage)page).clickOnSearchButton();
    }

    @Then("^Hotels with \"([^\"]*)\" Star appear$")
    public void hotels_with_Star_appear(String arg1) {
        String msg = "Stars check Failed";
        assertTrue(msg, ((HotelsPage)page).isFilterResultsCorrect(arg1));

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

    }

    @Then("^hotels with \"([^\"]*)\" Aminities are displayed$")
    public void hotels_with_Aminities_are_displayed(String arg1) throws InterruptedException {
        String[]data=arg1.split(",");
         ((HotelsPage)page).chooseAmenties(data);
    }



}
