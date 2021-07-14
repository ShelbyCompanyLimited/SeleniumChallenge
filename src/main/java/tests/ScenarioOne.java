package tests;

import base.Base;
import com.aventstack.extentreports.Status;
import helper.ReadFromPropertiesFile;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScenarioOne extends Base {

    @Test
    public void VerifyItemsToCheckout() throws InterruptedException, IOException {

        ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();

        test = extent.createTest("Scenario One");
        logger.info("Open and Verify Hope Page");
        //This function will verify elements on the HomePage and navigate to Above 1.5 Year Items
        homePage.VerifyHomePage();
        test.log(Status.INFO, "OpenAndVerifyHomePage");
        logger.info("OpenAndVerifyHomePage");

        test.log(Status.INFO, "Search For items above 1.5 years");
        logger.info("Search For items above 1.5 years");
        homePage.Search(Integer.valueOf(readFromPropertiesFile.getExpectedItemCount()));

        test.log(Status.INFO, "Select Items and go to Cart");
        logger.info("Select Items and go to Cart");
        homePage.SelectItemAndGoToCart(readFromPropertiesFile.getItemName(), readFromPropertiesFile.getItemPrice());

        test.log(Status.INFO, "Verify Checkout page");
        logger.info("Verify Checkout page");
        checkoutPage.CheckCheckoutPage(readFromPropertiesFile.getItemName(), readFromPropertiesFile.getItemPrice(), readFromPropertiesFile.getShippingPrice());

        test.log(Status.INFO, "Navigate To Payment");
        logger.info("Navigate To Payment");
        checkoutPage.NavigateToPayment();

    }

}


