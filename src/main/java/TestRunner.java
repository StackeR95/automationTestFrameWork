import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/HotelFilterSearch.feature"
        ,glue="StepDefs"
)

public class TestRunner {


}