package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerExtranet {
	
	WebDriver driver=null;

	//HighLight the WebElement 
	public static void highLightElement(WebDriver driver, WebElement element)	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid darkblue;');", element);
 
		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) {
 
			System.out.println(e.getMessage());
		} 
 
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px blue');", element); 
 
	}
	
	@Given("^I navigate to the Intertek website$")
	public void i_navigate_to_the_omayo_website() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://172.22.6.15:6200/Login");
		
		Thread.sleep(2000);
		WebElement advanced_btn= driver.findElement(By.id("details-button"));
		highLightElement(driver,advanced_btn);
		advanced_btn.click();
		
		Thread.sleep(2000);
		WebElement proceed_link=driver.findElement(By.id("proceed-link"));
		highLightElement(driver,proceed_link);
		proceed_link.click();
	   
	}

	@When("^I enter Username as \"(.*)\" and Password as \"(.*)\" into the fields$")
	public void i_enter_Username_as_and_Password_as_into_the_fields(String username,String password) throws InterruptedException  {
	  
		//Enter the username in the field
		Thread.sleep(2000); 
		WebElement user_name=driver.findElement(By.id("username"));
		highLightElement(driver,user_name);
		user_name.sendKeys(username);
		
		//Enter the password in the field
		Thread.sleep(2000);
		WebElement pass=driver.findElement(By.id("password"));
		highLightElement(driver,pass);
		pass.sendKeys(password);
		
		
	}

	@And("^I click on Login button$")
	public void i_click_on_Login_button() throws InterruptedException  {
		
		Thread.sleep(2000);
		WebElement login_btn=driver.findElement(By.xpath("//button[@type='submit']"));
		highLightElement(driver,login_btn);
		login_btn.click(); 
	}
	
	@And("^I select the company with country \"([^\\\"]*)\" name$")
	public void i_select_the_company_with_country_name(String company) throws InterruptedException  {
		
		Thread.sleep(5000);
		WebElement dropdown=driver.findElement(By.xpath("(//select[@class='browser-default'])[1]"));
		Select select=new Select(dropdown);
		Thread.sleep(5000);
		select.selectByVisibleText(company);
		highLightElement(driver,dropdown);
	  
	} 
	
	@And("^I click on the equivalent submenu and click on the contract then click create contract$")
	public void i_clidwck_on_the_equivalent_submenu_and_click_on_the_contract_then_click_create_contract() throws InterruptedException {
		
		WebElement equivalent_submenu=driver.findElement(By.xpath("//i[@class='zmdi zmdi-menu']"));
		equivalent_submenu.click();	
		highLightElement(driver,equivalent_submenu);
		
		Thread.sleep(5000);
		WebElement click_on_contract=driver.findElement(By.xpath("//span[text()='Contract']"));
		click_on_contract.click();
		highLightElement(driver,click_on_contract);
		Thread.sleep(5000);
		
		Thread.sleep(5000);
		WebElement click_on_createcontract=driver.findElement(By.xpath("//a[text()='Create Contract']"));
		click_on_createcontract.click();
		highLightElement(driver,click_on_createcontract);
		Thread.sleep(5000);
		
		
		
		
	}

	
	
	
	
	
	
	

}
