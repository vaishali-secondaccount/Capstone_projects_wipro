package Jenkins_package;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Freshtest {
	WebDriver driver;
	  @Test
	  public void f() {
		  driver=new ChromeDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.close();
	  }
}
