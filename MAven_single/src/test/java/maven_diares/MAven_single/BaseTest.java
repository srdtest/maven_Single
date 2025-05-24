package maven_diares.MAven_single;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
public static WebDriver driver;
public Properties prop;
public static final Logger log = LogManager.getLogger(BaseTest.class.getName());
public ExtentReports extent;
// ExtentTest instance for the current test method
public ExtentTest test;
public BaseTest() {
    prop = new Properties();
    try {
        // Load data.properties from src/main/resources
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/maven_diares.MAven_Single/data.properties");
        prop.load(fis);
    } catch (IOException e) {
        log.error("Error loading data.properties: " + e.getMessage());
        e.printStackTrace();
    }
    
}
public WebDriver initializeDriver(String browser) throws IOException {
    log.info("Initializing WebDriver for browser: " + browser);

       if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            log.info("Chrome WebDriver initialized.");
            return driver;
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            log.info("Firefox WebDriver initialized.");
            return driver;
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            log.info("Edge WebDriver initialized.");
            return driver;
    } else {
        log.error("Invalid browser specified in data.properties: " + browser);
        throw new IllegalArgumentException("Invalid browser name: " + browser);
    }
}
public static WebDriver getDriver() {
	if (driver == null) {
		log.error("WebDriver is not initialized. Call initializeDriver() first.");
		throw new IllegalStateException("WebDriver is not initialized. Call initializeDriver() first.");
	}
	return driver;
}
@BeforeMethod
@Parameters("browser") // Expecting browser parameter from testng.xml
public void setup(@Optional("chrome") String browser, Method method) throws IOException {
    log.info("Setting up test: " + method.getName());
    initializeDriver(browser);
    getDriver().get("https://rnsequity.com/"); // Navigate to the base URL");
    log.info("Navigated to URL: " + prop.getProperty("baseUrl"));
}

@AfterMethod
public void tearDown(ITestResult result) {
    log.info("Tearing down after test: " + result.getMethod().getMethodName());
    if (getDriver() != null) {
        getDriver().quit();
        // Remove driver from ThreadLocal
        log.info("WebDriver quit successfully.");
    }
}


}
