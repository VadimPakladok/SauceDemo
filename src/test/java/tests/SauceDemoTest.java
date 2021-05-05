package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SauceDemoTest extends BaseTest{
    @Test

    void locatorId() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
//        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();

        String nameBag = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        String priceBag = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        driver.findElement(By.xpath("//*[text()='" + nameBag + "']//following::button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String nameInCart = driver.findElement(By.id("item_4_title_link")).getText();
        String priceInCart = driver.findElement(By.xpath("//*[@class='inventory_item_price']")).getText();
        assertEquals(nameBag, nameInCart, "Item name is different");
        assertEquals(priceInCart, priceBag, "Item price is different");


    }
    @Test
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", PASSWORD);
        String error = loginPage.getError();
        assertEquals(error, "Epic sadface: Username is required", "Error massege is not corrert");

    }

    @Test
    public void passwordIsNotRequired() {
        loginPage.open();
        loginPage.login(USER, "");
        String error = loginPage.getError();
        assertEquals(error, "Epic sadface: Password is required", "Error massege is not corrert");
    }
    @Test
    public void nameAndPasswordIsWrong() {
        loginPage.open();
        loginPage.login("notUser", "notPassword");
        String error = loginPage.getError();
        assertEquals(error, "Epic sadface: Username and password do not match any user in this service",
                "Error message is not correct");

    }
    @Test
    public void lockedOutUser() {
        loginPage.open();
        loginPage.login("locked_out_user", PASSWORD);
        String error = loginPage.getError();
        assertEquals(error, "Epic sadface: Sorry, this user has been locked out.", "Error massege is not correct");
    }
}
