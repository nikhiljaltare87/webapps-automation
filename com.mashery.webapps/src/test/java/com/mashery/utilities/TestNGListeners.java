package com.mashery.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Started Test:" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed Test:" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Test:" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped Test:" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
