import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.internal.Exceptions
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//check if button login available
def loginCheck = Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Page/Login/Button - Login'), 2, FailureHandling.CONTINUE_ON_FAILURE)
if (loginCheck) {
	WebUI.callTestCase(findTestCase('Mobile/Page/Login/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Menubar - News'), 0)
Mobile.delay(1)

for (int i = 0; i < 1; i++) {
	if (tab == 'macronews') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - Macro News'), 0)
	} else if (tab == 'stocknews') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - Stock News'), 0)
	} else if (tab == 'fundnews') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - Fund News'), 0)
	} else if (tab == 'bondnews') {
		CustomKeywords.'scroll.scroll.scrollScreenRightToLeft'(findTestObject('Object Repository/Mobile/Page/News/Tab - Macro News'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - Bond News'), 0)
	} else if (tab == 'worldindices') {
		CustomKeywords.'scroll.scroll.scrollScreenRightToLeft'(findTestObject('Object Repository/Mobile/Page/News/Tab - Macro News'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - World Indices'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Button - Indices'), 0)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Button - Currencies'), 0)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Button - Commodites'), 0)
		Mobile.delay(3)
	}
	
	Mobile.delay(1)
	
	if (tab != 'worldindices') {
		try {
			def topnews = Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Page/News/Item - Top News'), 0)
			
			if (topnews) {
				Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/News/Item - Top News'), 1, 0)
				Mobile.delay(1)
				CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
				Mobile.delay(3)
			}
		} catch (Exception e) {
			
		}
	}
}