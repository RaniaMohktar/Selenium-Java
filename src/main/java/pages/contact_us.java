package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class contact_us extends Base_Page {
    public contact_us(WebDriver driver) {
        super(driver);

    }


    private By name = By.name("name");
    private By email = By.name("email");
    private By subject = By.name("subject");
    private By message = By.name("message");
    private By upload = By.name("upload_file");
    private By submit = By.name("submit");

    public void contact_us(String Name, String Email, String Subject, String Message, String path) {
        base_page_driver.findElement(name).sendKeys(Name);
        base_page_driver.findElement(email).sendKeys(Email);
        base_page_driver.findElement(subject).sendKeys(Subject);
        base_page_driver.findElement(message).sendKeys(Message);
        base_page_driver.findElement(upload).sendKeys(path);
        base_page_driver.findElement(submit).click();
    }
}
