import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/Booking.feature"
        ,glue="StepDefs"
        //,tags = "@debug"
)

public class TestRunner {


}