package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   @Test
   public void openHeadlessBrowser(){
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
   }
}
