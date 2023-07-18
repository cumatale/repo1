package testCases;

import com.aventstack.extentreports.Status;
import common.TestBase;
import org.testng.annotations.Test;
import utils.Utils;

import static javax.swing.JOptionPane.showMessageDialog;

public class LogInOut_TC1 extends TestBase {

    @Test()
    public void login_and_logout() throws InterruptedException {
        test = extent.createTest("Login and logout", "Case 1: User needs to verify if he can login and logout")
                .assignCategory("Functional_testcase")
                .assignAuthor("QA team");
        logger.info("Verify URL");

        openURL("https://petstore.octoperf.com/actions/Catalog.action");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");

//        utils.waitForElementVisible(LogInOutPage.LoginBtn);
//        utils.clickOnButton(LogInOutPage.LoginBtn);
        utils.generalActionSeleniumMethode("Sign In", Utils.LocatorType.linkText, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("Sign In", Utils.LocatorType.linkText, Utils.ActionType.click,"");
        test.log(Status.INFO, "Click on Login Button(Homepage)");
        logger.info("Click on Login Button(Homepage)");
        System.out.println("Click on Login Button(Homepage)");

//        utils.waitForElementVisible(LogInOutPage.userName);
//        utils.clearText(LogInOutPage.userName);
//        utils.enterText(LogInOutPage.userName,"VAGBT");
        utils.generalActionSeleniumMethode("username", Utils.LocatorType.name, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("username", Utils.LocatorType.name, Utils.ActionType.clearText,"");
        utils.generalActionSeleniumMethode("username", Utils.LocatorType.name, Utils.ActionType.enterText,"VAGBT");
        test.log(Status.INFO, "Add username");
        logger.info("Add username");
        System.out.println("Add username");
        showMessageDialog(null, "am dat click pe Sign in si am introdus username");

//        utils.waitForElementVisible(LogInOutPage.password);
//        utils.clearText(LogInOutPage.password);
//        utils.enterText(LogInOutPage.password,"PSzaq1!QAZ");
        utils.generalActionSeleniumMethode("password", Utils.LocatorType.name, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("password", Utils.LocatorType.name, Utils.ActionType.clearText,"");
        utils.generalActionSeleniumMethode("password", Utils.LocatorType.name, Utils.ActionType.enterText,"PSzaq1!QAZ");
        test.log(Status.INFO, "Add password");
        logger.info("Add password");
        System.out.println("Add password");

//        utils.waitForElementVisible(LogInOutPage.loginBtn);
//        utils.clickOnButton(LogInOutPage.loginBtn);
        utils.generalActionSeleniumMethode("signon", Utils.LocatorType.name, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("signon", Utils.LocatorType.name, Utils.ActionType.click,"");
        test.log(Status.INFO, "Click on Login Button");
        logger.info("Click on Login Button");
        System.out.println("Click on Login Button");

//        utils.waitForElementVisible(LogInOutPage.logoutBtn);
//        utils.clickOnButton(LogInOutPage.logoutBtn);
        utils.generalActionSeleniumMethode("Sign Out", Utils.LocatorType.linkText, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("Sign Out", Utils.LocatorType.linkText, Utils.ActionType.click,"");
        test.log(Status.INFO, "Click on Logout Button");
        logger.info("Click on Logout Button");
        System.out.println("Click on Logout Button");


    }
}
