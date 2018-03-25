package StepDefs;

import PageObjects.HotelsPage;
import cucumber.api.java.en.When;

public class GeneralSteps extends Steps{


    @When("^put code to test here$")
    public void put_code_to_test_here() {

        ((HotelsPage)page).checkPriceInRange(1 ,3 );
    }

}
