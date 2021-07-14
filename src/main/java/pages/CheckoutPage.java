package pages;

import helper.PageObjectExtender;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;

public class CheckoutPage extends PageObjectExtender {

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[1]/div[1]/div[4]/div/div/div[1]/div[2]/div[1]/a/span/span")
    private WebElement itemNameTxt;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/span[2]/span")
    private WebElement oneItemPriceTxt;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div/div[2]/span[2]/span")
    private WebElement shippingPriceTxt;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div/div[3]/div[1]/span/span")
    private WebElement totalPriceTxt;

    @FindBy(xpath = "//a[@href=\"/es-es/checkout\"]")
    private WebElement CheckoutButton;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public void CheckCheckoutPage(String itemName, String itemPrice, String shippingPrice) {

        waitForPageLoad();
        waitForElement(oneItemPriceTxt);
        waitForElement(shippingPriceTxt);
        waitForElement(itemNameTxt);



        String oneItemValue = df2.format(Double.valueOf(oneItemPriceTxt.getText().substring(0, oneItemPriceTxt.getText().length() - 2)
                .replace(",",".")));
        String shippingItemPrice = df2.format(Double.valueOf(shippingPriceTxt.getText().substring(0,shippingPriceTxt.getText().length() -2)
                .replace(",",".")));
        String totalItemsPrice = df2.format(Double.valueOf(totalPriceTxt.getText().substring(0,totalPriceTxt.getText().length() -2)
                .replace(",",".")));

        Assert.assertEquals(String.format(" Shipping Price should be  %s", shippingPrice),
                shippingPrice.replace(",","."), shippingItemPrice);

        String expectedTotalPrice = df2.format(Double.valueOf(itemPrice.replace(",", ".")) +
                Double.valueOf(shippingPrice.replace(",", ".")));
        Assert.assertEquals(String.format(" Total Price should be   %s", expectedTotalPrice.toString()),
                expectedTotalPrice.toString(), totalItemsPrice);

        Assert.assertEquals(String.format(" Item Price should be  %s", itemPrice),
                itemPrice.replace(",","."), oneItemValue);


    }

    public void NavigateToPayment() {

        waitForElement(CheckoutButton);
        CheckoutButton.click();

    }

}
