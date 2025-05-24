package maven_diares.MAven_single;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class HomePage {
	private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    private By Blog = By.xpath("//*[text()='Blog']"); // Example logo locator
    private By AboutUS = By.xpath("//*[text()='About Us']"); // Example login link locator
    private By Acquisitions = By.xpath("//*[text()='Acquisistions']"); // Example search input
    private By Home = By.xpath("//*[text()='Home']"); // Example search button");
    private By HomeLogo = By.xpath("//img[@class='hfe-site-logo-img elementor-animation-']"); // Example search button");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Wait for up to 15 seconds
        PageFactory.initElements(driver, this); // Initialize WebElements
        log.info("HomePage initialized.");
    }
    
    
    public boolean isLogoDisplayed(By byelement) {
        try {
            log.info("Checking if logo is displayed.");
            return wait.until(ExpectedConditions.visibilityOfElementLocated(byelement)).isDisplayed();
        } catch (Exception e) {
            log.error("Logo not displayed: " + e.getMessage());
            return false;
        }
    }
    
    public String getBlogTitle() {
        log.info("verifying the blog title link.");
        wait.until(ExpectedConditions.elementToBeClickable(Blog)).click();
        String blogTitle = driver.getTitle();
		return blogTitle;
        
    }
    public String aboutUSTitle() {
        log.info("verifying the aboutus link.");
        wait.until(ExpectedConditions.elementToBeClickable(AboutUS)).click();
        String aboutusTitle = driver.getTitle();
		return aboutusTitle;
        
    }
    
    public String acqTitle() {
        log.info("verifying the acq title link.");
        wait.until(ExpectedConditions.elementToBeClickable(Acquisitions)).click();
        String acqTitle = driver.getTitle();
		return acqTitle;
        
    }
    public String homeTitle() {
        log.info("verifying the home title link.");
        wait.until(ExpectedConditions.elementToBeClickable(Home)).click();
        String homeTitle = driver.getTitle();
		return homeTitle;
        
    }


	public boolean isLogoDisplayed() {
		try {
            log.info("Checking if logo is displayed.");
            return wait.until(ExpectedConditions.visibilityOfElementLocated(HomeLogo)).isDisplayed();
        } catch (Exception e) {
            log.error("Logo not displayed: " + e.getMessage());
            return false;
        }
    }
}
