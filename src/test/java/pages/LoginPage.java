package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By EROOR_MASSAGE = By.cssSelector("[data-test=error]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
    public void login(String user, String pass) {
       driver.findElement(USERNAME_INPUT).sendKeys(user);
       driver.findElement(PASSWORD_INPUT).sendKeys(pass);
       driver.findElement(LOGIN_BUTTON).click();
    }
    public String getError() {
      return driver.findElement(EROOR_MASSAGE).getText();
    }
}
