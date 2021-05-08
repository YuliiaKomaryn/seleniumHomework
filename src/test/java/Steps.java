import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import pages.CareersPage;
import pages.MainPage;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class Steps  {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected CareersPage careersPage;
    protected SearchPage searchPage;

    @Before
    public void begin(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        careersPage = PageFactory.initElements(driver, CareersPage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }



    @After
    public void end(){
    driver.quit();
    }

    @Given("I connect to epam.com")
    public void openMain(){
        mainPage.goTo();
        mainPage.closeDisclaimer();
    }

    @When("I click on {string} button")
    public void clickButton(String arg0) {
        mainPage.clickButton(arg0);
    }

    @Then("I check that I come to {string} page")
    public void redirectToPage(String arg0) throws InterruptedException {
        mainPage.redirection(arg0);
    }

    @Then("I check that page changed its careers region")
    public void changeCareersRegion() throws InterruptedException {
        careersPage.seeCareersPage();
    }

    @And("I enter 'junior'")
    public void enterJunior() {
        mainPage.enterSearchText("junior");
    }

    @Then("I check that page changed to search result")
    public void changedToSearchJunior() throws InterruptedException {
        searchPage.seeJuniorSearch();
    }

    @When("I point cursor to {string}")
    public void pointCursorToButton(String arg0) {
        mainPage.pointToButton(arg0);
    }

    @Then("I check that it is hovered by text")
    public void checkIsHovered() {
        mainPage.consultHover();
    }

    @Then("I check that {string} opens on a new page")
    public void goToNewPage(String arg0) {
        mainPage.openInNewPage(arg0);
    }

    @Then("I check that I come to investors page")
    public void toInvestorsPage() throws InterruptedException {
        mainPage.redirectPage("https://investors.epam.com/investors/faq");
    }
}
