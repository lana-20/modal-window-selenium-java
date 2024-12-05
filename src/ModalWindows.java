import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class ModalWindows {

	static protected WebDriver driver;

	public static void main(String[] args) {
		chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/entry_ad");
		WebElement modal = driver.findElement(By.xpath("//div[@class='modal']"));
		
		var wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(modal));
		
		if (modal.isDisplayed()) {
			System.out.println("modal is displayed");
			driver.findElement(By.xpath("//p[normalize-space()='Close']")).click();
		} else
			System.out.println("modal is not displayed");
		
		driver.quit();
	}

}