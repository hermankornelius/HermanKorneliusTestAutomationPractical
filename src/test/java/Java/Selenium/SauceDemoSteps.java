package Java.Selenium;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.*;

public class SauceDemoSteps {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I navigate to the SauceDemo website")
    public void navigate_to_saucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("I should see {string} in the title")
    public void check_title(String title) {
        assertTrue(Objects.requireNonNull(driver.getTitle()).contains(title));
    }

    @When("I enter {string} as the username")
    public void enter_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @When("I enter {string} as the password")
    public void enter_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click the login button")
    public void click_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see {string}")
    public void check_error_message(String errorMessage) {
        String actualMessage = driver.findElement(By.xpath("//h3")).getText();
        assertEquals(errorMessage, actualMessage);
    }

    @When("I add two items to the cart")
    public void add_items_to_cart() {
        driver.findElement(By.xpath("//button[contains(text(), 'Add to cart')]")).click();
        driver.findElement(By.xpath("(//button[contains(text(), 'Add to cart')])[2]")).click();
    }

    @When("I proceed to checkout")
    public void proceed_to_checkout() {
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Checkout')]")).click();
    }

    @When("I enter {string} as the first name")
    public void enter_first_name(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    @When("I enter {string} as the last name")
    public void enter_last_name(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    @When("I enter {string} as the postal code")
    public void enter_postal_code(String postalCode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    @When("I submit the checkout form")
    public void submit_checkout_form() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
   }

    @When("I Finish Checkout")
    public void finish_checkout() {
        driver.findElement(By.xpath("//button[contains(text(), 'Finish')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("I should see Thank you for your order on the Page")
    public void check_order_on_the_Page() {
        driver.findElement(By.xpath("//*[@id='checkout_complete_container']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
