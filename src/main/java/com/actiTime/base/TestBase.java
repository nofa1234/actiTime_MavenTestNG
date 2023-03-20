package com.actiTime.base;

import com.actiTime.util.TestUtil;
import com.actiTime.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventlistner;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:/Users/96555/Desktop/ict18843/actiTime_MavenTestNG/src/main/java/com/actiTime/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/96555/Downloads/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:/Users/96555/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");
            driver = new FirefoxDriver();
        }

                e_driver = new EventFiringWebDriver(driver);
 
		eventlistner = new WebEventListener();
		e_driver.register(eventlistner);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
    }

}
