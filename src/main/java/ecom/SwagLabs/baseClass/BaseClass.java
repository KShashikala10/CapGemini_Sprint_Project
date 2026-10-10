
package ecom.SwagLabs.baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ecom.SwagLabs.genericUtility.FileUtility;

public class BaseClass {

	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String browser) throws Exception {

		FileUtility fu = new FileUtility();

		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();

		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();

		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(fu.readDatafromPropertyFile("url"));
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {

		driver.quit();
	}
}