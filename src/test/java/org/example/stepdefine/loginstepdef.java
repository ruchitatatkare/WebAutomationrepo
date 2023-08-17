package org.example.stepdefine;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.example.pages.loginpage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import sun.rmi.log.LogInputStream;

public class loginstepdef {

    private WebDriver driver;
    private loginpage loginpage;

    @Before
    public void setup(){
        driver=new ChromeDriver();
    }
    @After
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }

     @Given("User on opencart login page")
     public void User_on_opencart_login_page(){
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginpage=new loginpage(driver);
     }


    @Given("user enter valid Username and Password")
    public void user_enter_valid_Username_and_Password(){
        loginpage.enterEmail("qatestertest@gmail.com");
        loginpage.enterPassword("Test@123");
    }
    @Given("user enter invalid {username} and {password}")
    public void user_enter_invalid_(String username ,String password){
        loginpage.enterEmail(username);
        loginpage.enterPassword(password);
    }
    @When("user click on login button")
    public void user_click_on_login_button(){
        loginpage.clickLoginButton();
    }
    @Then("user should be successful login")
    public void user_should_be_successful_login(){
        Assert.assertEquals(loginpage.checkLogoutLink(),true);
    }
    @Then("user should see the Error Message{String}")
    public void user_should_see_the_Error_Message_(String ErrorMessage){
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true );

    }
    @When("user click on \"forgotPassword\" link")
    public void user_click_on_forgotPassword_link(){
        loginpage.clickForgotPassword();

    }
    @Then("user should be redirect to reset password page")
    public void user_should_be_redirect_to_reset_password_page(){
        Assert.assertTrue(loginpage.getForgotPasswordPageUrl().contains("account/forgotten"));
    }

}
