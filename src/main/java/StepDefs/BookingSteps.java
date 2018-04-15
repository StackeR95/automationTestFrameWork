package StepDefs;
import General.PageDoesNotExistException;
import PageObjects.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;

public class BookingSteps extends Steps {


    @When("^user selects an hotel$")
    public void user_selects_an_hotel() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        ((HotelsPage) PageManager.getPage(PageManager.HOTELSPAGENAME)).selectAnHotel();
    }

    @When("^user enters an available reservation period of (\\d+) days$")
    public void user_enters_start_and_end_dates(int days) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        ((HotelDetailsPage)PageManager.getPage(PageManager.HOTELDETAILSPAGESNAME)).setDates(days);
    }

    @When("^user presses the modify button$")
    public void user_presses_the_modify_button() throws PageDoesNotExistException {
        ((HotelDetailsPage)PageManager.getPage(PageManager.HOTELDETAILSPAGESNAME)).pressModifyButton();

    }

    @When("^user enters the number of rooms to be (\\d+)$")
    public void user_enters_the_number_of_rooms_to_be(int numberOfRooms) throws PageDoesNotExistException {
        ((HotelDetailsPage)PageManager.getPage(PageManager.HOTELDETAILSPAGESNAME)).selectNumberOfRooms(numberOfRooms);
    }

    @When("^user presses the book now button$")
    public void user_presses_the_book_now_button() throws PageDoesNotExistException {

        ((HotelDetailsPage)PageManager.getPage(PageManager.HOTELDETAILSPAGESNAME)).pressBookNowButton();

    }

    @When("^user enters his/her personal details$")
    public void user_enters_his_her_personal_details() throws PageDoesNotExistException {

        ((BookingSummaryPage)PageManager.getPage(PageManager.BOOKINGSUMMARYPAGE)).fillPersonalDetails();

    }


    @When("^user presses the confirm booking button$")
    public void user_presses_the_confirm_booking_button() throws PageDoesNotExistException {
        ((BookingSummaryPage)PageManager.getPage(PageManager.BOOKINGSUMMARYPAGE)).pressConfirmBookingButton();

    }

    @Then("^the correct invoice is ready$")
    public void the_correct_invoice_is_ready() throws PageDoesNotExistException {
        BookingSummaryPage BSP = (BookingSummaryPage)PageManager.getPage(PageManager.BOOKINGSUMMARYPAGE);
        HotelDetailsPage HDP = (HotelDetailsPage)PageManager.getPage(PageManager.HOTELDETAILSPAGESNAME);



        String checkResult =  ((InvoicePage)PageManager.getPage(PageManager.INVOICEPAGENAME)).checkCorrectData(HDP , BSP);
        assertTrue(checkResult , checkResult.equals("true"));


    }

}
