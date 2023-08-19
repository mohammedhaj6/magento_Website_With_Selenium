import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.asm.Advice.Enter;

public class FinalProject extends MyParameters {
	@BeforeTest
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("haj48518@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("123456test@@");
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();

	}

//	@Test()
//	public void sign_up() {
//		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a")).click();
//		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Mohammed");
//		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(" El-Haj");
//		driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("haj48518@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456test@@");
//		driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys("123456test@@");
//		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
//
//	}
//	@Test(invocationCount = 1)
//	public void search_bar_search_randomly() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("haj48518@gmail.com");
//	    driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("123456test@@");
//	    driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
//		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"search\"]"));
//		Random rand = new Random();
//		String[] items = { "jacket", "t-shirt", "jeans for men", "jeans for women", "pants" };
//		int randomItems = rand.nextInt(items.length);
//		searchBar.sendKeys(items[randomItems]);
//		searchBar.sendKeys(Keys.ENTER);
//        String SentText = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
//	    boolean containText = SentText.contains(items[randomItems]);
//	    SoftAssert myAssert = new SoftAssert();
//	    myAssert.assertEquals(containText, true);
//	    myAssert.assertAll();
//
//
//	}
	@Test(priority = 1)
	public void add_the_item_with_randomly_size_and_color() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String[] urlPage = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html",
				"https://magento.softwaretestingboard.com/fusion-backpack.html" };
		String[] pathSize = { "//*[@id=\"option-label-size-143-item-166\"]",
				"//*[@id=\"option-label-size-143-item-167\"]", "//*[@id=\"option-label-size-143-item-168\"]",
				"//*[@id=\"option-label-size-143-item-169\"]", "//*[@id=\"option-label-size-143-item-170\"]" };
		String[] pathColorsRadiantTee = { "//*[@id=\"option-label-color-93-item-50\"]",
				"//*[@id=\"option-label-color-93-item-56\"]", "//*[@id=\"option-label-color-93-item-57\"]" };
		String[] pathColorBreatheEasyTank = { "//*[@id=\"option-label-color-93-item-57\"]",
				"//*[@id=\"option-label-color-93-item-59\"]", "//*[@id=\"option-label-color-93-item-60\"]" };
		String[] pathColorArgusAllWeatherTank = { "//*[@id=\"option-label-color-93-item-52\"]" };
		String[] pathColorHeroHoodie = { "//*[@id=\"option-label-color-93-item-49\"]",
				"//*[@id=\"option-label-color-93-item-52\"]", "//*[@id=\"option-label-color-93-item-53\"]" };

		Random randPage = new Random();
		Random randSize = new Random();
		Random randRadiantTee = new Random();
		Random randBreatheEasyTank = new Random();
		Random raandArgusAllWeatherTank = new Random();
		Random randHeroHoodie = new Random();
		int indexOfPage = randPage.nextInt(urlPage.length);
		int indexOfSize = randSize.nextInt(pathSize.length);
		int indexOfRadiantTee = randRadiantTee.nextInt(pathColorsRadiantTee.length);
		int indexOfBreatheEasyTank = randBreatheEasyTank.nextInt(pathColorBreatheEasyTank.length);
		int indexOfArgusAllWeatherTank = raandArgusAllWeatherTank.nextInt(pathColorArgusAllWeatherTank.length);
		int indexOfHeroHoodie = randHeroHoodie.nextInt(pathColorHeroHoodie.length);

		driver.get(urlPage[indexOfPage]);
		Thread.sleep(2000);
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		if (urlPage[indexOfPage].contains("radiant-tee")) {
			driver.findElement(By.id("qty")).clear();
			driver.findElement(By.id("qty")).sendKeys("3");
			driver.findElement(By.xpath(pathSize[indexOfSize])).click();
			driver.findElement(By.xpath(pathColorsRadiantTee[indexOfRadiantTee])).click();
			Thread.sleep(2000);
			addToCart.click();

		} else if (urlPage[indexOfPage].contains("breathe-easy-tank")) {
			driver.findElement(By.id("qty")).clear();
			driver.findElement(By.id("qty")).sendKeys("2");
			driver.findElement(By.xpath(pathSize[indexOfSize])).click();
			driver.findElement(By.xpath(pathColorBreatheEasyTank[indexOfBreatheEasyTank])).click();
			Thread.sleep(2000);
			addToCart.click();

		} else if (urlPage[indexOfPage].contains("argus-all-weather-tank")) {
			driver.findElement(By.id("qty")).clear();
			driver.findElement(By.id("qty")).sendKeys("4");
			driver.findElement(By.xpath(pathSize[indexOfSize])).click();
			driver.findElement(By.xpath(pathColorArgusAllWeatherTank[indexOfArgusAllWeatherTank])).click();
			Thread.sleep(2000);
			addToCart.click();

		} else if (urlPage[indexOfPage].contains("hero-hoodie")) {
			driver.findElement(By.id("qty")).clear();
			driver.findElement(By.id("qty")).sendKeys("1");
			Thread.sleep(2000);
			driver.findElement(By.xpath(pathSize[indexOfSize])).click();
			driver.findElement(By.xpath(pathColorHeroHoodie[indexOfHeroHoodie])).click();
			Thread.sleep(2000);
			addToCart.click();

		} else if (urlPage[indexOfPage].contains("fusion-backpack")) {
			driver.findElement(By.id("qty")).clear();
			driver.findElement(By.id("qty")).sendKeys("5");
			Thread.sleep(2000);
			addToCart.click();

			if (!addToCart.isSelected()) {
				driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();
			}
		}
	}

	@Test(priority = 2)
	public void Checkout() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/div/div[1]")).click();
		Thread.sleep(5000);

		String cartSubTotal = driver.findElement(By.cssSelector("span[data-th='Cart Subtotal']")).getText();
		Thread.sleep(5000);

		if (driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[2]/th/span[1]"))

				.isDisplayed()) {
			Thread.sleep(5000);

			String Discount = driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[2]/td/span"))
					.getText();
			String Ordertotal = driver.findElement(By.cssSelector("strong span[class='price']")).getText();
			Thread.sleep(5000);
			String cartSubTotalWithout$ = cartSubTotal.replace("$", "");
			String DiscountWithout$ = Discount.replace("$", "");
			String OrdertotalWithout$ = Ordertotal.replace("$", "");

			String cartSubTotalFinal = cartSubTotalWithout$.replace(",", "");
			String DiscountFinal = DiscountWithout$.replace(",", "");
			String OrdertotalFinal = OrdertotalWithout$.replace(",", "");

			double numOfCartSubTotal = Double.parseDouble(cartSubTotalFinal);
			double numOfDiscount = Double.parseDouble(DiscountFinal);
			double numOfOrdertotal = Double.parseDouble(OrdertotalFinal);
			double expectedTotal = numOfCartSubTotal + numOfDiscount;
			SoftAssert myAssert = new SoftAssert();
			myAssert.assertEquals(expectedTotal, numOfOrdertotal);
			myAssert.assertAll();
			driver.findElement(
					By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"))
					.click();

		} else {

			Thread.sleep(5000);
			String Ordertotal = driver.findElement(By.cssSelector("strong span[class='price']")).getText();
			Thread.sleep(5000);
			String Shipping = driver.findElement(By.cssSelector("span[data-th='Shipping']")).getText();

			String cartSubTotalWithout$ = cartSubTotal.replace("$", "");
			String OrdertotalWithout$ = Ordertotal.replace("$", "");
			String ShippingWithout$ = Shipping.replace("$", "");

			String cartSubTotalFinal = cartSubTotalWithout$.replace(",", "");
			String OrdertotalFinal = OrdertotalWithout$.replace(",", "");
			String ShippingFinal = ShippingWithout$.replace(",", "");

			double numOfCartSubTotal = Double.parseDouble(cartSubTotalFinal);
			double numOfOrdertotal = Double.parseDouble(OrdertotalFinal);
			double numOfShipping = Double.parseDouble(ShippingFinal);

			double expectedTotal = numOfCartSubTotal;
			SoftAssert myAssert = new SoftAssert();
			myAssert.assertEquals(expectedTotal + numOfShipping, numOfOrdertotal);
			myAssert.assertAll();
			driver.findElement(
					By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"))
					.click();

		}

	}
//
//	@Test(priority = 3)
//	public void Reorder() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://magento.softwaretestingboard.com/sales/order/history/");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[2]")).click();
//		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click();
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input"))
//				.click();
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
//
//	}

	@AfterTest
	public void close() throws IOException, InterruptedException {
//		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0,10)");
//		Date myDate = new Date();
//		String myDateupdate = myDate.toString();
//		String newDateformat = myDateupdate.replace(":", "-");
//		TakesScreenshot scrShot = ((TakesScreenshot) driver);
//		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//		File DestFile = new File("./screenshot/"+newDateformat+".jpg");
//		FileUtils.copyFile(SrcFile, DestFile);
		
		
		

	}

}
