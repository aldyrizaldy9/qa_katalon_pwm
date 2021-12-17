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

WebUI.callTestCase(findTestCase('Mobile/Page/CheckLogin'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Mobile/Page/Home/Menubar - News'), 0)
Mobile.delay(1)

for (int i = 0; i < 1; i++) {
	if (tab == 'macronews') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - Macro'), 0)
	} else if (tab == 'stocknews') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - Stock'), 0)
	} else if (tab == 'fundnews') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - Fund'), 0)
	} else if (tab == 'bondnews') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Tab - Bond'), 0)
	} else if (tab == 'worldindices') {
		CustomKeywords.'scroll.scroll.scrollScreenRightToLeft'(findTestObject('Object Repository/Mobile/Page/News/Tab - Macro'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/News/Tab - World Indices'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/News/Button - Indices'), 0)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Mobile/Page/News/Button - Currencies'), 0)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Mobile/Page/News/Button - Commodities'), 0)
		Mobile.delay(3)
	}
	
	Mobile.delay(1)
	
	if (tab != 'worldindices') {
		try {
			Mobile.tapAndHold(findTestObject('Mobile/Page/News/Item - Top News'), 1, 10)
			Mobile.delay(1)
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(3)
		} catch (Exception e) {
			
		}
	}
}