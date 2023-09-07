package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class order_placed extends Base_Page {
    public order_placed(WebDriver driver) {
        super(driver);
    }

    private By continue_btn = By.xpath("//*[@data-qa='continue-button']");
    private By download_btn = By.xpath("//*[@id=\"form\"]/div/div/div/a");


    public boolean IsOrderPlaced() {
        boolean result = base_page_driver.getPageSource().contains("Order Placed!");
        return result;
    }

    public void click_on_continue() {
        base_page_driver.findElement(continue_btn).click();
    }

    public void click_on_download() {
        base_page_driver.findElement(download_btn).click();
    }
}
