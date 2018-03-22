package PageObjects;

import org.openqa.selenium.support.PageFactory;

import static General.Action.webDriver;

public class BlogPage extends Page{

    BlogPage(){
        super( "https://www.phptravels.net/blog" ) ;
        PageFactory.initElements(webDriver, this);
    }
}
