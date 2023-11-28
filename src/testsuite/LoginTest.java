package testsuite;
/**
 * Login with valid Credentials
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify the text “PRODUCTS”
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    static String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl); //Opening Browser
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Finding Element for username and sending text to username field
        sendTextToElement(By.id("user-name"), "standard_user");
        ///Finding Element for password and sending text to password field
        sendTextToElement(By.id("password"),"secret_sauce");
        // Click on 'Login' button
        clickOnElement(By.name("login-button"));
        Thread.sleep(3000);
        //Verify the text “PRODUCTS”
        verifyText("Products",getTextFromElement(By.xpath("//span[@class='title']")));
        Thread.sleep(3000);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //Finding Element for username and sending text to username field
        sendTextToElement(By.id("user-name"), "standard_user");
        ///Finding Element for password and sending text to password field
        sendTextToElement(By.id("password"),"secret_sauce");
        // Click on 'Login' button
        clickOnElement(By.name("login-button"));

        //Verify that six products are displayed on page
        List<WebElement> productsDisplayed = driver.findElements(By.className("inventory_item"));
        int number = productsDisplayed.size();
        System.out.println("Number of products displayed in the page : " + number);
        Thread.sleep(5000);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
