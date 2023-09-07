package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base_Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private By signup_login = By.xpath("//*[@href='/login']");
    private By contact_us = By.xpath("//*[@href='/contact_us']");
    private By products = By.xpath("//*[@href='/products']");
    private By cart = By.xpath("//*[@href='/view_cart']");
    private By sub_email = By.id("susbscribe_email");
    private By sub_button = By.xpath("//*[@class='fa fa-arrow-circle-o-right']");


    public void click_on_signup_login_link() {

        base_page_driver.findElement(signup_login).click();
    }

    public void click_on_contact_us() {
        base_page_driver.findElement(contact_us).click();
    }

    public void click_on_products() {
        base_page_driver.findElement(products).click();
    }

    public void click_on_cart() {
        base_page_driver.findElement(cart).click();
    }


    public void make_subscription(String mail) {
        base_page_driver.findElement(sub_email).sendKeys(mail);
        base_page_driver.findElement(sub_button).click();
    }

}
