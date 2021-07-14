package pages;

import helper.PageObjectExtender;
import helper.xpathExtractorToString;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class HomePage extends PageObjectExtender {

    public HomePage(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(xpath = "(//button[@kind=\"lightTheme\"])")
    private WebElement PopUpContinueButton;

    @FindBy(xpath = "(//button[@kind=\"primary\"])")
    private WebElement AcceptCookies;

    @FindBy(xpath = "//*[@id=\"blt51f52bea34c3fb01_menubutton\"]")
    private WebElement ComprarButton;

    @FindBy(xpath = "//button[@data-analytics-title=\"age\"]")
    private WebElement SubmenuAge;

    @FindBy(xpath = "//a/span[1][text() = '1.5+']")
    private WebElement SelectAgeButton;

    @FindBy(xpath = "//*[@id=\"product-facet-prices-accordion-content\"]/div/div/ul/li[1]/label/div/div")
    private WebElement UnderTwentyCheckbox;

    @FindBy(xpath = "//*[@id=\"bltb4ff2489704d2385\"]/section/div/div/div[2]/ul/li")
    private WebElement SeachedItems;

    @FindBy(xpath = "//*[@id=\"bltb4ff2489704d2385\"]/section/div/div/div[3]/nav/div/")
    private WebElement NextPage;

    @FindBy(xpath = "//span[text() = 'Granja y Animales']")
    private WebElement ItemByName;

    @FindBy(xpath = "//span[text() = 'Granja y Animales']/../../../div[3]/div/span")
    private WebElement ItemPrice;

    @FindBy(xpath = "//span[text() = 'Granja y Animales']/../../../../div[2]/button")
    private WebElement ItemToChart;

    @FindBy(xpath = "//*[@data-test=\"view-my-bag\"]")
    private WebElement ViewMyBagButton;

    public void VerifyHomePage() throws InterruptedException, IOException {

        waitForPageLoad();
        waitForElement(PopUpContinueButton);
        PopUpContinueButton.click();
        waitForElement(AcceptCookies);
        AcceptCookies.click();
        waitForElement(ComprarButton);
    }

    public void Search(int expectedElements) throws InterruptedException, IOException {

        waitForElementToBeClickable(ComprarButton);
        waitForElement(ComprarButton);
        Thread.sleep(4000);
        ComprarButton.click();
        waitForElement(SubmenuAge);
        SubmenuAge.click();
        waitForElement(SelectAgeButton);
        SelectAgeButton.click();
        waitForElement(UnderTwentyCheckbox);
        UnderTwentyCheckbox.click();
        waitForElement(SeachedItems);


        //Convert Xpath To string in order to count elements
        String xpathToStringElement = xpathExtractorToString.xPathExtractor(SeachedItems);
        List<WebElement> list = driver.findElements(By.xpath(xpathToStringElement));
        int numberOfElements = list.size();

        int counter = 2;
        while (numberOfElements < expectedElements) {

            //Editing Element path in order to go over pagination
            String xpathToStringElementPages = xpathExtractorToString.xPathExtractor(NextPage);
            String element = xpathToStringElementPages + "a[" + counter + "]";
            WebElement newElement = driver.findElement(By.xpath(element));
            newElement.click();


            //Convert Xpath To string in order to count elements
            List<WebElement> listItems = driver.findElements(By.xpath(xpathToStringElement));

            numberOfElements = numberOfElements + listItems.size();

            counter++;
        }
        Assert.assertEquals(String.format("Number of elements in Popular category should be  %s", numberOfElements),
                expectedElements, numberOfElements);

    }

    public void SelectItemAndGoToCart(String expectedItemName, String expectedItemPrice) {


        String itemName = ItemByName.getText();
        Assert.assertEquals(String.format("Name of the item is not same"), expectedItemName, itemName);
        String itemPrice = ItemPrice.getText();
        Assert.assertTrue(String.format("Name of the item is not same.Expected Item Price is %s but we found %s",
                expectedItemPrice, itemPrice), itemPrice.contains(expectedItemPrice));
        ItemToChart.click();
        waitForElement(ViewMyBagButton);
        ViewMyBagButton.click();

    }
}
