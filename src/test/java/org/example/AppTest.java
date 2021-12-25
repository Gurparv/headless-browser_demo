package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   @Test
   public void openChromeHeadless(){
      WebDriverManager.chromedriver().setup();
      ChromeOptions op = new ChromeOptions();
      op.addArguments("--headless");
      WebDriver driver = new ChromeDriver(op);
      driver.manage().window().maximize();
      try {
         System.out.println("Navigate to Google.com using Chrome headless browser");
         driver.get("https://google.com");
         System.out.println("check the page Title");
         Assert.assertEquals(driver.getTitle(), "Google");
         System.out.println("Page title = Google");
         System.out.println("Quit browser");
      } catch (Exception ex){
         System.out.println("Do nothing");
      } finally {
         driver.quit();
      }
   }

}
