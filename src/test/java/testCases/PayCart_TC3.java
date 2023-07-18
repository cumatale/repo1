package testCases;

import com.aventstack.extentreports.Status;
import common.TestBase;
import org.testng.annotations.Test;
import pages.PayCartPage;
import utils.Utils;

import static javax.swing.JOptionPane.showMessageDialog;

public class PayCart_TC3 extends TestBase {

    @Test()
    public void login_and_logout() throws InterruptedException {
        test = extent.createTest("Pay Cart", "Case 1: User needs to verify if he can login and logout")
                .assignCategory("Functional_testcase")
                .assignAuthor("QA team");
        logger.info("Verify URL");

        openURL("https://petstore.octoperf.com/actions/Catalog.action");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");

        utils.waitForElementVisible(PayCartPage.cartImage);
        utils.clickOnButton(PayCartPage.cartImage);
        test.log(Status.INFO, "Click on Cart Image");
        logger.info("Click on Cart Image");

        utils.waitForElementVisible(PayCartPage.checkOut);
        utils.clickOnButton(PayCartPage.checkOut);
        test.log(Status.INFO, "Click on check out button");
        logger.info("Click on check out button");

        utils.waitForElementVisible(PayCartPage.cardNumber);
        utils.clearText(PayCartPage.cardNumber);
        utils.enterText(PayCartPage.cardNumber,"99999999999999");
        test.log(Status.INFO, "Add card number");
        logger.info("Add card number");

        utils.waitForElementVisible(PayCartPage.expiryDate);
        utils.clearText(PayCartPage.expiryDate);
        utils.enterText(PayCartPage.expiryDate,"99999999999999");
        test.log(Status.INFO, "Add expiry Date");
        logger.info("Add expiry Date");

        utils.waitForElementVisible(PayCartPage.firstName);
        utils.clearText(PayCartPage.firstName);
        utils.enterText(PayCartPage.firstName,"Ionescu");
        test.log(Status.INFO, "Add first Name");
        logger.info("Add first Name");

        utils.waitForElementVisible(PayCartPage.lastName);
        utils.clearText(PayCartPage.lastName);
        utils.enterText(PayCartPage.lastName,"Ion");
        test.log(Status.INFO, "Add last Name");
        logger.info("Add last Name");

        utils.waitForElementVisible(PayCartPage.address1);
        utils.clearText(PayCartPage.address1);
        utils.enterText(PayCartPage.address1,"bloc 5, ap 5");
        test.log(Status.INFO, "Add address 1");
        logger.info("Add address 1");

        utils.waitForElementVisible(PayCartPage.address2);
        utils.clearText(PayCartPage.address2);
        utils.enterText(PayCartPage.address2,"str. Trufelor 34");
        test.log(Status.INFO, "Add address 2");
        logger.info("Add address 2");

        utils.waitForElementVisible(PayCartPage.city);
        utils.clearText(PayCartPage.city);
        utils.enterText(PayCartPage.city,"Judetul Ilfov");
        test.log(Status.INFO, "Add city");
        logger.info("Add city");

        utils.waitForElementVisible(PayCartPage.country);
        utils.clearText(PayCartPage.country);
        utils.enterText(PayCartPage.country,"Romania");
        test.log(Status.INFO, "Add country");
        logger.info("Add country");

        utils.waitForElementVisible(PayCartPage.zip);
        utils.clearText(PayCartPage.zip);
        utils.enterText(PayCartPage.zip,"2050");
        test.log(Status.INFO, "Add zip");
        logger.info("Add zip");

        utils.waitForElementVisible(PayCartPage.newOrder);
        utils.clickOnButton(PayCartPage.newOrder);
        test.log(Status.INFO, "Click on new order button");
        logger.info("Click on new order button");
    }
}
