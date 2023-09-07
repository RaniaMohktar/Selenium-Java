package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class checkout extends Base_Page {
    public checkout(WebDriver driver) {
        super(driver);
    }

    private By message = By.name("message");
    private By place_order = By.xpath("//*[@href='/payment']");


    public void place_order(String comment)  {
        base_page_driver.findElement(message).sendKeys(comment);
        base_page_driver.findElement(place_order).click();

    }


    public void scroll_to_footer() {
        JavascriptExecutor js = (JavascriptExecutor) base_page_driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
