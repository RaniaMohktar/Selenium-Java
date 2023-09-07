package E2E_Scenarios;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class add_product {

    WebDriver base_page_driver;
    HomePage hp;
    SignUp_Login_Page slp;
    products p;
    Cart c;
    checkout ch;
    payment pa;
    order_placed op;
    Welcome_Page wp;
    SignUp_Page sp;
     contact_us cu;

    @BeforeMethod
    public void set_up() {
/*
       ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-infobars");
        base_page_driver = new ChromeDriver(options);*/

        //add aextenstion to disable adds
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C://Users//Asus//Downloads//extension_5_9_0_0 (1).crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        base_page_driver = new ChromeDriver(options);
        base_page_driver.manage().window().maximize();
        base_page_driver.get("http://automationexercise.com");

    }



/*@Test(dataProvider = "test_data")
public void login(String user,String pass){
    hp = new HomePage(base_page_driver);
    slp = new SignUp_Login_Page(base_page_driver);

    hp.click_on_signup_login_link();
    slp.login_ToYourAccount(user, pass);
}*/

    @Test(dataProvider = "test_data")
    public void place_order(String user, String pass) throws InterruptedException {
        //initializa all pages will be needed
        slp = new SignUp_Login_Page(base_page_driver);
        hp = new HomePage(base_page_driver);
        p = new products(base_page_driver);
        c = new Cart(base_page_driver);
        ch = new checkout(base_page_driver);
        pa = new payment(base_page_driver);
        op = new order_placed(base_page_driver);
        sp=new SignUp_Page(base_page_driver);
        cu= new contact_us(base_page_driver);


        //steps to place a new order
        hp.click_on_signup_login_link();
        slp.login_ToYourAccount(user, pass);
        hp.click_on_products();
         p.search_on_product("Blue Top");
        p.add_products_toCart();
        p.view_cart();
        String result= p.assertion();
        String price= c.get_price();
        String quantity= c.get_quantity();
        String total=c.get_total_price();
        c.click_on_checkout();
        ch.scroll_to_footer();
        ch.place_order("for test");
        pa.payment("rania","1223","234","12","2022");
        op.click_on_download();



       //assertion
        Assert.assertEquals(result, "Blue Top");
        Assert.assertEquals(price, " 500");
        Assert.assertEquals(quantity, "1");
        Assert.assertEquals(total, " 500");



        //implented functions but not included in this scenarion

     // hp.click_on_contact_us();
     // cu.contact_us("Rasni","raniaaa222","test","just for testing","C://Users//Asus//Downloads//testing.xlsx");
      //  p.scroll_down();
      //  p.select_catagory();
      //  base_page_driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      // hp.click_on_cart();
      //  boolean result = op.IsOrderPlaced();
      //  hp.make_subscription("raniaaaa");


    }
    @DataProvider
    public Object[][] test_data() throws IOException, InvalidFormatException {
        excel e =new excel();
        return e.excel();
    }

    @AfterMethod
    public void teardown() {
        wp = new Welcome_Page(base_page_driver);
        wp.logout();
       base_page_driver.quit();
    }
}
