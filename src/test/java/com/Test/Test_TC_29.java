package com.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_TC_29 {
	static void main(String[] args) throws Exception{
		   
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.amazon.in/?ref_=nav_ya_signin&");
			driver.manage().window().maximize();
			
			WebElement serch=driver.findElement(By.xpath("//input[@type='text']"));
		    serch.sendKeys("iphone14");
		    
		    WebElement Sub=driver.findElement(By.xpath("//input[@type='submit']"));
		    Sub.click();
			
	        String ParentID=driver.getWindowHandle(); // parent window id -- string 
			
			System.out.println("Parent window ID=="+ParentID);
			
			driver.findElement(By.xpath("//img[@alt='Apple iPhone 14 (256 GB) - Midnight']")).click();
			
			Set<String> AllID=driver.getWindowHandles(); // Parent +child Window ID
			
			System.out.println("All Window ID =="+AllID);
			
			List<String> list=new ArrayList<String>(AllID);
			
			System.out.println(list.get(0)); // parent window id 
			System.out.println(list.get(1)); // child window id 
			
			driver.switchTo().window(list.get(1)); // Switch to Child window 
		    
		    WebElement add=driver.findElement(By.xpath("//input[@id='buy-now-button']"));
		    add.click();
		    
	    }

	}	



