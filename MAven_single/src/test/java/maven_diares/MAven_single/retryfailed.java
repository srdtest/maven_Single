package maven_diares.MAven_single;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryfailed implements IRetryAnalyzer {
  private int retryCount = 0;
  private int maxRetryCount = 3; // Set the maximum number of retries
	

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (retryCount < maxRetryCount) {
			retryCount++;
			System.out.println("Retrying test " + result.getName() + " for the " + retryCount + " time.");
			return true; // Retry the test
		}
		return false;
	}

}
