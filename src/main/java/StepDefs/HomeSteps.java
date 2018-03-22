package StepDefs;
import General.Action;
import General.PageDoesNotExistException;
import PageObjects.Page;
import PageObjects.PageManager;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertTrue;

public class HomeSteps {


    WebDriver webDriver;
    PageManager pageMan;
    Page page;
    @Given("^user is in \"([^\"]*)\"$")
    public void given_user_is_in(String pageName) throws PageDoesNotExistException {
        pageMan=new PageManager();
        (page = pageMan.getPage(pageName)).open();


        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user clicks on hotels button$")
    public void user_clicks_on_hotels_botton()  {

        page.clickHotelsButton();
    }



    @Then("^user is redirected to \"([^\"]*)\"$")
    public void then_user_is_redirected_to(String pageName) throws PageDoesNotExistException {
        assertTrue(pageMan.getPage(pageName).isOpened());
    }

    @When("^user clicks on flights button$")
    public void user_clicks_on_flights_button()  {
        page.clickFlightsButton();

    }

    @When("^user clicks on tours button$")
    public void user_clicks_on_tours_button() {
        page.clickToursButton();
        }

    @When("^user clicks on cars button$")
    public void user_clicks_on_cars_button()   {
        page.clickCarsButton();
    }

    @When("^user clicks on offers button$")
    public void user_clicks_on_offers_button()   {
        page.clickOffersButton();
    }

    @When("^user clicks on visa button$")
    public void user_clicks_on_visa_button()   {
        page.clickVisaButton();
    }

    @When("^user clicks on blog button$")
    public void user_clicks_on_blog_button() throws Exception {
       page.clickBlogButton();
    }

}
