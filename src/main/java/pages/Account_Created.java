package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account_Created extends Base_Page {
    public Account_Created(WebDriver driver) {
        super(driver);
    }

    private By continue_button = By.xpath("//*[@data-qa='continue-button']");

    public void click_on_coninue_button() {
        base_page_driver.findElement(continue_button).click();
    }
}
