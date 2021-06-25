package org.angel.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main
{

	public static void main(String[] args) throws InterruptedException
	{


		System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\selenium\\browserDrivers\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");


		driver.manage().window().maximize();
		Thread.sleep(1000);
		//this xpath is for accept turns and conditions
		driver.findElementByXPath("/html/body/div[2]/div[2]/div[3]/span/div/div/div[3]/button[2]/div").click();

		//this xpath is leading ot search field
		driver.findElementByXPath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input").click();


		driver.findElementByXPath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input").sendKeys("Alphabet share price" + Keys.ENTER);

		if (driver.findElementByXPath("//span[text()='Alphabet Inc.']") !=null)
		{
			//assert faile
			System.out.println("Alphabet Inc. not found!");
		}

		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Alphabet Inc.")).click();




		//driver.close();


	}

}
