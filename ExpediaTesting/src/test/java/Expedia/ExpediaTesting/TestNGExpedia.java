package Expedia.ExpediaTesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;


public class TestNGExpedia {
	
	public WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//span[@class='uitk-tab-text' and text()='Flights']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//span[@class='uitk-tab-text' and text()='Roundtrip']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@aria-label='Leaving from']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='location-field-leg1-origin']")).sendKeys("IAD");
	  Thread.sleep(1000);
	  List<WebElement> list = driver.findElements(By.xpath("//ul[@data-stid='location-field-leg1-origin-results']//li/descendant::div[@class='truncate']"));
	  System.out.println(list.size());
	  for(int i=0; i<list.size(); i++) {
		  System.out.println(list.get(i).getText());
		  if(list.get(i).getText().contains("Washington (IAD - Washington Dulles Intl.)")){
			  list.get(i).click();
			  break;
		  }
	  }
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@aria-label='Going to']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='location-field-leg1-destination']")).sendKeys("ANK");
	  Thread.sleep(1000);
	  List<WebElement> list2 = driver.findElements(By.xpath("//ul[@data-stid='location-field-leg1-destination-results']//li/descendant::div[@class='truncate']"));
	  System.out.println(list2.size());
	  for(int i=0; i<list2.size(); i++) {
		  System.out.println(list2.get(i).getText());
		  if(list2.get(i).getText().contains("Ankara (ESB - Esenboga)")){
			  list2.get(i).click();
			  break;
		  }
	  }
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@id='d1-btn']")).click();
	  Thread.sleep(1000);

	  driver.findElement(By.xpath("//button[@class='uitk-date-picker-day uitk-new-date-picker-day' and @aria-label='Feb 09, 2022']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@class='uitk-date-picker-day uitk-new-date-picker-day' and @aria-label='Mar 12, 2022']")).click();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@data-testid='submit-button']")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//button[@data-test-id='select-link'][2]")).click();

	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//button[@data-test-id='select-button']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@data-test-id='select-link'][2]")).click();
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@data-test-id='select-button']")).click();
	  Thread.sleep(3000);
	  

	  driver.findElement(By.id("firstname[0]")).sendKeys("Selin");
	  driver.findElement(By.id("lastname[0]")).sendKeys("Ozbek");
	  Thread.sleep(3000);
	  driver.findElement(By.id("country_code[0]")).click();
	  
	  driver.findElement(By.id("phone-number[0]")).sendKeys("4678954322");
	  driver.findElement(By.id("gender_mail[0]")).click();
	  
	  
	  

  }
  
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  String local = System.getProperty("user.dir");
	  System.setProperty("webdriver.edge.driver", local+"\\src\\Drivers\\msedgedriver.exe");
	  //System.setProperty("webdriver.chrome.driver", local+"\\src\\Drivers\\chromedriver.exe");
	  driver = new EdgeDriver();
	 //driver=new ChromeDriver();
	  driver.get("https://www.expedia.com/");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  Thread.sleep(2000);
	  Object url = driver.getCurrentUrl();
	  System.out.println("current url is====> "+url);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	  }
  

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.close();
	  
  }

  }

