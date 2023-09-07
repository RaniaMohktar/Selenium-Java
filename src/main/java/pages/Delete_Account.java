package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Delete_Account extends Base_Page {
    public Delete_Account(WebDriver driver) {
        super(driver);
    }

    private By continue_button_toDelete = By.xpath("//*[@data-qa='continue-button']");

    public void click_on_coninue_button_toDelete() {
        base_page_driver.findElement(continue_button_toDelete).click();
    }

}
