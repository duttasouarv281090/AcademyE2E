package HelperClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryFailedCases implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		int count=0;
		int maxretry=3;
		if(count<maxretry)
		{
			count++;
			return true;
		}
		return false;
	}

}


	

