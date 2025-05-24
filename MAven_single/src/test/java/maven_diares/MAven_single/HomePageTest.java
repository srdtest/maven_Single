package maven_diares.MAven_single;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;




public class HomePageTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(HomePageTest.class.getName());

    
    @Test(priority = 1, description = "Verify RNS Equity homepage loads and logo is displayed")
    public void verifyHomePageLoadAndLogo() {
        log.info("Starting verifyHomePageLoadAndLogo test.");
        HomePage homePage = new HomePage(getDriver()); // Get the WebDriver instance from BaseTest
        Assert.assertTrue(homePage.isLogoDisplayed(), "RNS Equity logo should be displayed on the homepage.");
        Assert.assertEquals(homePage.homeTitle(), "RNS Equity'.");
        log.info("verifyHomePageLoadAndLogo test completed successfully.");
    }

   
    @Test(priority = 2, description = "Verify the blogtitle")
    public void verifyBlogTitle() {
        log.info("Starting verifyBlogtitle.");
        HomePage homePage = new HomePage(getDriver());
        Assert.assertEquals(homePage.getBlogTitle(), "Blog", "Blog title should be 'Blog'.");
        
        log.info("Blogtitle verificarion test completed.");
    }
    @Test(priority = 3, description = "Verify the Acquisition title")
    public void verifyAcqTitle() {
        log.info("Starting verifyBlogtitle.");
        HomePage homePage = new HomePage(getDriver());
        Assert.assertEquals(homePage.acqTitle(), "Acquisitions", "Blog title should be 'Acquisistions'.");
        
        log.info("Acquisitions verificarion test completed.");
    }
}
