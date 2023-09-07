package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Cart extends Base_Page {
    public Cart(WebDriver driver) {
        super(driver);
    }

    private By price = By.xpath("//*[@class='cart_price']//p[1]");
    private By quantity = By.xpath("//*[@class='cart_quantity']//button[1]");
    private By total = By.xpath("//*[@class='cart_total_price']");
    private By delete = By.xpath("//*[@class='fa fa-times']");
    private By checkout = By.xpath("//*[@class='btn btn-default check_out']");


    public String get_price() {
        String Price = base_page_driver.findElement(price).getText();
        Price = Price.replaceAll("[^0-9]", " ");
        Price = Price.replaceAll(" +", " ");

        if (Price.equals(""))
            return "-1";

        return Price;
    }

    public String get_quantity() {
        String Quantity = base_page_driver.findElement(quantity).getText();
        return Quantity;
    }

    public String get_total_price() {
        String Total = base_page_driver.findElement(total).getText();
        Total = Total.replaceAll("[^0-9]", " ");
        Total = Total.replaceAll(" +", " ");

        if (Total.equals(""))
            return "-1";

        return Total;

    }

    public void click_on_delete() {
        base_page_driver.findElement(delete).click();
    }

    public void click_on_checkout() {
        base_page_driver.findElement(checkout).click();
    }

}



