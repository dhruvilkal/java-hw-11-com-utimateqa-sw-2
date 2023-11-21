package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully
 *      click on the ‘Sign In’ link
 *      Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 *      click on the ‘Sign In’ link
 *      Enter invalid username
 *      Enter invalid password
 *      Click on Login button
 *      Verify the error message ‘Invalid email  or password.’
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void SetUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // Click on the "Sign In" link
        WebElement signLink = driver.findElement(By.linkText("Sign In"));
        signLink.click();
        //Verify the text 'Welcome Back!'
        String expectedText = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        WebElement signLink = driver.findElement(By.linkText("Sign In"));
        signLink.click();
        //Enter invalid username
        WebElement userName = driver.findElement(By.name("user[email]"));
        userName.sendKeys("Abcd@2");
        //Enter invalid password
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("1234568");
        //Click on login
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
         // Verify the error message
        //expected result
        String expectedText = "Please enter a valid email address";
        WebElement actualTextElement = driver.findElement(By.xpath("//p[@aria-live='polite']"));
        String actualText = actualTextElement.getText();
        //verify expected and actual text
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void tearDown(){

         closeBrowser();
    }

}
