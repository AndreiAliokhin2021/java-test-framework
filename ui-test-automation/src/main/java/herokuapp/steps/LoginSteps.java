package herokuapp.steps;

import herokuapp.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.open("http://the-internet.herokuapp.com/login");
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
    }

    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {
        assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
    }

    @After
    public void tearDown() {
        loginPage.close();
    }
}
