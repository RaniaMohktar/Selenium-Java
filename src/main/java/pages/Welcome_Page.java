package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Welcome_Page extends Base_Page {
    public Welcome_Page(WebDriver driver) {
        super(driver);
    }

    private By delete_account = By.xpath("//*[@href='/delete_account']");
    private By login_name= By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    private By logout = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public void click_on_delete_account() {
        base_page_driver.findElement(delete_account).click();
    }


    public void logout() {
        base_page_driver.findElement(logout).click();
    }
    }


