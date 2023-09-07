package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp_Page extends Base_Page {
    public SignUp_Page(WebDriver driver) {
        super(driver);
    }

    private By male = By.id("id_gender1");
    private By female = By.id("id_gender2");
    private By name = By.id("name");
    private By password = By.id("password");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By newesletter = By.id("newsletter");
    private By offers = By.id("optin");
    private By fname = By.id("first_name");
    private By lname = By.id("last_name");
    private By company = By.id("company");
    private By address = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobile_num = By.id("mobile_number");
    private By create_account = By.xpath("//*[@data-qa='create-account']");

    public void Enter_account_info(String type, String Name, String Password, String day, String month, String year
            , String Fname, String Lname, String Company, String Address, String Address2, String Country
            , String State, String City, String Zipcode, String Mobile_num) throws InterruptedException {
        if (type == "Mr")
            base_page_driver.findElement(male).click();
        else if (type == "Mrs")
            base_page_driver.findElement(female).click();

        base_page_driver.findElement(name).clear();
        base_page_driver.findElement(name).sendKeys(Name);

        base_page_driver.findElement(password).sendKeys(Password);

        Select select_day = new Select(base_page_driver.findElement(days));
        select_day.selectByVisibleText(day);
        Select select_month = new Select(base_page_driver.findElement(months));
        select_month.selectByVisibleText(month);
        Select select_year = new Select(base_page_driver.findElement(years));
        select_year.selectByVisibleText(year);


        base_page_driver.findElement(newesletter).click();


        base_page_driver.findElement(offers).click();

        JavascriptExecutor js = (JavascriptExecutor) base_page_driver;
        js.executeScript("window.scrollBy(0,1000)");

        base_page_driver.findElement(fname).sendKeys(Fname);


        base_page_driver.findElement(lname).sendKeys(Lname);

        base_page_driver.findElement(company).sendKeys(Company);


        base_page_driver.findElement(address).sendKeys(Address);


        base_page_driver.findElement(address2).sendKeys(Address2);

         js = (JavascriptExecutor) base_page_driver;
        js.executeScript("window.scrollBy(0,100)");


        Select select_country = new Select(base_page_driver.findElement(country));
        select_country.selectByVisibleText(Country);


        base_page_driver.findElement(state).sendKeys(State);


        base_page_driver.findElement(city).sendKeys(City);


        base_page_driver.findElement(zipcode).sendKeys(Zipcode);


        base_page_driver.findElement(mobile_num).sendKeys(Mobile_num);


        base_page_driver.findElement(create_account).click();

    }
}
