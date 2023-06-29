package testngBasics;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListener implements ITestListener {

	public void onTestFailure(ITestResult result) {

		System.out.println("The test has failed....... msg from interface!");

	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("passed.... message from interface");
	}

}
