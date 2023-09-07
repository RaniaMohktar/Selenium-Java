package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class payment extends Base_Page {
    public payment(WebDriver driver) {
        super(driver);
    }


    private By name_onCard=By.name("name_on_card");
    private By card_num=By.name("card_number");
    private By cvc=By.name("cvc");
    private By expiry_month=By.name("expiry_month");
    private By expiry_year=By.name("expiry_year");
    private By pay_btn=By.xpath("//*[@data-qa='pay-button']");

    public void payment(String name,String num,String CVC ,String month,String year){
        base_page_driver.findElement(name_onCard).sendKeys(name);
        base_page_driver.findElement(card_num).sendKeys(num);
        base_page_driver.findElement(cvc).sendKeys(CVC);
        base_page_driver.findElement(expiry_month).sendKeys(month);
        base_page_driver.findElement(expiry_year).sendKeys(year);
        base_page_driver.findElement(pay_btn).click();
}
}
