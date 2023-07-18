package pages;

import common.TestBase;
import org.openqa.selenium.By;

public class PayCartPage extends TestBase {


	public static By cartImage = By.name("img_cart");
	public static By checkOut = By.xpath("//*[@id=\"Cart\"]/a");
	public static  By cardNumber = By.name("order.creditCard");
	public static By expiryDate = By.name("order.expiryDate");
	public static By firstName = By.name("order.billToFirstName");
	public static By lastName = By.name("order.billToLastName");
	public static By address1 = By.name("order.billAddress1");
	public static By address2 = By.name("order.billAddress2");
	public static By city = By.name("order.billCity");
	public static By state = By.name("order.billState");
	public static By zip = By.name("order.billZip");
	public static By country = By.name("order.billCountry");
	public static By newOrder = By.name("order.newOrder");
}
