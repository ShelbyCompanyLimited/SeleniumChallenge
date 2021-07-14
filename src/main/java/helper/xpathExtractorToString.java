package helper;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class xpathExtractorToString {
    //This function will always get the numbers of same elements on same position
    public static String xPathExtractor(WebElement El) throws AssertionError {
        if ((El instanceof WebElement)) {
            Object o = El;
            String text = o.toString();
            text = text.substring(text.indexOf("xpath: ") + 7, text.length() - 1);
            return text;
        } else {
            Assert.fail("Argument is not an WebElement, his actual class is:" + El.getClass());
        }
        return "";
    }
}
