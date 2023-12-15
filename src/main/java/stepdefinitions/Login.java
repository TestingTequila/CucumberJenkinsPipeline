package stepdefinitions;

import TestData.AppData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    WebDriver driver;

    @Then("Close the browser")
    public void close_the_browser() {
        driver.close();
    }

    @Given("Open the browser")
    public void open_the_browser() {
        driver = new ChromeDriver();
    }

    @Given("Enter the application url")
    public void enter_the_application_url() {
        driver.get(AppData.URL);
        driver.navigate().refresh();
        driver.navigate().to(AppData.URL);
    }

    @When("Click on My Account Icon")
    public void click_on_my_account_icon() throws InterruptedException {
        driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
        Thread.sleep(2000);
    }

    @When("Click on Login Link")
    public void click_on_login_link() {
        driver.findElement(By.xpath("//a[text()='Login']")).click();
    }

    @When("Enter correct email")
    public void enter_correct_email() {
        driver.findElement(By.id("input-email")).sendKeys(AppData.EMAIL_ID);
    }

    @When("Enter correct password")
    public void enter_correct_password() {
        driver.findElement(By.id("input-password")).sendKeys(AppData.PASSWORD);
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User should be able to Login Successfully")
    public void user_should_be_able_to_login_successfully() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "My Account";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("Enter correct email as {string}")
    public void enter_correct_email_as(String emailId) {
        driver.findElement(By.id("input-email")).sendKeys(emailId);
    }

    @When("Enter correct password as {string}")
    public void enter_correct_password_as(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @When("Enter correct email and correct password")
    public void enter_correct_email_and_correct_password(io.cucumber.datatable.DataTable dataTable) {
        driver.findElement(By.id("input-email")).sendKeys(dataTable.cell(0, 0));
        driver.findElement(By.id("input-password")).sendKeys(dataTable.cell(0, 1));
        System.out.println("GENDER : " + dataTable.cell(0, 2));
        System.out.println("MOBILE NUMBER : " + dataTable.cell(0, 3));

    }

    @When("^Enter the correct (.+) and correct (.+)$")
    public void enter_the_correct_tom_hanks_janbask_com_and_correct_test(String emailId, String password) {
        driver.findElement(By.id("input-email")).sendKeys(emailId);
        driver.findElement(By.id("input-password")).sendKeys(password);
    }
}
