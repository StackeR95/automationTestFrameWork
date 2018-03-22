package StepDefs;


import PageObjects.HotelsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelSteps extends Steps {



    @When("^user clicks on Rating Circle button Star \"([^\"]*)\"$")
    public void user_clicks_on_Rating_Circle_button_Star(String stars) {
        ( (HotelsPage)page).clickOnRatingRadioButton(Integer.parseInt(stars));
    }

    @When("^user clicks on search button$")
    public void user_clicks_on_search_button() {

    }

    @Then("^Hotels with \"([^\"]*)\" Star appear$")
    public void hotels_with_Star_appear(String arg1) {


    }

}
