package vogue_SmokeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Vogue_MainClass extends PropertiesClass{
	//public WebDriver driver;
	 WebDriver driver;
	
	
	@BeforeTest
	public void Setup()
  {
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium-Java\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("Loading Zscalar page...");
		driver.get("https://wp.com");
	//	ExtentReports extent;
		//http://automationtesting.in/generating-extent-reports-java/

  }
@Test(priority=1)
	
	public void OpenVogueSite()
	{
		System.out.println("Loading Vogue Site");
		driver.get("https://www.vogue.com.au/");
	}
	
	
	//Login method
	  @Test(priority=2)
	  public void Test_login() throws InterruptedException
	  {
		  WebDriverWait wait = new WebDriverWait(driver,20);
		//Wait until "Login" link appears and click
				System.out.println("Click on the login link");
					WebElement LoginLink;
			LoginLink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='header-container']//a[contains(text(),'login')]")));
		LoginLink.click();
		Thread.sleep(2000);
		//Enter user name
		WebElement Username;
		Username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-gigya-name='loginID']")));
		Username.click();
		Username.sendKeys("testtheaus@gmail.com");
		String loginwindow=driver.getWindowHandle();
		System.out.println("loginwindow is : "+loginwindow);
		//Enter password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testtheaus1");
		//Click on Submit button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
	  }
	  @Test(priority=3)
	  public void Test_ContentPage() throws InterruptedException
	  {
		  WebDriverWait wait = new WebDriverWait(driver,20);
		//Wait until query posts load and click on first story headline
		  WebElement story1;
		  story1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-container']/div[1]//div[@class='content']//a[@class='card-title-link']")));
		  System.out.println("Click on the first post");
		  story1.click();
		  Thread.sleep(2000);
		  String currentURL=driver.getCurrentUrl();
		  
		  if(currentURL.contains("image-gallery"))
		  {
		  	System.out.println("This content has an image gallery");
		  	
		  if(driver.findElement(By.xpath("//div[@id='content-container']//div[@class='gallery']//h2[@class='gallery-header']")).isDisplayed())
		  {
		  	String GalleryHeader=driver.findElement(By.xpath("//div[@id='content-container']//div[@class='gallery']//h2[@class='gallery-header']")).getText();
		  	System.out.println("Gallery header displayed is:"+GalleryHeader);
		  }
		  //Locate Author name and display on console
		  System.out.println("//Locating Author name...");
		  WebElement Authorelement =driver.findElement(By.className("asset-author"));
		  if(Authorelement.isDisplayed())
		  {
		  	System.out.println("Auhtor asset is displayed. Author name is: "+Authorelement.getText());
		  }
		  
		  //published date
		  System.out.println("//Locating published date...");
		  WebElement Art_Pub_Date =driver.findElement(By.className("asset-publish-date"));
		  if(Authorelement.isDisplayed())
		  {
		  	System.out.println("Date is displayed. This article published on: "+Art_Pub_Date.getText());
		  }
		  
		  //Introduction or gallery description
		  System.out.println("//Locating introduction / gallery description...");
		  WebElement Gallery_Description =driver.findElement(By.className("gallery-description"));
		  if(Authorelement.isDisplayed())
		  {
		  	System.out.println("This article published on: "+Gallery_Description.getText());
		  }
		  
		  //Container 1 image
		  System.out.println("//Locating Container 1 element...");
		  WebElement Container1=driver.findElement(By.xpath("//picture[@id='gigya-share-image-1_gig_containerParent']"));
		  if(Container1.isDisplayed())
		  {
		  	System.out.println("Container 1 element is displayed");
		  }

		  }
		  
		  else if(currentURL.contains("news-story"))
		  {
			  System.out.println("This content has an news story");
			  if(driver.findElement(By.xpath("//h1[@class='article-title']")).isDisplayed())
					  {
				  String ArticleTitle=driver.findElement(By.xpath("//h1[@class='article-title']")).getText();
				  System.out.println("Article title is: "+ArticleTitle);
					  }
			  if(driver.findElement(By.xpath("//div[@class='date-block']//div[1]")).isDisplayed())
			  {
		  String PublishedDate=driver.findElement(By.xpath("//div[@class='date-block']//div[1]")).getText();
		  System.out.println("Published date is: "+PublishedDate);
			  }
			  
			  if(driver.findElement(By.xpath("//div[@class='byline']")).isDisplayed())
			  {
		  String byline=driver.findElement(By.xpath("//div[@class='byline']")).getText();
		  System.out.println("Author name is: "+byline);
			  }
			
			  if(driver.findElement(By.xpath("//div[@class='summary']")).isDisplayed())
			  {
		  String summary=driver.findElement(By.xpath("//div[@class='summary']")).getText();
		  System.out.println("Author name is: "+summary);
		  }
		  }
		 
		 
	  }

	  //After Test...
	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

}
