package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {

    private WebDriver driver;

    //By locatior
    private By emailInputLocator=By.name("email");
    private By passwordInputLocator=By.name("password");
    private By LoginButtonLocator=By.xpath("//input[@type=\"submit\"]");
    private By forgotPasswordlinkLocator=By.linkText("Forgotten Password");
    private By logoutLinkLocator=By.linkText("Logout");

    //Consturctor
    public  loginpage (WebDriver driver){
       this.driver=driver;

    }

    //Page Method Action
    public void enterEmail(String email){
        WebElement emailInput=driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }
    public void enterPassword (String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton (){
        WebElement loginButton = driver.findElement(LoginButtonLocator);
        loginButton.click();
    }
    public void clickForgotPassword (){
        WebElement forgotpassword = driver.findElement(forgotPasswordlinkLocator);
        forgotpassword.click();
    }
    public void clickLogout(){
        WebElement logout = driver.findElement(logoutLinkLocator);
        logout.click();
    }

    public boolean checkForgotPasswordLink(){
        return driver.findElement(forgotPasswordlinkLocator).isDisplayed();
    }

    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }


public void login(String email ,String password){
 enterEmail(email);
 enterPassword(password);
 clickLoginButton();

}
public String getForgotPasswordPageUrl(){
        String ForgotPasswordPageUrl =driver.getCurrentUrl();
        return ForgotPasswordPageUrl;

}


}
