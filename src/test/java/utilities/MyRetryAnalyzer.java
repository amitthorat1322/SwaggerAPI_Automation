package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	private int retryCount = 0;
	private static final int max = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(retryCount < max )
		{
			retryCount++;
			return true;
		}
		return false;
	}

	
	
}
