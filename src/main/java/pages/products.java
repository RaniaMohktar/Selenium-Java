package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class products extends Base_Page {
    public products(WebDriver driver) {
        super(driver);
    }

    private By view_product = By.xpath("//*[@href='/product_details/2']");
    private By card = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]");
    private By card2 = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]");
    private By add_to_cart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");

    private By add_to_cart_2 = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");


    private By continue_shopping = By.xpath("//*[@class='btn btn-success close-modal btn-block']");
    private By cart = By.xpath("//*[@href='/view_cart']");
    private By women = By.xpath("//*[@href='#Women']");
    private By dress = By.xpath("//*[@href='/category_products/1']");
    private By men = By.xpath("//*[@href='#Men']");
    private By jeans = By.xpath("//*[@href='/category_products/6']");
    private By assert1 = By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a");


    private By search = By.id("search_product");
    private By submit_serch = By.id("submit_search");
    private By assert3 = By.xpath("//*[@class='title text-center']");


    public void scroll_down() {
        JavascriptExecutor js = (JavascriptExecutor) base_page_driver;
        js.executeScript("window.scrollBy(0,1500)");

    }


    public void view_product() {

        base_page_driver.findElement(view_product).click();
    }


    public void add_products_toCart() throws InterruptedException {
        WebElement x = base_page_driver.findElement(card);
        WebElement y = base_page_driver.findElement(add_to_cart);
        Actions action = new Actions(base_page_driver);
        action.moveToElement(x).perform();
        Thread.sleep(1000);
        action.click(y).perform();
        Thread.sleep(1000);
        base_page_driver.findElement(continue_shopping).click();


     /*   WebElement z = base_page_driver.findElement(card2);
        WebElement h = base_page_driver.findElement(add_to_cart_2);
        action.moveToElement(z).perform();
        Thread.sleep(1000);
        action.click(h).perform();
        Thread.sleep(1000);
        base_page_driver.findElement(continue_shopping).click();*/
    }

    public void view_cart() {
        base_page_driver.findElement(cart).click();
    }


    public void select_catagory() throws InterruptedException {

        base_page_driver.findElement(women).click();
        Thread.sleep(3000);
        base_page_driver.findElement(dress).click();


        //   boolean result = base_page_driver.findElement(assert1).isDisplayed();
        //   boolean result2 = base_page_driver.findElement(assert2).isDisplayed();
        //  boolean status = result && result2;
        // return status;
    }

    public String assertion(){
       String Result=base_page_driver.findElement(assert1).getText();
        return Result;
}
    public boolean search_on_product(String data) {
        base_page_driver.findElement(search).sendKeys(data);
        base_page_driver.findElement(submit_serch).click();
        boolean result = base_page_driver.findElement(assert3).isDisplayed();
        return result;
    }
}
