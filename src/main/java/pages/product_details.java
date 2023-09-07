package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class product_details extends Base_Page {
    public product_details(WebDriver driver) {
        super(driver);
    }

    private By product_name = By.xpath("//div[@class='product-information']//h2[1]");
    private By catagory = By.xpath("//div[@class='product-information']//p[1]");
    private By price = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    private By availabilty = By.xpath("//b[text()='Availability:']");
    private By condition = By.xpath("//b[text()='Condition:']");
    private By brand = By.xpath("//b[text()='Brand:']");
    private By quantity = By.id("quantity");
    private By add_to_cart = By.xpath("//*[@class='btn btn-default cart']");
    private By view_cart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");

public boolean assert_product(){

        boolean name = base_page_driver.findElement(product_name).isDisplayed();
        boolean Catagory = base_page_driver.findElement(catagory).isDisplayed();
        boolean Price = base_page_driver.findElement(price).isDisplayed();
        boolean avalibile = base_page_driver.findElement(availabilty).isDisplayed();
        boolean Condition = base_page_driver.findElement(condition).isDisplayed();
        boolean Brand = base_page_driver.findElement(brand).isDisplayed();
        boolean result=name && Catagory&& Price && avalibile && Condition && Brand;
        return result;
    }

public void add_product_to_cart_from_details(String Quantity){

        base_page_driver.findElement(quantity).clear();
        base_page_driver.findElement(quantity).sendKeys(Quantity);
        base_page_driver.findElement(add_to_cart).click();
        base_page_driver.findElement(view_cart).click();
    }
}
