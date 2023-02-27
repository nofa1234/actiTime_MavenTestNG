package com.ict18821.base;

import com.ict18821.util.TestUtil;
import com.ict18821.util.WebEventListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class TestBase {
    public static Logger logger = Logger.getLogger(TestBase.class);
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventlistner;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("G:\\EDUCATION\\8th semester\\ITS4202 Emerging Technologies\\Assignment\\ICT18821_MavenTestNG\\src\\main\\java\\com\\ict18821\\config\\config.properties");
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
            System.setProperty("webdriver.chrome.driver", "G:\\EDUCATION\\8th semester\\ITS4202 Emerging Technologies\\SW\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "G:\\EDUCATION\\8th semester\\ITS4202 Emerging Technologies\\SW\\chromedriver_win32\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        eventlistner = new WebEventListener();
        e_driver.register(eventlistner);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }

}
