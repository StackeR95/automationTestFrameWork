package StepDefs;

import General.PageDoesNotExistException;
import PageObjects.HomePage;
import PageObjects.HotelsPage;
import PageObjects.Page;
import PageObjects.PageManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GeneralSteps extends Steps{


    @When("^put code to test here$")
    public void put_code_to_test_here() throws PageDoesNotExistException{

        Page origHome=PageManager.getPage("home page");
        Page newHome=PageManager.getPage("home page");
        if(origHome==origHome)
            System.out.println("nice neek");

    }

    @Given("^user is in \"([^\"]*)\"$")
    public void given_user_is_in(String pageName) throws PageDoesNotExistException {

        (page = PageManager.getPage(pageName)).open();

    }



}
