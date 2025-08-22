package StepDefination;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountActivitySteps {
	WebDriver driver;
	@Given("user logged in")
	public void user_logged_in() {
		driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on account activity link and click on sub module pay bill")
	public void click_on_account_activity_link_and_click_on_sub_module_pay_bill() {
		driver.findElement(By.id("account_activity_link")).click();
		driver.findElement(By.id("user_login")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).click();
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.id("account_activity_link")).click();
		driver.findElement(By.xpath("//*[@id=\"pay_bills_tab\"]/a")).click();
	   
	}

	@And("Choose payee , account and amount then select date from new window and add description")
	public void choose_payee_account_and_amount_then_select_date_from_new_window_and_add_description() {
	  driver.findElement(By.id("sp_payee")).click();
		driver.findElement(By.cssSelector("select>option[value=\"bofa\"]")).click();
	  driver.findElement(By.cssSelector("select>option[value=\"3\"]")).click();
	  driver.findElement(By.id("sp_amount")).click();
	  driver.findElement(By.id("sp_amount")).sendKeys("2000");
	  driver.findElement(By.id("sp_date")).click();
	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
	}

	@And("click or enter on pay button")
	public void click_or_enter_on_pay_button() {
		driver.findElement(By.id("sp_description")).click();
		driver.findElement(By.id("sp_description")).sendKeys("Wifi Bill");
		driver.findElement(By.id("pay_saved_payees")).click();
		String submitmsg=driver.findElement(By.xpath("//*[@id=\"alert_content\"]")).getText();
		System.out.println(submitmsg);
	   
	}

	@Then("payment done")
	public void payment_done() {
	   
	}

}
