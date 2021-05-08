package pages;

import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
        url += "search";
    }

    public void seeJuniorSearch() throws InterruptedException{
        redirectPage(url + "?q=junior");
    }
}
