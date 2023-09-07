package E2E_Scenarios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;

public class Create_customer  {
    WebDriver base_page_driver;
HomePage hp;
SignUp_Login_Page slp;
SignUp_Page sp;
Account_Created ac;
Delete_Account da ;
Welcome_Page wp;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    //https://github.com/RaniaMohktar/Selenium-Java
    @BeforeMethod
        public void set_up() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-infobars");
    options.addExtensions(new File("C://Users//Asus//Downloads//extension_5_9_0_0 (1).crx"));
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    options.merge(capabilities);
    base_page_driver= new ChromeDriver(options);

    base_page_driver.manage().window().maximize();
    base_page_driver.get("http://automationexercise.com");

 htmlReporter = new ExtentHtmlReporter("RaniaReport2s.html");
    extent = new ExtentReports();

}
    @Test
 public void create_new_customer() throws InterruptedException {
   hp=new HomePage(base_page_driver);
   slp=new SignUp_Login_Page(base_page_driver);
   sp=new SignUp_Page(base_page_driver);
   ac =new Account_Created(base_page_driver);
   da =new Delete_Account(base_page_driver);
   hp=new HomePage(base_page_driver);
   slp=new SignUp_Login_Page(base_page_driver);
wp =new Welcome_Page(base_page_driver);

        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("MyFirstTest");

         hp.click_on_signup_login_link();
         slp.new_user_signUp("rania","raniaali713@yahoo.com");
         sp.Enter_account_info("Mrs","rania","123","1","November","1995","rania","mokhtar","vois","october", "october2","Canada","ef","cairo","1256","01022532885");
          Thread.sleep(5000);
            base_page_driver.switchTo().alert().accept();
           ac.click_on_coninue_button();
          da.click_on_coninue_button_toDelete();
         test.pass("the test is passed");


    }
    @AfterMethod
    public void teardown() {
        wp = new Welcome_Page(base_page_driver);
        wp.logout();
        base_page_driver.quit();
        extent.flush();
    }
}
