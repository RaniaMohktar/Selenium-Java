package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUp_Login_Page extends Base_Page {

    public SignUp_Login_Page(WebDriver driver) {
        super(driver);
    }


    private By name = By.name("name");
    private By signup_email = By.xpath("//*[@data-qa='signup-email']");
    private By sgnup_button = By.xpath("//*[@data-qa='signup-button']");
    private By login_email = By.xpath("//*[@data-qa='login-email']");
    private By login_password = By.xpath("//*[@data-qa='login-password']");
    private By login_button = By.xpath("//*[@data-qa='login-button']");

    public void new_user_signUp(String username, String email) {
        base_page_driver.findElement(name).sendKeys(username);
        base_page_driver.findElement(signup_email).sendKeys(email);
        base_page_driver.findElement(sgnup_button).click();
    }

    public void login_ToYourAccount(String mail, String pass) {
        base_page_driver.findElement(login_email).sendKeys(mail);
        base_page_driver.findElement(login_password).sendKeys(pass);
        base_page_driver.findElement(login_button).click();
    }


}
