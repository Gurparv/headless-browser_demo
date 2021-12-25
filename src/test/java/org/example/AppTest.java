package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   private WebDriver driver = null;

   @Test
   public void openChromeHeadless(){
      WebDriverManager.chromedriver().setup();
      ChromeOptions op = new ChromeOptions();
      op.addArguments("--headless");
      driver = new ChromeDriver(op);
      driver.manage().window().maximize();
      try {
         System.out.println("Navigate to Google.com using Chrome headless browser");
         driver.get("https://google.com");
         System.out.println("Take screenshot of page.");
         takesScreenShot("Check Page Title.");
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

   @Test
   public void openPhantomJSHeadless(){
      DesiredCapabilities cp = new DesiredCapabilities();
      cp.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,System.getProperty("user.dir")+"\\phantomjs.exe");
      driver = new PhantomJSDriver(cp);
      try {
         System.out.println("Navigate to Google.com using Chrome headless browser");
         driver.get("https://google.com");
         System.out.println("Take screenshot of page.");
         takesScreenShot("Check Page Title.");
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

   private void takesScreenShot(String checkName){
      TakesScreenshot screenshot = (TakesScreenshot) driver;
      File file = screenshot.getScreenshotAs(OutputType.FILE);
      File Destfile= new File(System.getProperty("user.dir")+"\\screenshots\\"+
              checkName+""+System.currentTimeMillis()+".png");
      try{
         FileUtils.copyFile(file,Destfile);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

}
