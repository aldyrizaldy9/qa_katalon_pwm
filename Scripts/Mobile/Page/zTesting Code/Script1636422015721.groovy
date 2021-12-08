import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidKeyCode

import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Mobile/Page/Run App/Run App byID'), [:], FailureHandling.STOP_ON_FAILURE)

////get element position
//TestObject object = findTestObject('null')
//
//int top = Mobile.getElementTopPosition(object, 0)
//int left = Mobile.getElementLeftPosition(object, 0)
//int width = Mobile.getElementWidth(object, 0)
//int height = Mobile.getElementHeight(object, 0)
//int x = width/2
//int y = top + height/2
//
//System.out.println('top : ' + top)
//System.out.println('left : ' + left)
//System.out.println('width : ' + width)
//System.out.println('height : ' + height)
//System.out.println('x : ' + x)
//System.out.println('y : ' + y)
//
//Mobile.tapAtPosition(x, y)

int i = 1

while (Mobile.verifyElementExist(findTestObject('Mobile/Page/Home/Container - Watchlist'), 0)) {
	TestObject watchlist = findTestObject('Mobile/Page/Home/Container - Watchlist')
	int left = Mobile.getElementLeftPosition(watchlist, 0)
	int top = Mobile.getElementTopPosition(watchlist, 0)
	int width = Mobile.getElementWidth(watchlist, 0)
	int height = Mobile.getElementHeight(watchlist, 0)
	
	int x = left + width * 0.9
		int y = top + 52
	
	System.out.println('top : ' + top)
	System.out.println('left : ' + left)
	System.out.println('width : ' + width)
	System.out.println('height : ' + height)
	System.out.println('x : ' + x)
	System.out.println('y : ' + y)
	
	Mobile.tapAtPosition(x, y)
	i++
}

	

		