

package utils;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Utils extends TestBase {

    public enum LocatorType {
        id,
        xpath,
        name,
        linkText
    }
    public enum ActionType {
        click,
        enterText,
        clearText,
        waitVisible
    }
    public enum GetType {
        getText,
        getPlaceholder
    }
    public static By getLocatorByType(String locatorByValue, LocatorType locatorType){
        switch(locatorType) {
            case id:
                 return By.id(locatorByValue);
            case xpath:
                 return By.xpath(locatorByValue);
            case name:
                 return By.name(locatorByValue);
            case linkText:
                return By.linkText(locatorByValue);
            default:
                 return By.partialLinkText(locatorByValue);
        }
    }
    public static void generalActionSeleniumMethode(String locatorByValue, LocatorType locatorType, ActionType actionType, String textValue){
        By locator;
        locator=getLocatorByType(locatorByValue,locatorType);
        WebElement element = driver.findElement(locator);
        switch(actionType) {
            case click:
                element.click();
                break;
            case enterText:
                element.sendKeys(textValue);
                break;
            case clearText:
                element.clear();
                break;
            case waitVisible:
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
        }
    }
public static String generalGetSeleniumMethode(String locatorByValue, LocatorType locatorType, GetType getType){
    WebElement element = driver.findElement(getLocatorByType(locatorByValue,locatorType));
    switch(getType) {
        case getText:
            return element.getText();
        case getPlaceholder:
            return element.getAttribute("placeholder");
        default:
            return "";
    }

}
    public static void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void clearText(By locator) {

        WebElement element = driver.findElement(locator);
        element.clear();
    }

    public static void clickOnButton(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public String getPlaceholder(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute("placeholder");
    }

    public void selectValueOnDropDown(By locator, String Text) {

        Select selectValue = new Select(driver.findElement(locator));
        selectValue.selectByVisibleText(Text);
    }

    public void selectValueOnCheckBox(By chkBoxCollection, By labelText, By getInput, String Text) {

        List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
        for (WebElement webElement : chkBoxCollections) {
            WebElement getLabel = webElement.findElement(labelText);
            WebElement getInput1 = webElement.findElement(getInput);

            if (getLabel.getText().equals(Text)) {
                if (!getInput1.isSelected()) {
                    getLabel.click();
                    break;
                }
            }
        }

    }

    public void switchTabs() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String parent_window = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String child_window = i1.next();
            if (!parent_window.equalsIgnoreCase(child_window)) {
                driver.switchTo().window(child_window);
                driver.close();
            }
        }

        driver.switchTo().window(parent_window);
    }

    public static void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


}