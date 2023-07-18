package testCases;

import com.aventstack.extentreports.Status;
import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import utils.Utils;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddToCart_TC2 extends TestBase {
    @Test()
    public void login_and_logout() throws InterruptedException {
        System.out.println("am intrat in test");
        test = extent.createTest("Add to Cart", "Case 2: User create his shopping cart")
                .assignCategory("Functional_testcase")
                .assignAuthor("QA team");
        logger.info("Verify cart generator");

        openURL("https://petstore.octoperf.com/actions/Catalog.action");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");
        //logare
        utils.generalActionSeleniumMethode("Sign In", Utils.LocatorType.linkText, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("Sign In", Utils.LocatorType.linkText, Utils.ActionType.click,"");

        utils.generalActionSeleniumMethode("username", Utils.LocatorType.name, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("username", Utils.LocatorType.name, Utils.ActionType.clearText,"");
        utils.generalActionSeleniumMethode("username", Utils.LocatorType.name, Utils.ActionType.enterText,"VARGBT");

        utils.generalActionSeleniumMethode("password", Utils.LocatorType.name, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("password", Utils.LocatorType.name, Utils.ActionType.clearText,"");
        utils.generalActionSeleniumMethode("password", Utils.LocatorType.name, Utils.ActionType.enterText,"PSzaq1!QAZ");

        utils.generalActionSeleniumMethode("signon", Utils.LocatorType.name, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("signon", Utils.LocatorType.name, Utils.ActionType.click,"");

        //adaugare in cos
        String mesaj=Animale();
        utils.generalActionSeleniumMethode("img_cart", Utils.LocatorType.name, Utils.ActionType.waitVisible,"");
        utils.generalActionSeleniumMethode("img_cart", Utils.LocatorType.name, Utils.ActionType.click,"");
        showMessageDialog(null,"In cartela sunt "+mesaj);
    }
    public int lungimeTabel(String elem) {
        int i=1;
        try{
            WebElement element;
            while ( i<6){
//                element = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[" + (i + 1) + "]/td[1]/a"));
//                System.out.println("i:" + i + "=" + element.getText());
                 utils.generalActionSeleniumMethode("//*[@id=\"Catalog\"]/table/tbody/tr[" + (i + 1) + "]/td[1]/a", Utils.LocatorType.xpath, Utils.ActionType.waitVisible,"");
                 System.out.println("i:" + i + "=" + utils.generalGetSeleniumMethode("//*[@id=\"Catalog\"]/table/tbody/tr[" + (i + 1) + "]/td[1]/a",Utils.LocatorType.xpath,Utils.GetType.getText));
                i++;
            }
            System.out.println("Lungimea tabelului din try pentru elem="+elem+" este="+(i-1));
            return (i-1);
        } catch (Exception e){
            System.out.println("Lungimea tabelului din catch pentru elem="+elem+" este="+(i-1));
            return (i-1);
        }
    }
 /*   public void Animale()throws InterruptedException{
        System.out.println("am intrat in metoda Animale");
        int i=1;
        AddToCartPage obiect=new AddToCartPage();
        obiect.CaleAnimal="//*[@id=\"QuickLinks\"]/a["+i+"]/img";
        System.out.println("aici vreau sa vad ce xpath s-a alocat: "+obiect.CaleAnimal);
        utils.waitForElementVisible(AddToCartPage.AnimalButton);
        utils.clickOnButton(AddToCartPage.AnimalButton);
        System.out.println("cale_I "+i+"="+AddToCartPage.CaleAnimal);
        utils.getText(AddToCartPage.AnimalButton);
//        System.out.println(driver.findElement(By.xpath(caleI)).getText());
//        Thread.sleep(sec);
        int nrRase=lungimeTabel(AddToCartPage.CaleAnimal);
        System.out.println(nrRase);
    }

  */
   public String Animale()throws InterruptedException {
       int contorAdd=0;
       int contorExemplare=0;
       int sec = 10;
       int nrRase = 0;
       int nrExemplare = 0;
       int nrAnimale=5;
       String caleI, caleJ, caleK;
       for (int i = 1; i <= nrAnimale; i++) {
           caleI = "//*[@id=\"QuickLinks\"]/a[" + i + "]/img";
           // driver.findElement(By.xpath(caleI)).click();
           //  System.out.println(driver.findElement(By.xpath(caleI)).getText());
           //Thread.sleep(sec);
           Utils.generalActionSeleniumMethode(caleI, Utils.LocatorType.xpath, Utils.ActionType.waitVisible, "");
           Utils.generalActionSeleniumMethode(caleI, Utils.LocatorType.xpath, Utils.ActionType.click, "");
           //System.out.println("cale_I " + i + "=" + caleI);
           System.out.println(Utils.generalGetSeleniumMethode(caleI, Utils.LocatorType.xpath, Utils.GetType.getText));
           nrRase = lungimeTabel(caleI);
           System.out.println("i=" + i + " nrRase=" + nrRase);
           for (int j = 1; j <= nrRase; j++) {
               caleJ = "//*[@id=\"Catalog\"]/table/tbody/tr[" + (j + 1) + "]/td[1]/a";
               //System.out.println("cale_J " + j + "=" + caleJ);
               //              driver.findElement(By.xpath(caleJ)).click();
               //             System.out.println(driver.findElement(By.xpath(caleJ)).getText());
//               Thread.sleep(sec);
               Utils.generalActionSeleniumMethode(caleJ, Utils.LocatorType.xpath, Utils.ActionType.waitVisible, "");
               Utils.generalActionSeleniumMethode(caleJ, Utils.LocatorType.xpath, Utils.ActionType.click, "");
               //System.out.println("cale_I " + i + "=" + caleJ);
               nrExemplare = lungimeTabel(caleJ);
               contorExemplare+=nrExemplare;
               System.out.println("j=" + j + " nrExemplare=" + nrExemplare);
               for (int k = 1; k <= nrExemplare; k++) {
                   caleK = "//*[@id=\"Catalog\"]/table/tbody/tr[" + (k + 1) + "]/td[5]/a";
                   System.out.println("cale_K " + k + "=" + caleK);
                   //driver.findElement(By.xpath(caleK)).click();
                   //System.out.println("Intrat in cartela");
                   //System.out.println(driver.findElement(By.xpath(caleK)).getText());
                   //Thread.sleep(sec);
                   Utils.generalActionSeleniumMethode(caleK, Utils.LocatorType.xpath, Utils.ActionType.waitVisible, "");
                   Utils.generalActionSeleniumMethode(caleK, Utils.LocatorType.xpath, Utils.ActionType.click, "");
                   contorAdd++;
                   driver.navigate().back();
                   //Thread.sleep(sec);
                   driver.navigate().refresh();
               }
               //Thread.sleep(sec);
               driver.navigate().back();
               //Thread.sleep(sec);
               driver.navigate().refresh();
           }
       }
       return "contorAdd="+contorAdd+"; contorExemplare="+contorExemplare;
   }
}
