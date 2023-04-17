package sel1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBr {
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Student\\FST\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Student\\FST\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Browser is not correct");
		}
	}
	
	@Test
	public void petStoreTC1() throws InterruptedException {
		driver.get("https://petstore.octoperf.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Enter the Store")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Sign")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'ripe')]")).sendKeys("j2ee");
		Thread.sleep(3000);
		driver.findElement(By.name("signon")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
