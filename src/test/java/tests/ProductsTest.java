package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        //cartPage.open();
        //TODO VALIDATE NAME AND PRICE


    }
}
